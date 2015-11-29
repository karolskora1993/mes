package mes;

import org.jfree.ui.RefineryUtilities;

public class Main {

	private static GlobalData globalData;

	public static void main(String[] args) {
		Calculations calc = new Calculations();
		calc.setMaterialData();
		calc.setGlobalData();
		calc.setLocalMatrix();
		calc.calculateGlobalMatrix();
		calc.solveSystemOfExuation();
		calc.printTemperatures();

		LineChart chart = new LineChart("Temperatura w węzłach", "Wykres temperatury w poszczególnych węzłach", calc);

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}
