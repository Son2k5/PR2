package Tut_6.problem2;

public class Circle extends Shape2D {
    private double radius = 1.0;
    public Circle() {

    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, Colors color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public Circle(double radius, Colors color, boolean filled, Point2D position) {
        super(color, filled, position);
        this.radius = radius;
    }
    public double getRadius () {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI*radius*radius;
    }
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    @Override
    public String toString() {
        return "Circle[radius="+getRadius() +","+super.toString()+"]";
    }

}
