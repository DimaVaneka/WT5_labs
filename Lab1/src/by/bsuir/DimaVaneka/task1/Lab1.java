package by.bsuir.DimaVaneka.task1;

import by.bsuir.DimaVaneka.input.InputData;

public class Lab1 {

    public static void main(String[] args) {

        System.out.println("Введите x : ");
        double x = InputData.inputDouble();

        System.out.println("Введите y : ");
        double y = InputData.inputDouble();

        Equation.solveTheEquation(x,y);
    }

}
