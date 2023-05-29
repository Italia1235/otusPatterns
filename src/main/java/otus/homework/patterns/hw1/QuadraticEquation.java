package otus.homework.patterns.hw1;



public class QuadraticEquation {

    private final double accuracy;

    public QuadraticEquation(double accuracy) {
        this.accuracy = accuracy;
    }

    public double[] solve(double a, double b, double c) {
        if (Math.abs(a) < accuracy) {
            throw new IllegalArgumentException("Can't equal zero");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            throw new IllegalArgumentException("Can't be infinite");
        }
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
            throw new IllegalArgumentException("Can't can not be NaN");
        }
        double d = b * b - 4 * a * c;
        if (Math.abs(d) < accuracy) {
            double x = -b / (2 * a);
            return new double[]{x, x};
        } else if (d < -accuracy) {
            return new double[0];
        } else {
            return new double[]{(-b + Math.sqrt(d)) / (2 * a), (-b - Math.sqrt(d)) / (2 * a)};
        }
    }
}