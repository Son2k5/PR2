package Tut5.problem2;

public class Point {
    protected float x;
    protected float y;

    // Constructors
    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getter and Setter methods
    public float getX() {
        return x;
    }

    public double setX(float x) {
        if(x==3.0) {
            x = 0.0F;
        }
        else {
            this.x =  x;
        }
        return x;

    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        if(y== 4.0){
            y = 0.0F;
        }
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}