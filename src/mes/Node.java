package mes;

public class Node {
	private int temperature;
	private int boundaryCondition;
	private double x;
	private int id;
	private double q;
	private double alfa;
	
	public Node(double _q, double _alfa, double _x){
		q=_q;
		alfa=_alfa;
		x=_x;
		if(alfa!=0)
			boundaryCondition=1;
		else if(q!=0)
			boundaryCondition=2;
		else
			boundaryCondition=0;
	}
	
	public double getQ(){
		return q;
	}
	public double getAlfa(){
		return alfa;
	}

}
