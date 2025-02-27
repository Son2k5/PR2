package Tutorial1.Pr2_Tutorial1_Activity1.Pr2_Tutorial2_Activity5;
import java.util.Scanner;
public class Activity5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bitset number: ");
        long a = sc.nextLong();
        long b = sc.nextLong();
        long position = lowestCommon(a, b);
        System.out.println("The lowest common bitset is: " + position);
        sc.close();
    }
    public static long lowestCommon(long a, long b) {
        long commonBit = a & b;
        if(commonBit == 0){
            return -1;
        }
        int position = 0;
        while((commonBit & 1) == 0){
            commonBit >>= 1;
            position++;
        }
        return position;
    }
}
