package Tut_6.problem2;

abstract class Shape2D implements Shape2DCalculation {
    protected Colors color = Colors.White;
    protected boolean filled = false;
    protected Point2D position = new Point2D();

    public Shape2D() {

    }

    public Shape2D(Point2D position) {
        this.position = position;
    }

    public Shape2D(Colors color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape2D(Colors color, boolean filled, Point2D position) {
        this.color = color;
        this.position = position;
        this.filled = filled;
    }

    public Colors getColor() {
        return color;
    }

    public Point2D getPosition() {
        return position;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape2D[color=" + getColor() + ",filled status=" + isFilled() + ",position=" + position.toString() + "]";
    }
}
