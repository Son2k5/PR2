package Tut7.problem4;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.time.*;
import java.util.Comparator;
import java.util.regex.Pattern;

class Course implements StudentManageable {
    //Attributes
    private String CourseID;
    private String name;
    private int credits;
    private Department department;
    private Semester semester;
    private List<Student> enrolledStudent = new ArrayList<>();

    //Constructors
    public Course() {
    }

    public Course(String CourseID, String name, int credits, Department department, Semester semester) throws Exception {
        validateCourseID(CourseID);
        validateName(name);
        validateCredits(credits);
        validateDepartment(department);
        validateSemester(semester);
        this.CourseID = CourseID;
        this.name = name;
        this.credits = credits;
        this.department = department;
        this.semester = semester;
    }

    //Getter Method
    public String getCourseID() {
        return this.CourseID;
    }

    public String getName() {
        return this.name;
    }

    public double getCredits() {
        return this.credits;
    }

    public Department getDepartment() {
        return this.department;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public List<Student> getEnrolledStudent() {
        return this.enrolledStudent;
    }

    //Setter Method
    public void setName(String name) throws Exception {
        validateName(name);
        this.name = name;
    }

    public void setCredits(int credits) throws Exception {
        if (credits < 0 || credits > 4) {
            throw new Exception("Course: Invalid Credit Value");
        }
        this.credits = credits;
    }

    public Student searchStudentByID(String studentID) {
        for (Student student : enrolledStudent) {
            return student.getStudentId().equals(studentID) ? student : null;
        }

        return null;    }

    /**
     * @param student
     * @throws Exception
     */
    @Override
    public void addStudent(Student student) throws Exception {
        this.enrolledStudent.add(student);
    }

    /**
     * @param studentID
     * @throws Exception
     */
    @Override
    public void removeStudent(String studentID) throws Exception {
        for (Student student : enrolledStudent) {
            if (student.getStudentId().equals(studentID)) {
                this.enrolledStudent.remove(student);
            }
        }
    }

    /**
     * @param student
     * @throws Exception
     */
    @Override
    public void updateStudent(String CourseID, Student student) throws Exception {

    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public Student[] getEnrolledStudents() throws Exception {
        return new Student[0];
    }

    //Validators
    private void validateCourseID(String courseID) throws Exception {
        if (courseID == null || courseID.isEmpty()) {
            throw new Exception("Course: Invalid course ID");
        }
    }

    private void validateCredits(int credits) throws Exception {
        if (credits < 0 || credits > 4) {
            throw new Exception("Course: Invalid Credit Value");
        }
    }

    private void validateName(String name) throws Exception {
        Pattern regex = Pattern.compile("[0-9]]");

        if (name == null || name.isEmpty() || regex.matcher(name).find()) {
            throw new Exception("Course: Invalid course name");
        }
    }

    private void validateDepartment(Department department) throws Exception {
        if (department == null) {
            throw new Exception("Course: Invalid department");
        }
    }

    private void validateSemester(Semester semester) throws Exception {
        if (semester == null) {
            throw new Exception("Course: Invalid semester");
        }
    }

    public String toString() {
        return String.format("Course [courseID=%s, name=%s, credits=%s, department=%s, semester=%s, enrolledStudent=%d]", this.CourseID, this.name, this.credits, this.department, this.semester, this.enrolledStudent.size());
    }
}

class SortCourseByCreditAsc implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return Double.compare(c1.getCredits(), c2.getCredits());
    }
}

class SortCourseBySemesterAsc implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return Character.compare(
                c1.getSemester().name().charAt(0),
                c2.getSemester().name().charAt(0)
        );
    }
}

enum Department {
    Computer_Science,
    Mathematics,
    Information_System,
    Software_Engineering
}

enum Semester {
    Spring,
    Summer,
    Fall,
    Winter,
}

interface StudentManageable {
    void addStudent(Student student) throws Exception;
    void removeStudent(String studentID) throws Exception;
    void updateStudent(String studentID, Student student) throws Exception;
    Student[] getEnrolledStudents() throws Exception;
}

class SortStudentByGpaAsc implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getGpa(), o2.getGpa());
    }
}

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
    public int getId() {
        return this.id;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getName() {
        return this.name;
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
        Pattern regex = Pattern.compile("\"[^a-zA-Z0-9 ]\"");

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
    public String getStudentId() {
        return this.studentId;
    }

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



class LearningManagmentSystem {
    //Attributes
    private final LinkedHashMap<String, Student> Students = new LinkedHashMap<>();
    private final LinkedHashMap<String, Course> Courses = new LinkedHashMap<>();

    private String generateId(int id) {
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();

        if (month <= 3) {
            return "SP" + year + id;
        } else if (month <= 6) {
            return "SM" + year + id;
        } else if (month <= 9) {
            return "F" + year + id;
        }

        return "WT" + year + id;
    }

    public String addStudent(Student student) {
        String id = generateId(student.getId());
        Students.put(id, student);
        return id;
    }

    public String addCourse(Course course) {
        String id = generateId(Courses.size() + 1);
        Courses.put(id, course);
        return id;
    }

    public void removeStudent(String studentID) {
        Students.remove(studentID);
    }

    public void removeCourse(String courseID) {
        Courses.remove(courseID);
    }

    public void displayAllStudents() {
        for (Student student : Students.values()) {
            System.out.println(student);
        }
    }

    public void displayAllCourses() {
        for (Course course : Courses.values()) {
            System.out.println(course);
        }
    }

    //Search Methods
    public String searchStudentByName(String name) {
        for (Student student : Students.values()) {
            if (student.getName().equals(name)) return student.getStudentId();
        }

        return "Student not found";
    }

    public String searchCourseByName(String name) {
        for (Course course : Courses.values()) {
            if (course.getName().equals(name)) {
                return course.getCourseID();
            }
        }
        return "Course not found";
    }

    //Sort Methods
    public List<Student> getSortedStudentsByGpa() {
        List<Student> sortedStudents = new ArrayList<>(Students.values());
        sortedStudents.sort(new SortStudentByGpaAsc());

        return sortedStudents;
    }

    public List<Course> getSortedCoursesByCredits() {
        List<Course> sortedCourses = new ArrayList<>(Courses.values());
        sortedCourses.sort(new SortCourseByCreditAsc());

        return sortedCourses;
    }
}
public class problem4 {
    public static void main(String[] args) {
        LearningManagmentSystem lms = new LearningManagmentSystem();

        try {
            // Adding Students
            Student student1 = new Student(1, "Le Nam", "13-02-2005", "lenam@example.com", "0912345678", "Hanoi",
                    "S001", 3.5);
            Student student2 = new Student(2, "Nam", "11-02-2005", "nam@example.com", "0987654321", "HCM", "S002", 3.8);
            Student student3 = new Student(3, "Lan", "12-02-2006", "lan@example.com", "0855555555", "Danang", "S003",
                    2.9);

            String student1ID = lms.addStudent(student1);
            String student2ID = lms.addStudent(student2);
            String student3ID = lms.addStudent(student3);

            System.out.println("Added Students:");
            lms.displayAllStudents();

            // Adding Courses
            Course course1 = new Course("CSE101", "Data Structures", 3, Department.Computer_Science, Semester.Fall);
            Course course2 = new Course("MAT201", "Calculus", 4, Department.Mathematics, Semester.Spring);
            Course course3 = new Course("SE301", "Software Engineering", 3, Department.Software_Engineering,
                    Semester.Winter);

            String course1ID = lms.addCourse(course1);
            String course2ID = lms.addCourse(course2);
            String course3ID = lms.addCourse(course3);

            System.out.println("\nAdded Courses:");
            lms.displayAllCourses();

            // Searching for students
            System.out.println("\nSearching for Le Nam: " + lms.searchStudentByName("Le Nam"));
            System.out.println("Searching for Unknown Student: " + lms.searchStudentByName("Unknown"));

            // Searching for courses
            System.out.println("\nSearching for Calculus: " + lms.searchCourseByName("Calculus"));
            System.out.println("Searching for Unknown Course: " + lms.searchCourseByName("Physics"));

            // Sorting Students by GPA
            System.out.println("\nSorted Students by GPA:");
            List<Student> sortedStudents = lms.getSortedStudentsByGpa();
            for (Student student : sortedStudents) {
                System.out.println(student);
            }

            // Sorting Courses by Credits
            System.out.println("\nSorted Courses by Credits:");
            List<Course> sortedCourses = lms.getSortedCoursesByCredits();
            for (Course course : sortedCourses) {
                System.out.println(course);
            }

            // Removing a Student
            System.out.println("\nRemoving Student: " + student2ID);
            lms.removeStudent(student2ID);
            System.out.println("Students after removal:");
            lms.displayAllStudents();

            // Removing a Course
            System.out.println("\nRemoving Course: " + course2ID);
            lms.removeCourse(course2ID);
            System.out.println("Courses after removal:");
            lms.displayAllCourses();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
