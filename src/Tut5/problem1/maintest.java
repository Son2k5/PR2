package Tut5.problem1;

public class maintest {
    public static void main(String[] args) {
        Student student = new Student("Alice", "123 Main St", "Computer Science", 2, 15000);
        Staff staff = new Staff("Bob", "456 Elm St", "XYZ High School", 50000);

        System.out.println(student);
        System.out.println(staff);
    }
}
