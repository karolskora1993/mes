package mes;

public class FemGrid {
	private Element[] elements=new Element[GlobalData.getNe()];
	private Node[] nodes=new Node[GlobalData.getNh()];
	public Element[] getElements() {
		return elements;
	}
	public void setElements(Element[] elements) {
		this.elements = elements;
	}
	public Node[] getNodes() {
		return nodes;
	}
	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}
}
