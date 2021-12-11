package by.bsuir.DimaVaneka.task2;

import by.bsuir.DimaVaneka.input.InputData;

public class CheckPoint {
    public static void main(String[] args) {

        System.out.println("Input x : ");
        double x = InputData.inputDouble();

        System.out.println("Input y : ");
        double y = InputData.inputDouble();

        Point pt = new Point(x,y);

        if (pt.checkPoint()){
            System.out.println("True : entered point " + pt.toString() + " belongs to the given shaded area");
        }
        else {
            System.out.println("False : entered point " + pt.toString() + " does not belong to the specified shaded area");
        }
    }
}
