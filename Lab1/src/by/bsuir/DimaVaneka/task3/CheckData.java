package by.bsuir.DimaVaneka.task3;

public class CheckData {

    public static void check(double a, double b, double h){
        if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(h)) {
            throw new IllegalArgumentException("Parameters entered incorrectly");
        }
        if (b < a) {
            throw new IllegalArgumentException("Interval entered incorrectly");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("The step must be positive");
        }
    }
}
