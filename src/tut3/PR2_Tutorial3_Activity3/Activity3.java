package tut3.PR2_Tutorial3_Activity3;

public class Activity3 {
    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product();
        System.out.println("Enter details for Product 1:");
        product1.input();

        System.out.println("\nEnter details for Product 2:");
        product2.input();

        // Hiển thị thông tin sản phẩm
        System.out.println("\nProduct 1 details:");
        product1.display();

        System.out.println("\nProduct 2 details:");
        product2.display();
    }
    
}
