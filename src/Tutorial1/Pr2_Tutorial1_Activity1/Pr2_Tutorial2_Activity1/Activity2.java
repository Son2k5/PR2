package Tutorial1.Pr2_Tutorial1_Activity1.Pr2_Tutorial2_Activity1;
import java.util.Random;
public class Activity2 {
    public static void main(String[] args) {
        Random rand = new Random();

        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        int sum = die2 + die1;
        System.out.println("The first die comes up: " + die1);
        System.out.println("The second die comes up: " + die2);
        System.out.println("Your total roll is: " + sum);
    }
}
