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
	
	public Node getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}
	public Node getSecondNode() {
		return secondNode;
	}
	public void setSecondNode(Node secondNode) {
		this.secondNode = secondNode;
	}
	public double getSe() {
		return se;
	}
	public void setSe(double se) {
		this.se = se;
	}
	public double getKe() {
		return ke;
	}
	public void setKe(double ke) {
		this.ke = ke;
	}
	public double getLe() {
		return le;
	}
	public void setLe(double le) {
		this.le = le;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public double[][] getHl() {
		return hl;
	}
	public void setHl(double[][] hl) {
		this.hl = hl;
	}
	public double[][] getPl() {
		return pl;
	}
	public void setPl(double[][] pl) {
		this.pl = pl;
	}
}
