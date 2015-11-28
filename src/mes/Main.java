package mes;

public class Main {
	
	private static GlobalData globalData;
	
	public static void main(String[] args){
		Calculations calc=new Calculations();
		calc.setMaterialData();
		calc.setGlobalData();
		calc.setLocalMatrix();
		calc.calculateGlobalMatrix();
		calc.solveSystemOfExuation();
		calc.printTemperatures();
	}
}
