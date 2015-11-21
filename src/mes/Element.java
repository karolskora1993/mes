package mes;

public class Element {
	
	private Node firstNode;
	private Node secondNode;
	private double se;
	private double ke;
	private double le;
	private double c;
	private double[][] hl=new double[2][2];
	private double[][] pl=new double[1][2];
	
	public Element(Node firstNode, Node secondNode, double se, double ke, double le) {
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.se = se;
		this.ke = ke;
		this.le = le;
	}

	
	
}
