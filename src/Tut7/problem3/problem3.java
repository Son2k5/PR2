package Tut7.problem3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

enum Semester {
    Spring,
    Summer,
    Fall,
    Winter,
}

enum Department {
    Computer_Science,
    Mathematics,
    Information_System,
    Software_Engineering
}

interface StudentManageable {
    void addStudent(Student student) throws Exception;
    void removeStudent(String studentID) throws Exception;
    void updateStudent(String studentID, Student student) throws Exception;
    Student[] getEnrolledStudents() throws Exception;
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
            throw new Exception("Course: Invalid credit value");
        }

        this.credits = credits;
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

class SortCourseByNameAsc implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return c1.getName().compareToIgnoreCase(c2.getName());
    }
}

class SortCourseByCreditAsc implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return Double.compare(c1.getCredits(), c2.getCredits());
    }
}

class SortCourseByDepartmentAsc implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return Character.compare(
                c1.getDepartment().name().charAt(0),
                c2.getDepartment().name().charAt(0)
        );
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
public class problem3 {
    public static void main(String[] args) {
        List<Course> courseList = new ArrayList<Course>();

// Adding valid courses
        try {
            courseList.add(new Course("CSE101", "Introduction to CS", 3, Department.Computer_Science, Semester.Fall));
            courseList.add(new Course("MTH102", "Calculus I", 4, Department.Mathematics, Semester.Spring));
            courseList.add(new Course("IS201", "Information Systems", 3, Department.Information_System, Semester.Winter));
            courseList.add(new Course("SE301", "Software Engineering", 3, Department.Software_Engineering, Semester.Summer));
        } catch (Exception e) {
            System.out.println("Error adding course: " + e.getMessage());
        }

// Invalid cases
        System.out.println("Testing Invalid Cases:");
        Object[][] testCases = {
                { "", "Introduction to AI", 3, Department.Computer_Science, Semester.Fall }, // Empty ID
                { "AI202", "", 3, Department.Computer_Science, Semester.Fall }, // Empty Name
                { "AI202", "Artificial Intelligence", -1, Department.Computer_Science, Semester.Fall }, // Invalid Credit
                { "AI202", "Artificial Intelligence", 3, null, Semester.Fall }, // Null Department
                { "AI202", "Artificial Intelligence", 3, Department.Computer_Science, null } // Null Semester
        };

        for (Object[] testCase : testCases) {
            try {
                Course c = new Course((String) testCase[0], (String) testCase[1], (int) testCase[2], (Department) testCase[3], (Semester) testCase[4]);
                System.out.println("Passed: " + c);
            } catch (Exception e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }

// Display before sorting
        System.out.println("\nBefore Sorting:");
        for (Course course : courseList) {
            System.out.println(course);
        }

// Sorting by different comparators
        Collections.sort(courseList, new SortCourseByNameAsc());
        System.out.println("\nSorted by Name:");
        for (Course course : courseList) {
            System.out.println(course);
        }

        Collections.sort(courseList, new SortCourseByCreditAsc());
        System.out.println("\nSorted by Credit:");
        for (Course course : courseList) {
            System.out.println(course);
        }

        Collections.sort(courseList, new SortCourseByDepartmentAsc());
        System.out.println("\nSorted by Department:");
        for (Course course : courseList) {
            System.out.println(course);
        }

        Collections.sort(courseList, new SortCourseBySemesterAsc());
        System.out.println("\nSorted by Semester:");
        for (Course course : courseList) {
            System.out.println(course);
        }

// Testing student management methods
        System.out.println("\nTesting Student Management:");
        try {
            // Create course instances
            Course course1 = new Course("CSE101", "Data Structures", 3, Department.Computer_Science, Semester.Fall);
            Course course2 = new Course("MAT201", "Calculus", 4, Department.Mathematics, Semester.Spring);
            Course course3 = new Course("SE301", "Software Engineering", 3, Department.Software_Engineering, Semester.Winter);

            // Print initial courses
            System.out.println("Initial Courses:");
            System.out.println(course1);
            System.out.println(course2);
            System.out.println(course3);

            // Test setters
            course1.setName("Advanced Data Structures");
            course2.setCredits(5);
            course3.setCredits(20);
            System.out.println("\nUpdated Courses:");
            System.out.println(course1);
            System.out.println(course2);
            System.out.println(course3);

            // Create student instances
            Student student1 = new Student(1, "Le Nam", "13-02-2005", "lenam@example.com", "0912345678", "Hanoi", "S001", 3.5);
            Student student2 = new Student(2, "Nam", "11-02-2005", "nam@example.com", "0987654321", "HCM", "S002", 3.8);
            Student student3 = new Student(3, "Lan", "12-02-2006", "lan@example.com", "0855555555", "Danang", "S003", 2.9);
            Student student4 = new Student(4, "Lan", "12-02-2005", "lan2@example.com", "0977777777", "Hue", "S004", 3.2);
            Student student5 = new Student(5, "John Doe", "25-12-1998", "john.doe@gmail.com", "0833333333", "Saigon", "S005", 3.0);

            // Add students to course1
            course1.addStudent(student1);
            course1.addStudent(student2);
            System.out.println("\nEnrolled Students in " + course1.getName() + ": " + course1.getEnrolledStudent().size());
            course2.addStudent(student3);
            course2.addStudent(student4);
            System.out.println("\nEnrolled Students in " + course2.getName() + ": " + course2.getEnrolledStudent().size());
            course3.addStudent(student5);
            System.out.println("\nEnrolled Students in " + course3.getName() + ": " + course3.getEnrolledStudent().size());

            // Search for a student
            Student foundStudent = course1.searchStudentByID("S002");
            System.out.println("\nFound Student: " + foundStudent);

            // Update student
            Student updatedStudent = new Student(6, "John Smith", "13-12-1968", "john.smith@gmail.com", "0834444444", "Thai Nguyen", "S006", 3.0);
            course1.updateStudent("S002", updatedStudent);
            System.out.println("\nUpdated Student List: " + course1.getEnrolledStudent());

            // Remove student
            course1.removeStudent("S001");
            System.out.println("\nStudent List after removal: " + course1.getEnrolledStudent());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
