package Pattern1.BetterCode.v2;

public class Main {
    public static void main(String[] args) {
        Builder b = new Builder();
        b.setName("Apple");
        b.setPrice(1000000);
        b.setBrand("Iphone");

        Product p  = new Product(b);
        

    }
}
