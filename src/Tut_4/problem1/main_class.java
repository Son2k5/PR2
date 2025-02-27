package Tut_4.problem1;

public class main_class {
    public static void main(String[] args) {
        // Creating a Product object
        Product product = new Product("Laptop", 1200.0, 15);

        // Display initial product information
        System.out.println("Initial Product Details:");
        product.displayInformation();

        // Modifying product details using setters
        product.setName("Gaming Laptop");
        product.setPrice(1500.0);
        product.setDiscount(10);

        // Display updated product information using getters
        System.out.println("\nUpdated Product Details:");
        System.out.println("Product Name: " + product.getName());
        System.out.println("Unit Price: $" + product.getPrice());
        System.out.println("Discount: " + product.getDiscount() + "%");
        System.out.println("Import Tax: $" + product.calculateImportTax());
    }
}
