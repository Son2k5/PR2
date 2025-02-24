package Tutorial1.Pr2_Tutorial1_Activity1.Pr2_Tutorial1_Activity2;

import java.util.Scanner;

public class Activity2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        String upname= name.toUpperCase();
        System.out.println("Hello, " + upname + ", nice to meet you!");
        sc.close();
    }
}
