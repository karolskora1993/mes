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
	private int l=0;

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
						NodeList nodes =el.getChildNodes();
						double se;
						double ke;
						double le;
						int id;
						double alfa;
						double q;
						
						for(int j=0; j<nodes.getLength();j++){
							if(!(j%2==0)){
								org.w3c.dom.Node nd=nodes.item(j);
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
								
							}
						}
						//elements[i]=new Element(id, le, ke, se);
					}
				}

			} catch (ParserConfigurationException | SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void setGlobalData() {

	}

	public void solveSystemOfEquations() {

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
}
