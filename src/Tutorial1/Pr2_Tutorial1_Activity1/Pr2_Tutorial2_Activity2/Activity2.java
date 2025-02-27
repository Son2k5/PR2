package Tutorial1.Pr2_Tutorial1_Activity1.Pr2_Tutorial2_Activity2;
import java.util.Scanner;
public class Activity2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of quarters: ");
        double quarters = sc.nextDouble();
        System.out.println("Enter the number of dimes: ");
        double dimes = sc.nextDouble();
        System.out.println("Enter the number of nickels: ");
        double nickels = sc.nextDouble();
        System.out.println("Enter the number of pens: ");
        double  pens = sc.nextDouble();

        double total = quarters *0.25 + dimes* 0.10 + nickels*0.05 + pens* 0.01;
        System.out.printf("Total is $%.2f\n", total);
    }
}
