package Tut4.problem1;

public class Product {
    private String name;
    private double price;
    private double discount;


    public Product(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.discount = 0.0;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }


    public void setName(String Name) {
        this.name = Name;
    }

    public void setPrice(double Price) {
        this.price = Price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public double calculateImportTax() {
        return price * 0.10;
    }


    public void displayInformation() {
        System.out.println("Product Name: " + name);
        System.out.println("Unit Price: $" + price);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Import Tax: $" + calculateImportTax());
    }
}
