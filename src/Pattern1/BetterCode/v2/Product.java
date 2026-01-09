package Pattern1.BetterCode.v2;

import java.util.List;

public class Product {

    private String name;

    private  String desc;

    private int price;

    private  String brand;

    private String Category;

    private int discount;

    private String createdAt;

    private  String updatedAt;

    private List<String> images;


    Product(Builder b){
        if(b.getPrice() >0){
            this.price = b.getPrice();
        }
        this.name = b.getName();
        //..
    }

}
