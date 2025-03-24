package Tut_10.problem3;

import java.lang.reflect.Constructor;
import java.util.Scanner;
class NotPossibleException extends Exception {
    public NotPossibleException(String msg) {
        super(msg);
    }
}

class IntegerRecursiveSequence{
    private static IntegerRecursiveSequence instance;
    int count;
    private IntegerRecursiveSequence(){
        this.count = 0;
    }
    public static IntegerRecursiveSequence getInstance(){
        if(instance == null){
            instance = new IntegerRecursiveSequence();
        }
        return instance;
    }
    public void setCount(int count) throws NotPossibleException{
        if(count <= 0){
            throw new NotPossibleException("IntegerRecursiveSequence setter: Invalid count " + count);
        }
        this.count = count;
    }
    private int getEvenNumber(int num){
        if(num <= 0) return 0;
        return getEvenNumber(num -1) + 2;
    }
    public void printEvenSequence(){
        for(int i = 0; i < count; i++) {
            System.out.print(getEvenNumber(i));
            if(i != count-1){
                System.out.print(", ");
            }
        }
    }
    private int getTriagular(int num){
        if(num <= 0) return 0;
        return num + getTriagular(num - 1);
    }
    public void printTriangularSequence(){
        for(int i = 0; i < count; i++) {
            System.out.print(getTriagular(i));
            if(i < count - 1){
                System.out.print(", ");
            }
        }

    }
    private int getFibonacci(int num){
        if(num <= 0) return 0;
        if(num == 1) return 1;
        return getFibonacci(num - 1) + getFibonacci(num - 2);
    }
    public void printFibonacciSequence(){
        for(int i = 0; i < count; i++) {
            System.out.print(getFibonacci(i));
            if(i < count - 1){
                System.out.print(", ");
            }
        }
    }


}
public class maintest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of sequence: ");
        int count = sc.nextInt();
        try {
            IntegerRecursiveSequence isr = IntegerRecursiveSequence.getInstance();
            IntegerRecursiveSequence isr2 = IntegerRecursiveSequence.getInstance();
            System.out.println("Instances are the same? " + (isr == isr2));
            isr.setCount(count);
            System.out.println("Even sequence: ");
            isr.printEvenSequence();
            System.out.println("\nTriangular sequence: ");
            isr2.printTriangularSequence();
            System.out.println("\nFibonacci sequence: ");
            isr.printFibonacciSequence();
            System.out.println();

            // Check if developers left any public constructors
            Constructor<?>[] constructors = IntegerRecursiveSequence.class.getDeclaredConstructors();
            boolean hasPublicConstructor = false;

            for (Constructor<?> constructor : constructors) {
                if (constructor.canAccess(null)) {
                    hasPublicConstructor = true;
                    break;
                }
            }

            if (hasPublicConstructor) {
                System.out.println("WARNING: Public constructor found! Singleton pattern is violated.");
            } else {
                System.out.println("Singleton pattern is correctly implemented.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
