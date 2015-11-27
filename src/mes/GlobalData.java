package mes;


public class GlobalData {
	private  int ne;
	private  int nh;
	private  double l;
	private double tEnv;
	
	public GlobalData(int ne, int nh, double l, double tEnv) {
		this.ne = ne;
		this.nh = nh;
		this.l = l;
		this.tEnv=tEnv;
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

	public double getTEnv(){
		return tEnv;
	}


}
