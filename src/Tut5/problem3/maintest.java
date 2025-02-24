package Tut5.problem3;

public class maintest {
    public static void main(String[] args) {
        Shape shape1 = new Shape();
        Shape shape2 = new Shape("blue", false);

        System.out.println(shape1);
        System.out.println(shape2);

// Testing Circle class
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.5);
        Circle circle3 = new Circle(3.0, "green", true);

        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println(circle3);
        System.out.println("Circle 3 Area: " + circle3.getArea());
        System.out.println("Circle 3 Perimeter: " + circle3.getPerimeter());

// Testing Rectangle class
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(4.0, 5.0);
        Rectangle rect3 = new Rectangle(2.5, 3.5, "yellow", false);

        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println(rect3);
        System.out.println("Rectangle 3 Area: " + rect3.getArea());
        System.out.println("Rectangle 3 Perimeter: " + rect3.getPerimeter());

// Testing Square class
        Square square1 = new Square();
        Square square2 = new Square(4.0);
        Square square3 = new Square(5.5, "purple", true);

        System.out.println(square1);
        System.out.println(square2);
        System.out.println(square3);
        square3.setSide(6.0);
        System.out.println("Updated Square 3: " + square3);
    }
}
