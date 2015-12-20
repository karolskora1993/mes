package mes;


public class GlobalData {
	private  int ne;
	private  int nh;
	private  double l;
	private double tEnv1;
	private double tEnv2;
	
	public GlobalData(int ne, int nh, double l, double tEnv1, double tEnv2) {
		this.ne = ne;
		this.nh = nh;
		this.l = l;
		this.tEnv1=tEnv1;
		this.tEnv2=tEnv1;
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
		return tEnv1;
	}
	public double getTEnv2(){
		return tEnv2;
	}


}
