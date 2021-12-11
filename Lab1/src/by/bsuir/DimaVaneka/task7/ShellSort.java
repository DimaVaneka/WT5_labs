package by.bsuir.DimaVaneka.task7;

public class ShellSort {

	public static double[] sort(double[] array){
		
		if (array == null) {
			throw new IllegalArgumentException("Array can't be null");
		}
        int i = 0;
        while(i < array.length - 1){
            if(array[i] <= array[i + 1])
                i++;
            else{
                double tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                if(i != 0)
                    i--;
            }
        }
        return array;
    }
}
