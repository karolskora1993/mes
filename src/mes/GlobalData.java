package mes;


public class GlobalData {
	private  int ne;
	private  int nh;
	private  double l;
	private  double k;
	private  double s;
	private double tEnv;
	
	public GlobalData(int ne, int nh, double l, double k, double s, double tEnv) {
		this.ne = ne;
		this.nh = nh;
		this.l = l;
		this.k = k;
		this.s = s;
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

	public  double getK() {
		return k;
	}

	public  double getS() {
		return s;
	}
	public double getTEnv(){
		return tEnv;
	}


}
