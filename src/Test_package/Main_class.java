package Test_package;

public class Main_class {
   public static void main(String[] args) {
       Point p1 = new Point();
       Point p2 = new Point(2.5f, 3.5f);

       System.out.println("Point 1: " + p1);
       System.out.println("Point 2: " + p2);

       p1.setXY(1.0f, 1.5f);
       System.out.println("Updated Point 1: " + p1);

// Testing MovablePoint class
       MovablePoint mp1 = new MovablePoint();
       MovablePoint mp2 = new MovablePoint(0.5f, 1.0f);
       MovablePoint mp3 = new MovablePoint(3.0f, 4.0f, 1.5f, 2.5f);

       System.out.println("MovablePoint 1: " + mp1);
       System.out.println("MovablePoint 2: " + mp2);
       System.out.println("MovablePoint 3: " + mp3);

// Moving MovablePoint
       mp3.move();
       System.out.println("Moved MovablePoint 3: " + mp3);

// Updating speed and moving again
       mp3.setSpeed(2.0f, 3.0f);
       mp3.move();
       System.out.println("Moved MovablePoint 3 again: " + mp3);
   }
}
