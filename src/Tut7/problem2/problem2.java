package Tut7.problem2;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

class SortPersonByNameAgeAsc implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int m1 = Integer.parseInt(p1.getDateOfBirth().split("-")[0]);
        int m2 = Integer.parseInt(p2.getDateOfBirth().split("-")[0]);

        int age1 = calculateAge(p1.getDateOfBirth());
        int age2 = calculateAge(p2.getDateOfBirth());
        if (age2 == age1) {
            if (m1 < m2) {
                return -1;
            }
        };

        return Integer.compare(age2, age1);
    }

    public int calculateAge(String date) {
        String[] dateArr = date.split("-");
        int[] dateIntArr = new int[3];
        for (int i = 0; i < dateArr.length; i++) {
            dateIntArr[i] = Integer.parseInt(dateArr[i]);
        }
        LocalDate birth = LocalDate.of(dateIntArr[2], dateIntArr[1], dateIntArr[0]);
        LocalDate currentDate = LocalDate.now();

        return Period.between(birth, currentDate).getYears();
    }
}

 class Person {
    //Attributes
    private int id;
    private String name;
    private String dateOfBirth;
    private String email;
    private String tel;
    private String address;

    //Constructors
    public Person() {
    }

    public Person(int id, String name, String dateOfBirth, String email, String tel, String address) throws Exception {
        validateId(id);
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateEmail(email);
        validatePhoneNumber(tel);
        validateAddress(address);
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.tel = tel;
        this.address = address;
    }

    //Getter Method
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    //Validator
    private void validateId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Invalid ID");
        }
    }

    private void validateName(String name) throws Exception {
        Pattern regex = Pattern.compile("[0-9]");

        if (name == null || name.isEmpty() || regex.matcher(name).find()) {
            throw new Exception("Invalid Name");
        }
    }

    private void validateEmail(String email) throws Exception {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern regex = Pattern.compile(emailRegex);

        if (email == null || email.isEmpty() || !regex.matcher(email).matches()) {
            throw new Exception("Invalid Email");
        }
    }

    private void validatePhoneNumber(String tel) throws Exception {
        String phoneRegex = "(03|05|07|08|09|01[2|6|8|9])" + "([0-9]{8})";

        Pattern regex = Pattern.compile(phoneRegex);

        if (tel == null || tel.isEmpty() || !regex.matcher(tel).matches()) {
            throw new Exception("Invalid Phone Number");
        }
    }

    private void validateAddress(String address) throws Exception {
        Pattern regex = Pattern.compile("[^a-zA-Z0-9]");

        if (address == null || address.isEmpty() || regex.matcher(address).find()) {
            throw new Exception("Invalid Address");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) throws Exception {
        int currentYear = LocalDate.now().getYear();
        String[] dateArr = dateOfBirth.split("-");
        if (Integer.parseInt(dateArr[2]) > currentYear) {
            throw new Exception("Invalid Date of Birth");
        }
        Pattern regex = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$");

        if (dateOfBirth.isEmpty() | !regex.matcher(dateOfBirth).matches()) {
            throw new Exception("Invalid Date of Birth");
        }
    }

    public String toString() {
        return String.format("Person [id=%d, name=%s, dateOfBirth=%s, email=%s, tel=%s, address=%s]", this.id, this.name, this.dateOfBirth, this.email, this.tel, this.address);
    }
}

class SortStudentByGpaDesc implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getGpa(), o1.getGpa());
    }
}

class Student extends Person {
    private String studentId;
    private double gpa;

    //Constructors
    public Student(int id, String name, String dateOfBirth, String email, String tel, String address, String studentId, double gpa) throws Exception {
        super(id, name, dateOfBirth, email, tel, address);
        validateGpa(gpa);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    //Getter Method
    public double getGpa() {
        return this.gpa;
    }

    //Setter Method
    public void setGpa(double gpa) throws Exception {
        validateGpa(gpa);
        this.gpa = gpa;
    }

    //Validator
    public void validateGpa(double gpa) throws Exception {
        if (gpa < 0 || gpa > 4) {
            throw new Exception("Student: Invalid GPA");
        }
    }

    @Override
    public String toString() {
        return String.format("Student [%s, studentID=%s, gpa=%.1f]", super.toString(), this.studentId, this.gpa);
    }
}
public class problem2 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

// Adding valid students to the list
        try {
            studentList.add(new Student(1, "Le Nam", "13-02-2005", "lenam@example.com", "0912345678", "Hanoi", "S001", 3.5));
            studentList.add(new Student(2, "Nam", "11-02-2005", "nam@example.com", "0987654321", "HCM", "S002", 3.8));
            studentList.add(new Student(3, "Lan", "12-02-2006", "lan@example.com", "0855555555", "Danang", "S003", 2.9));
            studentList.add(new Student(4, "Lan", "12-02-2005", "lan2@example.com", "0977777777", "Hue", "S004", 3.2));
            studentList.add(new Student(5, "John Doe", "25-12-1998", "john.doe@gmail.com", "0833333333", "Saigon", "S005", 3.0));
            System.out.println("Successfully added valid students.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }

// Testing invalid cases
        System.out.println("\nTesting Invalid Cases:");
        String[][] testCases = {
                { "0", "John Doe", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi", "", "3.5" }, // Empty student ID
                { "1", "", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi", "S007", "3.2" }, // Empty name
                { "2", "John123", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi", "S008", "2.8" }, // Name with digits
                { "3", "John Doe", "1990-05-12", "johndoe@example.com", "0912345678", "Hanoi", "S009", "3.0" }, // Wrong date format
                { "4", "John Doe", "12-05-2090", "johndoe@example.com", "0912345678", "Hanoi", "S010", "3.1" }, // Future date
                { "5", "John Doe", "12-05-1990", "invalidEmail", "0912345678", "Hanoi", "S011", "2.5" }, // Invalid email
                { "6", "John Doe", "12-05-1990", "johndoe@example.com", "+84123abc456", "Hanoi", "S012", "2.0" }, // Invalid phone
                { "7", "John Doe", "12-05-1990", "johndoe@example.com", "0912345678", "", "S013", "3.3" }, // Empty address
                { "8", "John Doe", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi", "S014", "4.5" } // Invalid GPA out of range
        };

        for (String[] testCase : testCases) {
            try {
                Student s = new Student(Integer.parseInt(testCase[0]), testCase[1], testCase[2], testCase[3], testCase[4], testCase[5], testCase[6], Double.parseDouble(testCase[7]));
                System.out.println("Passed: " + s);
            } catch (Exception e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }

// Testing setters
        System.out.println("\nTesting Setters:");
        try {
            Student testStudent = new Student(10, "Valid Student", "01-01-2000", "valid@example.com", "0912345678", "Hanoi", "S015", 3.5);

            // Valid GPA update
            testStudent.setGpa(3.9);
            System.out.println("GPA updated successfully: " + testStudent.getGpa());

            // Invalid GPA update
            try {
                testStudent.setGpa(4.5);
            } catch (Exception e) {
                System.out.println("Caught exception for invalid GPA update: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

// Display list before sorting
        System.out.println("\nBefore Sorting:");
        for (Student student : studentList) {
            System.out.println(student);
        }

// Sorting list using StudentGpaComparator (ascending order)
        Collections.sort(studentList, new SortStudentByGpaDesc());

// Display list after sorting
        System.out.println("\nAfter Sorting by GPA (ascending):");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
