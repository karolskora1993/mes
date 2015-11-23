package mes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Calculations {

	private GlobalData globalData;
	private FemGrid femGrid;
	private Element[] elements;
	private Node[] nodes;
	private int ne;
	private double l=0;

	public void setMaterialData() {
		
			System.out.println("Wczytuje dane węzłów z pliku");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();

				File file = new File(getFileName());
				Document doc = builder.parse(file);
				doc.getDocumentElement().normalize();
				NodeList nodeList = doc.getElementsByTagName("element");

				ne = nodeList.getLength();
				elements = new Element[ne];
				nodes=new Node[ne+1];
				for (int i = 0; i < nodeList.getLength(); i++) {
					org.w3c.dom.Node node = nodeList.item(i);

					if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
						org.w3c.dom.Element el = (org.w3c.dom.Element) node;
						NodeList children =el.getChildNodes();
						double se=0;
						double ke=0;
						double le=0;
						int id=0;
						double alfa = 0;
						double q =0;
						
						for(int j=0; j<children.getLength();j++){
							if(!(j%2==0)){
								org.w3c.dom.Node nd=children.item(j);
								if(nd.getNodeName().equals("id")){
									id=Integer.parseInt(nd.getTextContent());
									System.out.println("Wczytuje id="+id);
								}
								if(nd.getNodeName().equals("dlugosc")){
									le=Double.parseDouble(nd.getTextContent());
									System.out.println("Wczytuje dlugosc="+le);
								}
								if(nd.getNodeName().equals("wspolczynnik_przewodzenia")){
									ke=Double.parseDouble(nd.getTextContent());
									System.out.println("Wczytuje wspolczynnik przewodzenia="+ke);
								}
								if(nd.getNodeName().equals("przekroj")){
									se=Double.parseDouble(nd.getTextContent());
									System.out.println("Wczytuje przekroj="+se);
								}
								if(i==0 || i==(nodeList.getLength()-1)){
									if(nd.getNodeName().equals("alfa")){
										alfa=Double.parseDouble(nd.getTextContent());
										System.out.println("Wczytuje alfa="+alfa);
									}
									if(nd.getNodeName().equals("q")){
										q=Double.parseDouble(nd.getTextContent());
										System.out.println("Wczytuje q="+q);
								}
								}
								
							}
						}
						if(i==0)
						{
							nodes[0]=new Node(q, alfa, l);
							l+=le;
							nodes[1]=new Node(0,0,l);
						}
						else if(i==(nodeList.getLength()-1))
						{
							l+=le;
							nodes[i+1]=new Node(q, alfa, l);
						}
						else
						{
							l+=le;
							nodes[i+1]=new Node(0,0,l);
						}
						elements[i]=new Element(nodes[i], nodes[i+1], se, ke, le);
					}
				}

			} catch (ParserConfigurationException | SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void setGlobalData() {
		try(Scanner in=new Scanner(System.in)){
		double tEnv=in.nextDouble();
		double sumK=0;
		double sumS=0;
		for(int i=0; i<ne;i++){
			sumK+=elements[i].getKe();
			sumS+=elements[i].getSe();
		}
		globalData=new GlobalData(ne, ne+1, l, sumK/ne, sumS/ne, tEnv);
		}
		
	}

	public String getFileName() {
		System.out.println("Podaj nazwe pliku z danymi :");

		try (Scanner in = new Scanner(System.in)) {

			String name = in.nextLine();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(name);
			stringBuilder.append(".xml");
			String fileName = stringBuilder.toString();
			return fileName;
		}
	}
	public void setBoundaryConditions(){
		System.out.println("Podaj warunki brzegowe:");
		double q1,alfa1,q2,alfa2;
		try(Scanner in=new Scanner(System.in)){
			
		}
	}
	public void setLocalMatrix(){
		for(int i=0;i<ne;i++){
			elements[i].setLocalMatrix(globalData);
		}
	}
}
