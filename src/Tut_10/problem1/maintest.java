package Tut_10.problem1;
import java.util.*;
import java.util.regex.Pattern;

class IllegalArgumentException extends Exception {
    public IllegalArgumentException(String msg) {
        super(msg);
    }
}
class MobilePhone{

    private static MobilePhone instance;
    private String color;
    private String  manName;
    private  int year;
    private String model;
    private boolean guarantee;

    public static MobilePhone getInstance(){
        if(instance == null){
            instance =  new MobilePhone();
        }
        return instance;
    }
    private MobilePhone(){}
    public String getColor() {
        return color;
    }
    public void setColor(String color) throws IllegalArgumentException {
        this.color = color;
    }

    public void setManName(String manName)  throws IllegalArgumentException {
        try {
            if (checkValidName(manName)) {
                this.manName = manName;
            }
        }catch(Exception e){
            throw new IllegalArgumentException("Invalid name");
        }
    }
    private boolean checkValidName(String manName) throws IllegalArgumentException {
        if (manName == null || manName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        String regex = "^[a-zA-Z]([a-zA-Z\\s\\-']+)?$";

        boolean isValid = manName.matches(regex);

        if (!isValid) {
            throw new IllegalArgumentException("Invalid name format: " + manName);
        }

        return isValid;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public boolean isGuarantee() {
        return guarantee;
    }
    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }
    public String toString(){
        return "MobilePhone: <" + manName + ", M-ABC-123"  + ", " + color + ", " + year + ", " + guarantee + ">";
    }

}
class Person{
    private String name;
    private int id;
    private MobilePhone phone;
    public Person(int id, String name){
        this.name = name;
        this.id = id;
    }



    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public MobilePhone getPhone(){
        return phone;
    }
    public void setPhone(MobilePhone phone){
        this.phone = phone;
    }
    public void greet(){
        System.out.println(name +" says: Hello");
    }
    @Override
    public String toString(){
        return "Person: <" + id + ", " + name + ", " + (phone != null ? phone.toString() : "null") + ">";
    }
}
class GreetingConversation{
    private static GreetingConversation instance;
    private GreetingConversation(){}
    public static GreetingConversation getInstance(){
        if(instance == null){
            instance = new GreetingConversation();
        }
        return instance;
    }
    public void startConversation(Person p1, Person p2){
        System.out.println(p1.getName() + " says: Hello, " + p2.getName() + "!");
        System.out.println(p2.getName() + " says: Hi, " + p1.getName() + "! How are you?");
    }
}

public class maintest {
    public static void main(String[] args) {
        // Main method of GreetingConversation
        try {
            // Test creating persons
            Person p1 = new Person(1, "Quan Dang");
            Person p2 = new Person(2, "Thuan Nguyen");
            System.out.println("Created Persons: ");
            System.out.println(p1);
            System.out.println(p2);

            // Test creating mobile phones
            MobilePhone m1 = MobilePhone.getInstance();
            MobilePhone m2 = MobilePhone.getInstance();
            System.out.println("Created Mobile Phones: ");
            if (m1.equals(m2)) {
                System.out.println("Two objects point to the same memory location on the heap i.e, to the same object");
            }else{
                System.out.println("Two objects DO NOT point to the same memory location on the heap");
            }

            // Test assigning phones
            m1.setManName("APhone");
            m1.setColor("#0033ff");
            m1.setGuarantee(true);
            m1.setYear(2015);
            m1.setModel("M-ABC-123");
            m2.setManName("CPhone");
            m2.setColor("#123456");
            m2.setGuarantee(false);
            m2.setYear(2024);
            m2.setModel("Model A");
            p1.setPhone(m1);
            p2.setPhone(m2);
            System.out.println("Persons after assigning phones: ");
            System.out.println(p1);
            System.out.println(p2);

            // Test greeting
            p1.greet();
            p2.greet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
