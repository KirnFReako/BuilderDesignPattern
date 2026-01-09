package Pattern1.ProblematicCode;

import java.util.ArrayList;
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

    Product(String name, String desc, String brand, int price, String Category, int discount, String createdAt, String updatedAt, ArrayList<String> images){

        this.name= name;
        this.desc = desc;
        this.brand = brand;
        this.price = price;
        this.Category = Category;
        this.discount = discount;
        this.createdAt= createdAt;
        this.updatedAt = updatedAt;
        this.images = images;


    }


}
