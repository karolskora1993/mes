package mes;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FemGrid {
	
	private Element[] elements;
	private Node[] nodes;
	
	public FemGrid(Element[] elements, Node[] nodes) {
		super();
		this.elements = elements;
		this.nodes = nodes;
	}
	public void setlocalMatrix(GlobalData globalData){
		for(int i=0; i<elements.length;i++){
			elements[i].setLocalMatrix(globalData);
		}
	}
	public Element[] getElements(){
		return elements;
	}
	
	public Node[] getNodes(){
		return nodes;
	}
	
}
