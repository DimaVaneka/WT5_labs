package by.bsuir.DimaVaneka.task4;

import by.bsuir.DimaVaneka.input.InputData;

import java.util.ArrayList;

public class PrimeNumber {


    public static void main(String[] args) {

        System.out.println("Enter the size of the array: ");
        int n = InputData.inputInt();

        System.out.println("Fill in the array: ");
        int[] array = InputData.inputIntArray(n);

        ArrayList<Integer> list = FindPrimeNumber.findSimpleNumbers(array);

        for (int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i) + " ");
        }

    }
}
