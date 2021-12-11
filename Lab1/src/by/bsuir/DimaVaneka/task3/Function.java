package by.bsuir.DimaVaneka.task3;

import by.bsuir.DimaVaneka.input.InputData;

public class Function {

    public static void main(String[] args) {

        System.out.println("Input a : ");
        double a = InputData.inputDouble();

        System.out.println("Input b : ");
        double b = InputData.inputDouble();

        System.out.println("Input h : ");
        double h = InputData.inputDouble();

        System.out.println("---------------------");
        System.out.printf("|%-9s|%-9s|", "x", "f(x)");
        System.out.println();
        System.out.println("---------------------");

        for(double i = a; i <= b; i += h) {
            double f = Math.tan(Math.toRadians(i));
            System.out.printf("|%-9f|%-9.3e|", i, f);
            System.out.println();
        }

        System.out.println("---------------------");
    }
}
