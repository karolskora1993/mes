package mes;


public class GlobalData {
	private  int ne;
	private  int nh;
	private  double l;
	private  double k;
	private  double s;
	
	public GlobalData(int ne, int nh, double l, double k, double s) {
		this.ne = ne;
		this.nh = nh;
		this.l = l;
		this.k = k;
		this.s = s;
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


}
