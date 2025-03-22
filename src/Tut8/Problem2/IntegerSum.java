package Tut8.Problem2;

import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String msg) {
        super(msg);
    }
}

class EmptyLineException extends Exception {
    public EmptyLineException(String msg) {
        super(msg);
    }
}

public class IntegerSum {
    private int[] numbers; // Mảng để lưu các số nguyên
    private int sum = 0;   // Lưu tổng số nguyên

    public IntegerSum(String input) throws InvalidInputException, EmptyLineException {
        checkValidate(input);
    }

    public void checkValidate(String input) throws InvalidInputException, EmptyLineException {
        if(input.equals("0")) {
            numbers = new int[]{0};
            sum = 0;
            return;
        }
        if (input == null || input.trim().isEmpty()) {
            throw new EmptyLineException("EmptyLineException: The series should not be empty!");
        }

        String[] tokens = input.trim().split("\\s+"); // Tách các số từ chuỗi
        numbers = new int[tokens.length]; // Khởi tạo mảng số nguyên

        boolean hasNonZero = false; // Kiểm tra có số nào khác 0 không

        for (int i = 0; i < tokens.length; i++) {
            try {
                int num = Integer.parseInt(tokens[i]);
                numbers[i] = num; // Lưu vào mảng
                if (num != 0) {
                    hasNonZero = true;
                    sum += num; // Cộng vào tổng nếu khác 0
                }
            } catch (NumberFormatException e) {
                throw new InvalidInputException("InvalidInputException: The series should contain only integers [-2147483648 to 2147483647]!");
            }
        }

        if (!hasNonZero) {
            throw new EmptyLineException("EmptyLineException: The series should not be empty!");
        }
    }

    public int getTotal() {
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sequence of integers (terminate with 0): ");
        String input = sc.nextLine();

        try {
            IntegerSum calculator = new IntegerSum(input);
            int result = calculator.getTotal();
            System.out.println("Sum of numbers: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}


