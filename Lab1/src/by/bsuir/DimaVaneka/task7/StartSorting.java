package by.bsuir.DimaVaneka.task7.runner;


import by.bsuir.DimaVaneka.input.InputData;
import by.bsuir.DimaVaneka.output.OutputData;

public class StartSorting {

	public static void main(String[] args) {
		
		System.out.println("Enter the size of the array : ");
		int n = InputData.inputInt();
				
		System.out.println("Populate the array : ");
		double[] array = InputData.inputDoubleArray(n);
		
		try {
			double[] arr = by.bsuir.DimaVaneka.task7.ShellSort.sort(array);
			OutputData.outputDoubleArray(arr);
			
		}catch( IllegalArgumentException e) {
			System.out.println( e.getMessage() );
		}

	}

}
