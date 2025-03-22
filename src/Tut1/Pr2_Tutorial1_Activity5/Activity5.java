package Tut1.Pr2_Tutorial1_Activity5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Activity5 {
    public static void main(String[] args) {
        String filename = "input.txt";
        createInputFile(filename);
        try{
           int totalPrice= calculatePrice(filename);
           System.out.println(totalPrice);
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }
    public static void createInputFile(String filename) {
        String content = "7 3\n" +
                "500 2\n" +
                "600 3\n" +
                "700 1\n" +
                "300\n" +
                "1000\n" +
                "1100\n" +
                "100";

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("File " + filename + "  is exsited .");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            System.out.println("File " + filename + " is created sucessfully .");
        } catch (IOException e) {
            System.out.println("Problem when create file: " + e.getMessage());
        }
    }
    public static int calculatePrice(String filename) throws IOException{
        int total_Price = 0;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[] firstLine = br.readLine().split(" ");
        int n= Integer.parseInt(firstLine[0]);
        int m= Integer.parseInt(firstLine[1]);
        for(int i=0; i<m; i++){
            String[] product_Information = br.readLine().split(" ");
            int product = Integer.parseInt(product_Information[0]);
            int price = Integer.parseInt(product_Information[1]);
            total_Price += price * product;
        }
        br.close();
        return total_Price;

    }
}
