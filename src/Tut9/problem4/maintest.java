package Tut9.problem4;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class maintest {
    public static void main(String[] args) {
        try {
            IOFile file = new IOFile("test.txt");
            file.write("\nHello, this is a test file.\nThis is the second line.");
            System.out.println("Number of lines: " + file.countLine());
            file.print();
            file.write("\nThis should be the third line.\nAnd the four line.");
            file.copy("./demo/test.txt");
            file.print();
            file.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
