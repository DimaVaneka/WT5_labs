package by.bsuir.DimaVaneka.task5;

import by.bsuir.DimaVaneka.input.InputData;



public class StartSequence {

	public static void main(String[] args) {
		
		System.out.println("Enter the size of the array : ");
		int n = InputData.inputInt();
		
		System.out.println("Populate the array : ");
		int[] array = InputData.inputIntArray(n);
		
		try {
			
			System.out.println("Element with minimum value : " +  (FindMinElements.getMinElements(array) + 1)  );
			
		}catch( IllegalArgumentException e) {
			System.out.println( e.getMessage() );
		}
	}

}
