package mes;

public class Node {
	private int temperature;
	private int boundaryCondition;
	private double x;
	private int id;
	
	public Node(int _id, int _boundaryCondition, double le){
		id=_id;
		boundaryCondition=_boundaryCondition;
		x=le*id;
	}

}
