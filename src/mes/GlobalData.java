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
