package mes;

public class Element {
	
	private Node firstNode;
	private Node secondNode;
	private double se;
	private double ke;
	private double le;
	private double c;
	private double[][] hl=new double[2][2];
	private double[][] pl=new double[2][1];
	
	public Element(Node firstNode, Node secondNode, double se, double ke, double le) {
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.se=se;
		this.ke = ke;
		this.le = le;
	}

	public double getSe() {
		return se;
	}
	public double getKe() {
		return ke;
	}
	public double getLe() {
		return le;
	}
	
	public void setLocalMatrix(GlobalData globalData){
		c=(se*ke)/le;
		hl[0][0]=c;
		hl[0][1]=-c;
		hl[1][0]=-c;
		hl[1][1]=c;
		
		if(firstNode.getAlfa()!=0){
		hl[0][0]+=firstNode.getAlfa() * se;

		pl[0][0]=-firstNode.getAlfa()*globalData.getTEnv()*se;
		pl[1][0]=0;
		}
		else if(secondNode.getAlfa()!=0){
			hl[1][1]=c + secondNode.getAlfa() * se;
			
			pl[1][0]=secondNode.getAlfa()*globalData.getTEnv()*se;
		}
		
		if(firstNode.getQ()!=0)
			pl[0][0]+=firstNode.getQ()*se;
		else if(secondNode.getQ()!=0)
			pl[1][0]+=secondNode.getQ()*se;
		
	}
	public double getHlIndex(int index1, int index2){
		return hl[index1][index2];
	}
	public double getPlIndex(int index){
		return pl[index][0];
	}


	
	
}
