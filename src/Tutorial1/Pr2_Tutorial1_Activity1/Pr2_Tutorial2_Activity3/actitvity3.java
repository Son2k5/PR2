package Tutorial1.Pr2_Tutorial1_Activity1.Pr2_Tutorial2_Activity3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class actitvity3 {
    public static void main(String[] args) {
        String fileName = "testdata.txt";

        createTestDataFile(fileName);

        processStudentData(fileName);
    }

    public static void createTestDataFile(String fileName) {
        String fileContent = """
            John Doe
            85
            90
            78
            """;

        try {
            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("File '" + fileName + "' already exists.");
                return;
            }

            FileWriter writer = new FileWriter(file);
            writer.write(fileContent);
            writer.close();
            System.out.println("File '" + fileName + "' has been created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public static void processStudentData(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            String studentName = scanner.nextLine();

            int score1 = Integer.parseInt(scanner.nextLine());
            int score2 = Integer.parseInt(scanner.nextLine());
            int score3 = Integer.parseInt(scanner.nextLine());

            double averageScore = (score1 + score2 + score3) / 3.0;

            System.out.printf("Student: %s%n", studentName);
            System.out.printf("Average grade: %.2f%n", averageScore);

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("The file contains invalid data.");
            e.printStackTrace();
        }
    }
}
