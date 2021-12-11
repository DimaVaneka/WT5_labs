package by.bsuir.DimaVaneka.task6;

public class Matrix {
	
	public static int[][] fillMatrix(int[] arr) {
		
		if (arr == null) {
			throw new IllegalArgumentException("Array can't be null");
		}
		
		int[][] matrix = new int[arr.length][arr.length];
		int step = 0;
		
		for (int i = 0 ; i < arr.length; i++) {
			for (int j = 0 ; j < arr.length; j++) {
				matrix[i][j] = arr[(j + step) % arr.length] ;
			}
			step++;
		}
		return matrix;
		
	}
}
