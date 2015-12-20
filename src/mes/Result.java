package mes;


public class Result {
	
	private double[][] hg;
	private double[] pg;
	private double[] tg;
	
	public void calculateGlobalMatrix(Element[] elements, GlobalData globalData){
		hg=new double[globalData.getNh()][globalData.getNh()];
		//wypełnienie globalnej macierzy sztywności
		for(int i=0;i<globalData.getNe();i++){
				hg[i][i]+=elements[i].getHlIndex(0, 0);
				hg[i][i+1]+=elements[i].getHlIndex(0, 1);
				hg[i+1][i]+=elements[i].getHlIndex(1, 0);
				hg[i+1][i+1]+=elements[i].getHlIndex(1, 1);
		}
		//wypełnienie globalnego wektora obciążeń
		pg=new double[globalData.getNh()];
		for(int i=0; i<globalData.getNe(); i++){
			pg[i]+=elements[i].getPlIndex(0);
			pg[i+1]+=elements[i].getPlIndex(1);
		}
	}
	public double[] getTg(){
		return tg;
	}
	public void solveSystemOfEquation(){
		double[] b=new double[pg.length];
		for(int i=0; i<pg.length;i++)
			b[i]=(-1)*pg[i];
		tg= GS.solve(hg, b);
	}
	public void printGlobalMatrix(){
	System.out.println("=================================================");
	System.out.println("Macierz globalna H:");
		for (int i = 0; i < hg.length; i++) {
			for (int j = 0; j < hg.length; j++) {
				System.out.print(" "+hg[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Wektor glopalny P:");
		for (int i = 0; i < pg.length; i++) {
			System.out.println(" "+pg[i]+" ");
		}
	}
}
