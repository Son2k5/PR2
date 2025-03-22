package Tut6.problem2;

public class maintest {
    public static void main(String[] args) {
        Shape2D c1 = new Circle();
        System.out.println(c1.toString());
        Shape2D r1 = new Rectangle();
        System.out.println(r1.toString());
        Shape2D s1 = new Square();
        System.out.println(s1.toString());
        Shape2D s2 = new Square(3);
        System.out.println(s2.toString());
    }
}
