package Tut6.problem2;

public class Rectangle extends Shape2D {
    protected double length = 1.0;
    protected double width = 1.0;
    public Rectangle() {
        super();
    }
    public Rectangle(double length, double width) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(Colors color, boolean filled) {
        super(color, filled);
    }
    public Rectangle(double length, double width, Colors color, boolean filled) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }
    public Rectangle(double length, double width, Colors color, boolean filled, Point2D position) {
        super(color, filled);
        this.length = length;
        this.width = width;
        this.position = position;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double getArea() {
        return length*width;
    }
    public double getPerimeter() {
        return 2*(length+width);
    }
    @Override
    public String toString() {
        return "Rectangle[length="+getLength() +",width=" +getWidth() +","+super.toString()+"]";
    }
}
