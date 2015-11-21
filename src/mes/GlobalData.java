package mes;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GlobalData {
	
	private static int ne;
	private static int nh;
	private static double l;
	private static double k;
	private static double s;
	
	public GlobalData(String fileName){
		System.out.println("Wczytuje dane globalne z pliku");

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			
			File file=new File(fileName);
			Document doc=builder.parse(file);
			
			org.w3c.dom.Element root=doc.getDocumentElement();
			
			NodeList nodes=root.getChildNodes();
			
			for(int i=0; i<nodes.getLength();i++){
				if(!(i%2==0)){
					org.w3c.dom.Node node=nodes.item(i);
					if(node.getNodeName().equals("ilosc_elementow")){
						ne=Integer.parseInt(node.getTextContent());
						nh=ne+1;
						System.out.println("Wczytuje ne="+ne);
					}
					if(node.getNodeName().equals("calkowita_dlugosc")){
						l=Double.parseDouble(node.getTextContent());
						System.out.println("Wczytuje l="+l);
					}
					if(node.getNodeName().equals("wspolczynnik_przewodzenia")){
						k=Double.parseDouble(node.getTextContent());
						System.out.println("Wczytuje k="+k);
					}
					if(node.getNodeName().equals("przekroj")){
						s=Double.parseDouble(node.getTextContent());
						System.out.println("Wczytuje s="+s);
					}
				}
			}
			
			
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public  int getNe() {
		return ne;
	}

	public  int getNh() {
		return nh;
	}

	public  double getL() {
		return l;
	}

	public  double getK() {
		return k;
	}

	public  double getS() {
		return s;
	}


}
