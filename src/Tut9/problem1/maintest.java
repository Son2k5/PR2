package Tut9.problem1;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class maintest {
    public static void main(String[] args) {
        try {
            // Read a binary file
            byte[] data = XFile.read("Albert-Einstein-Quote-Everybody-is-a-genius-But-if-you-judge-a.jpg");
            System.out.println(data.length);
            // Write to another file
            XFile.write("test.jpg", data);

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
