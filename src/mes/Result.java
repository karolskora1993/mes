package mes;

import no.uib.cipr.matrix.BandMatrix;
import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.Vector;

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
	public void solveSystemOfEquation(){
		BandMatrix matrix=new BandMatrix(hg.length,1,1);
		for(int i=0; i<hg.length;i++)
		{
			for(int j=0; j<hg.length; j++)
			{
				matrix.add(i, j, hg[i][j]);
			}
		}
		double[] bTemp=new double[pg.length];
		for(int i=0; i<pg.length;i++)
			bTemp[i]=pg[i];
		
		double[] xTemp=new double[hg.length];
		
		Vector b=new DenseVector(bTemp);
		Vector x=new DenseVector(xTemp);
		
		x= matrix.solve(b, x);
		tg=new double[hg.length];
		for(int i=0; i<tg.length;i++)
			tg[i]=x.get(i);
	}
	public double[] getTg(){
		return tg;
	}
	public void solveSystemOfEquationGS(){
		double[] b=new double[pg.length];
		for(int i=0; i<pg.length;i++)
			b[i]=-pg[i];
		tg= GS.solve(hg, b);
	}
}
