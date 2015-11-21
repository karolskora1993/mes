package mes;

public class Node {
	private int temperature;
	private int boundaryCondition;
	private double x;
	private int id;
	
	public Node(int _id, int _boundaryCondition, double _x){
		id=_id;
		boundaryCondition=_boundaryCondition;
		x=_x;
	}

}
