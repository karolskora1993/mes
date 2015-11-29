package mes;

public class GS {
	private static int accuracy=100;
	
	public static void setAccuracy(int a){
		accuracy=a;
	}

	public static double[] solve(double[][] A, double[] b) {
		int n=A.length;
		double[][] L = new double[n][n];
		double[][] D = new double[n][n];
		double[][] U = new double[n][n];
		double[] x = new double[n];

		// Divide A into L + D + U
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i < j) {
					U[i][j] = A[i][j];
				} else if (i > j) {
					L[i][j] = A[i][j];
				} else {
					D[i][j] = A[i][j];
				}
			}

		// Calculate D^-1
		for (int i = 0; i < n; i++)
			D[i][i] = 1 / D[i][i];

		// Calculate D^-1 * b
		for (int i = 0; i < n; i++)
			b[i] *= D[i][i];

		// Calculate D^-1 * L
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				L[i][j] *= D[i][i];

		// Calculate D^-1 * U
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				U[i][j] *= D[i][i];

		// Initialize x
		for (int i = 0; i < n; i++)
			x[i] = 0;

		for (int k = 0; k < accuracy; k++)
			for (int i = 0; i < n; i++) {
				x[i] = b[i]; // x = D^-1*b -
				for (int j = 0; j < i; j++)
					x[i] -= L[i][j] * x[j]; // D^-1*L * x -
				for (int j = i + 1; j < n; j++)
					x[i] -= U[i][j] * x[j]; // D^-1*U * x
			}

		return x;
	}

}