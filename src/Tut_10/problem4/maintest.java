package Tut_10.problem4;

class NotPossibleException extends Exception {
    public NotPossibleException(String message) {
        super(message);
    }
}
 class FactorialRecursive {

    private static FactorialRecursive[] cache = new FactorialRecursive[6];
    private double value;


    private FactorialRecursive(double value) {
        this.value = value;
    }


    public static FactorialRecursive get(int n) throws NotPossibleException {

        if (n < 0) {
            throw new NotPossibleException("FactorialRecursive get: Index " + (n-1) + " out of bounds for length " + cache.length);
        }


        if (cache[0] == null) {
            cache[0] = new FactorialRecursive(1.0);


            for (int i = 1; i < 6; i++) {
                cache[i] = new FactorialRecursive(i * cache[i-1].getValue());
            }
        }


        if (n < cache.length) {
            return cache[n];
        } else {

            return new FactorialRecursive(n * get(n-1).getValue());
        }
    }


    public double getValue() {
        return value;
    }
}
public class maintest {
    public static void main(String[] args) {
        try {
            FactorialRecursive f1 = FactorialRecursive.get(5);
            System.out.println("Factorial of 5: " + f1.getValue());

            FactorialRecursive f2 = FactorialRecursive.get(3);
            System.out.println("Factorial of 3: " + f2.getValue());

            FactorialRecursive f3 = FactorialRecursive.get(6);
            System.out.println("Factorial of 6: " + f3.getValue());

            FactorialRecursive f4 = FactorialRecursive.get(-4);
            System.out.println("Factorial of -4: " + f4.getValue());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
