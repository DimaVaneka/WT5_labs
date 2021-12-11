package by.bsuir.DimaVaneka.task1;

public class Equation {

    public static void solveTheEquation(double x, double y){
        double numerator = 1 + Math.pow(Math.sin(x + y), 2);
        double denominator = 2 + Math.abs(x - 2*x/ (1 + x * x * y * y));
        try {
            double res = numerator/denominator + x;
            System.out.println("Результат : " + res);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException" + e.getMessage());
        }



    }
}
