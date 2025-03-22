package Tut9.problem2;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.*;

public class maintest {
    public static void main(String[] args) {
        // test students
        try {
            Student st1 = new Student("Nam@", "CNTT", 8.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student st2 = new Student("Hung", "PSD2", 6.3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student st3 = new Student("Nhu", "CNTT", -4.4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student st4 = new Student("Nhung", "ESPD", 24.4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student st5 = new Student("", "ESPD", 6.8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student st6 = new Student("Loi", "", 7.4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student st7 = new Student("Yen Nhi", "ESPD", 7.4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Add students to list
        @SuppressWarnings("unchecked")
        List<Student> studentList = new ArrayList<Student>();
        try {
            studentList.add(new Student("Tuan", "CNTT"));
            studentList.add(new Student("Long", "MME", 9.0));
            studentList.add(new Student("DangBinh", "ESPD", 6.9));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Write obj to file
        try {
            File f = new File("./demo");
            if (!f.exists()) {
                f.mkdir();
                Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwxrwx");
                Files.setPosixFilePermissions(f.toPath(), perms);
            }
            XFile.writeObject(f.getPath() + "/students.dat", studentList);
            System.out.println("End write file!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // read object
        try {
            Object obj = XFile.readObject("./demo/students.dat");
            if (obj instanceof List) {
                @SuppressWarnings("unchecked")
                List<Student> studentObjs = (List<Student>) obj;
                System.out.println("Students read from file:");
                for (Student s : studentObjs) {
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
