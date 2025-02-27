package Tut_6.problem2;

import java.awt.*;

abstract class Shape2D {
    protected Colors color = Colors.White;
    protected boolean filled = false;
    protected Point2D potision = new Point2D();

    public Shape2D() {}
    public Shape2D(Point2D potision) {
        this.potision = potision;
    }
    public Shape2D(Colors color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public Shape2D(Colors color, boolean filled, Point2D potision) {
        this.color = color;
        this.filled = filled;
        this.potision = potision;
    }
    public Colors getColor() {
        return color;
    }
    public void setColor(Colors color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public Point2D getPotision() {
        return potision;

    }
    public void setPotision(Point2D potision) {
        this.potision = potision;
    }

}
