package Tut_6.problem4;

class Point2D {
    protected double x = 0.0;
    protected double y = 0.0;
    public Point2D() {

    }
    public Point2D (double x, double y) {
        this.x = x;
        this.y=y;
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
    public void setY (double y) {
        this.y = y;
    }
    public void add(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
    public double getDistanceTo(double x, double y) {
        return Math.sqrt(Math.pow(x-this.x, 2) + Math.pow(y-this.y, 2));
    }
    public double getDistanceTo(Point2D point) {
        return getDistanceTo(point.getX(), point.getY());
    }
    @Override
    public String toString() {
        return "Point2D[x=" + x +",y=" +y+"]";
    }
}
