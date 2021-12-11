package by.bsuir.DimaVaneka.task4;

import java.util.ArrayList;

public class FindPrimeNumber {

    private static boolean isPrimeNumber(int x)
    {
        if(x == 1 || x <= 0)
            return false;

        for(int d = 2; d * d <= x ; d++){

            if(x % d == 0)
                return false;
        }
        return true;

    }

    public  static ArrayList findSimpleNumbers(int[] arr) {
        boolean flag;
        ArrayList<Integer> IndexPrimeNumberList = new ArrayList<Integer>();
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be zero");
        }

        for (int i =0 ;i<arr.length; i++)
        {
            flag = isPrimeNumber(arr[i]);
            if (flag) {
                IndexPrimeNumberList.add(i);
            }
        }

        if (IndexPrimeNumberList.isEmpty()) {
            throw new IllegalArgumentException("No empty numbers in the given array");
        }

        return  IndexPrimeNumberList;
    }
}
