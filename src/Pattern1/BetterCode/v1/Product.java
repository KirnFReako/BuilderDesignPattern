package Pattern1.BetterCode.v1;

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

    Product(){
    }
// SETTER
    public void setName(String name){
        this.name =name;
    }

    public void setPrice(int price){
      this.price = price;
    }

    public void setBrand(String brand){
        this.brand = brand;

    }
    public void setCategory(String category){
        this.Category = category;

    }
    public void setDesc(String desc){
        this.desc = desc;


    }
    public void setDiscount(int discount){
        this.discount = discount;

    }
    public void setCreatedAt(String createdAt){
        this.createdAt= createdAt;

    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt= updatedAt;

    }
    public void setImages(ArrayList<String> images){
this.images= images;
    }


}

