package Pattern1.BetterCode.v3;

import java.util.List;

public class Product  {
    private String name;

    private  String desc;

    private int price;

    private  String brand;

    private String Category;

    private int discount;

    private String createdAt;

    private  String updatedAt;

    private List<String> images;


    private Product(Builder b){
        if(b.getPrice() > 0){
            this.price = b.getPrice();
        }
        this.name= b.getName();
        this.price= b.getPrice();
        this.brand= b.getBrand();
        this.createdAt= b.getCreatedAt();
        this.updatedAt= b.getUpdatedAt();
        this.desc= b.getDesc();
    }

    //brand new Method create builder and get Builder and making it static so that it will call firstly before the product object

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{


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

        public Product build(){
        return new Product(this);
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
        public Builder setName(String name) {
        this.name = name;
        return this;
    }

        public Builder setPrice(int price) {
        if(price >0) return this;
        this.price = price;
        return this;
    }

        public Builder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

        public String getBrand(){ return this.brand ;}

        public String getCategory(){ return this.Category ;}

        public String getUpdatedAt(){ return this.updatedAt;}

        public String getCreatedAt(){ return this.createdAt ;}



        public void setCreatedAt(String createdAt){
        this.createdAt= createdAt;
    }


        public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

        public void setCategory(String category) {
        this.Category = category;

    }

        public Builder setDesc(String desc) {
        this.desc = desc;
        return this;

    }

        public void setDiscount(int discount) {
        this.discount = discount;
    }
    }
}
