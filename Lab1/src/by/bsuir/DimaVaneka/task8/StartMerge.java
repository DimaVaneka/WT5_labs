package by.bsuir.DimaVaneka.task8;


import by.bsuir.DimaVaneka.input.InputData;

import java.util.ArrayList;

public class StartMerge {

	public static void main(String[] args) {
		
		System.out.println("Enter the size of the first sequence: ");
		int n1 = InputData.inputInt();
				
		System.out.println("Complete the first sequence: ");
		double[] sequence1 = InputData.inputDoubleArray(n1);
		
		System.out.println("Enter the size of the second sequence ");
		int n2 = InputData.inputInt();
				
		System.out.println("Complete the second sequence: ");
		double[] sequence2 = InputData.inputDoubleArray(n2);
		
		try {
			ArrayList<Double> finalSequence = SequencesMerging.merge(sequence1, sequence2); 
			System.out.println("Final sequence: " +  (finalSequence.toString().substring(1, finalSequence.toString().length() - 1))  );
			
		}catch( IllegalArgumentException e) {
			System.out.println( e.getMessage() );
		}

	}

}
