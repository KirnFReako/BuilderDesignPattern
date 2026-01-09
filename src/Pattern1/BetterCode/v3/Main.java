package Pattern1.BetterCode.v3;


public class Main {
    public static void main(String[] args) {
       Product p= Product.getBuilder()
               .setName("Iphone")
               .setPrice(10000)
               .setBrand("Apple")
               .setDesc("Iphone 11")
               .build();
    }
}
