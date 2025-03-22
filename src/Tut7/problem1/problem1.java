package Tut7.problem1;
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
        String phoneRegex = "(03|05|07|08|09|01[2|6|8|9])"+"([0-9]{8})";

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

        if (dateOfBirth.isEmpty() |!regex.matcher(dateOfBirth).matches()) {
            throw new Exception("Invalid Date of Birth");
        }
    }

    public String toString() {
        return String.format("Person [id=%d, name=%s, dateOfBirth=%s, email=%s, tel=%s, address=%s]", this.id, this.name, this.dateOfBirth, this.email, this.tel, this.address);
    }
}
public class problem1 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
// Adding valid elements to the List
        try {
            personList.add(new Person(1, "Le Nam", "13-02-2005", "lenam@example.com", "0912345678", "Hanoi"));
            personList.add(new Person(2, "Nam", "11-02-2005", "nam@example.com", "0987654321", "HCM"));
            personList.add(new Person(3, "Lan", "12-02-2006", "lan@example.com", "0855555555", "Danang"));
            personList.add(new Person(4, "Lan", "12-02-2005", "lan2@example.com", "0977777777", "Hue"));
            personList.add(new Person(5, "John Doe", "25-12-1998", "john.doe@gmail.com", "0833333333", "Saigon"));
        } catch (Exception e) {
            System.out.println("Error adding person: " + e.getMessage());
        }
// Invalid cases
        System.out.println("Testing Invalid Cases:");
        String[][] testCases = {
                { "0", "John Doe", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi" }, // Invalid ID (should be ≥1)
                { "1", "", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi" }, // Empty Name
                { "2", "John123", "12-05-1990", "johndoe@example.com", "0912345678", "Hanoi" }, // Name with digits
                { "3", "John Doe", "1990-05-12", "johndoe@example.com", "0912345678", "Hanoi" }, // Wrong date format
                { "4", "John Doe", "12-05-2090", "johndoe@example.com", "0912345678", "Hanoi" }, // Future date
                { "5", "John Doe", "12-05-1990", "invalidEmail", "0912345678", "Hanoi" }, // Invalid email
                { "6", "John Doe", "12-05-1990", "johndoe@example.com", "+84123abc456", "Hanoi" }, // Invalid phone
                { "7", "John Doe", "12-05-1990", "johndoe@example.com", "0912345678", "" }, // Empty address
                { "8", "John Doe", "12-05-1990", "johndoe@example.com", "0912345678", "A@!@# Hanoi" } // Invalid address (special characters)
        };

        for (String[] testCase : testCases) {
            try {
                Person p = new Person(Integer.parseInt(testCase[0]), testCase[1], testCase[2], testCase[3], testCase[4], testCase[5]);
                System.out.println("Passed: " + p);
            } catch (Exception e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }

// Display list before sorting
        System.out.println("\nBefore Sorting:");
        for (Person person : personList) {
            System.out.println(person);
        }

// Sorting list using SortPersonByNameAgeAsc comparator
        Collections.sort(personList, new SortPersonByNameAgeAsc());

// Display list after sorting
        System.out.println("\nAfter Sorting:");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
