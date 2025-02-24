package Tutorial1.Pr2_Tutorial1_Activity1.Pr2_Tutorial1_Activity3;

import java.util.Scanner;

public class Activity3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of eggs: ");
        int totalEggs = sc.nextInt();
        if(totalEggs > 144) {
            FindLargeNumberEggs(totalEggs);
        }
        else if(totalEggs == 144) {
            System.out.println("Your number of eggs is: 1 gross");

        }
        else if(totalEggs == 12) {
            System.out.println("Your number of eggs is: 1 dozen12");

        }
        else{
            FindNumberEggs(totalEggs);
        }
    }
    public static void FindLargeNumberEggs(int totalEggs) {
        int gross= totalEggs / 144;
        int remainderGross = totalEggs % 144;

        int dozen = remainderGross / 12;
        int leftover = remainderGross % 12;

        System.out.println("Your number of eggs is:");
        System.out.println(gross + " gross, " + dozen + " dozen, and " + leftover + " leftover eggs.");
    }
    public static void FindNumberEggs(int totalEggs) {
        int dozen = totalEggs / 12;
        int leftover = totalEggs % 12;
        System.out.println("Your number of eggs is:");
        System.out.println(dozen + " dozen, " + leftover + " leftover eggs.");
    }
}
