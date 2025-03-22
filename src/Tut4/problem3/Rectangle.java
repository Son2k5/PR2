package Tut4.problem3;



public class Rectangle {
    private float height = 1.0f;
    private float width = 1.0f;

    public Rectangle(float v, float v1) {

    }

    public void Rectangle(float width, float height) {
        this.height = height;
        this.width = width;

    }

    public Rectangle() {

    }

    public float getHeight() {
        return height;
    }
    public void setHeight(float length) {
        this.height = length;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public double getArea() {
        return height * width;
    }
    public double getPerimeter() {
        return 2 * height + 2* width;
    }

    @Override
    public String toString(){
        return "Rectangle[width=" + width + ",height=" + height + "]";
    }

}


