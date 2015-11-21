package mes;

public class Main {
	
	private static GlobalData globalData;
	
	public static void main(String[] args){
		Calculations calc=new Calculations();
		calc.setGlobalData();
		calc.setMaterialData();
		calc.generateFemGrid();
	}
}
