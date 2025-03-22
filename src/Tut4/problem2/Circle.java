package Tut4.problem2;

public class Circle {
    private double radius;
    private String color;


    public Circle(double radius, String color) {
        this.radius = Math.max(radius, 0);
        this.color = color;
    }


    public Circle() {
        this(1.0, "red");
    }


    public Circle(double radius) {
        this(radius, "red");
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        if (radius >= 0) {
            this.radius = radius;
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

