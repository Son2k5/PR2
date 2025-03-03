package Tut_7.Problem1;

import java.util.regex.Pattern;

public class Person {
    private String name;
    private int id;
    private String dateOfBirth;
    private String email;
    private String tel;
    private String address;

    private static final Pattern namePattern = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern phonePattern = Pattern.compile("^\\+?[0-9]{10,15}$");
    private static final Pattern dateOfBirthPattern = Pattern.compile("^(0[1-9]|12[0-9]|3[01]) /(0[1-9]|1[0-2])/(19|20)\\d\\d");
    private static final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$]");
    private static final Pattern addressPattern = Pattern.compile("^[A-Za-z0-9, ]+$");

    public Person(int id, String name, String dateOfBirth, String email, String tell, String address) throws IllegalAccessException {
        if(id<=0) throw new IllegalAccessException("Failed: Invalid ID");
        if(name==null || name.length()==0 || name.trim().isEmpty()) throw new IllegalAccessException("Failed: Invalid name");
        if(email==null || email.length()==0 || !emailPattern.matcher(email).matches()) throw new IllegalAccessException("Failed: Invalid email");
        if(tel==null || tel.length()==0 ||(tel != null && !phonePattern.matcher(tel).matches())) throw new IllegalAccessException("Failed: Invalid tell");
        if ()
    }


}
