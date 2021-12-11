package by.bsuir.DimaVaneka.output;

public class OutputData {

    public static  void outputIntArray(int[] array){

        for (int value : array){
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }

    public static  void outputDoubleArray(double[] array){

        for (double value : array){
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }

    public static void outputIntMatrix(int[][] matrix){

        for(int[] array : matrix){
            outputIntArray(array);
        }
    }
}
