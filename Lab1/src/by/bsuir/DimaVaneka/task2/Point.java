package by.bsuir.DimaVaneka.task2;

public class Point {
    private final double x1_upper = -4;
    private final double x2_upper = 4;
    private final double x1_lower = -6;
    private final double x2_lower = 6;

    private final double y1_upper = 0;
    private final double y2_upper = 5;
    private final double y1_lower = -3;
    private final double y2_lower = 0;

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean checkPoint() {
        if (((x >= x1_upper && x <= x2_upper) && (y >= y1_upper && y <= y2_upper)) ||
                ((x >= x1_lower && x <= x2_lower) && (y >= y1_lower && y <= y2_lower))){
            return true;
        }
        return false;
    }
}
