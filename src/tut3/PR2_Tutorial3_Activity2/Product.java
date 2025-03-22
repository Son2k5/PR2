package tut3.PR2_Tutorial3_Activity2;
import java.util.Scanner;
public class Product {
    private String Name;
    private double Price;
    private double Discount;
    public Product() {
        this.Name = "";
        this.Price = 0.0;
        this.Discount = 0.0;
    }

    public Product(String name, double price, double discount) {
        this.Name = name;
        this.Price = price;
        this.Discount = discount;

    }

    public String getName() {
        return Name;
    }
    public double getPrice() {
        return Price;

    }
    public double getDiscount() {
        return Discount;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setPrice(double Price) {
        this.Price = Price;
    }
    public void setDiscount(double discount) {
        this.Discount = discount;
    }
    public double getImportTax(){
        return this.Price * 0.1;
    }
    public void display() {
        System.out.println("Product Name: " + this.Name);
        System.out.printf("Unit Price: $%.2f\n", this.Price);
        System.out.println("Discount: " + this.Discount + "%");
        System.out.printf("Import Tax: $%.2f\n", getImportTax());
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        this.Name = scanner.nextLine();
        System.out.print("Enter unit price: ");
        this.Price = scanner.nextDouble();
        System.out.print("Enter discount percentage: ");
        this.Discount = scanner.nextDouble();
    }
}


