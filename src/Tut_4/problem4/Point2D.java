package Tut_4.problem4;

public class Point2D {
    private double x;
    private double y;
    public Point2D() {

    }
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;

    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double distance(Point2D point) {
        return Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
