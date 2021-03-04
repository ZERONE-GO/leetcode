package p0304;

class NumMatrix {

	private int[][] sumMatrix;

	public NumMatrix(int[][] matrix) {
		int m = matrix.length;
		if (m <= 0) {
			this.sumMatrix = new int[1][1];
			return;
		}
		int n = matrix[0].length;

		this.sumMatrix = new int[m + 1][];
		this.sumMatrix[0] = new int[n + 1];
		for (int i = 0; i < m; i++) {
			this.sumMatrix[i + 1] = new int[n + 1];
			for (int j = 0; j < n; j++) {
				sumMatrix[i + 1][j + 1] = sumMatrix[i][j + 1] + sumMatrix[i + 1][j] - sumMatrix[i][j] + matrix[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1]
				+ sumMatrix[row1][col1];
	}
}