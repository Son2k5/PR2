package Tut_6.problem2;

public class Square extends Rectangle {
    protected double side= 1.0;
    public Square() {
        super(1.0,1.0);
    }
    public Square(double side) {
        this.side = side;
    }
    public Square(double side, Colors color, boolean filled) {
        super(side,side,color, filled) ;

    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);

    }
    @Override
    public double getLength() {
        return side;
    }
    @Override
    public double getWidth() {
        return side;
    }
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }
    @Override
    public void setLength(double side) {
        this.setLength(side);
    }
    public double getArea() {
        return side*side;
    }
    public double getPerimeter() {
        return 4*side;
    }
    @Override
    public String toString() {
        return "Square[side="+getSide() +","+super.toString()+"]";
    }
}


