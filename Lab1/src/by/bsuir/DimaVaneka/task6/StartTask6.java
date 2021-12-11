package by.bsuir.DimaVaneka.task6;


import by.bsuir.DimaVaneka.input.InputData;
import by.bsuir.DimaVaneka.output.OutputData;

import static by.bsuir.DimaVaneka.task6.Matrix.fillMatrix;

public class StartTask6 {

	public static void main(String[] args) {
		
		System.out.println("Please, enter array size: ");
		int n = InputData.inputInt();
		
		System.out.println("Please, enter array");
		int[] array = InputData.inputIntArray(n);
		
		try {
			int[][] matrix = fillMatrix(array);
			OutputData.outputIntMatrix(matrix);
			
		}catch( IllegalArgumentException e) {
			System.out.println( e.getMessage() );
		}

	}

}
