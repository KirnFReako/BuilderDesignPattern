package Pattern1.BetterCode.v2;

import java.util.List;

public class Builder {


    private String name;

    private String desc;

    private int price;

    private String brand;

    private String Category;

    private int discount;

    private String createdAt;

    private String updatedAt;

    private List<String> images;

    Builder() {
    }

    //GETTER

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.desc;
    }

    public int getPrice(){
        return  this.price;
    }



    // SETTER
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

    public void setCategory(String category) {
        this.Category = category;

    }

    public void setDesc(String desc) {
        this.desc = desc;


    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

