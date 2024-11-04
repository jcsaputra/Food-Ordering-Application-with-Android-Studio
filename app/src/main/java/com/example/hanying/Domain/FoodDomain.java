package com.example.hanying.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String foodName;
    private String foodPic;
    private String foodDescription;
    private Double foodPrice;
    private int numberInCart;

    public FoodDomain(String foodName, String foodPic, String foodDescription, Double foodPrice) {
        this.foodName = foodName;
        this.foodPic = foodPic;
        this.foodDescription = foodDescription;
        this.foodPrice = foodPrice;
    }

    public FoodDomain(String foodName, String foodPic, String foodDescription, Double foodPrice, int numberInCart) {
        this.foodName = foodName;
        this.foodPic = foodPic;
        this.foodDescription = foodDescription;
        this.foodPrice = foodPrice;
        this.numberInCart = numberInCart;
    }

    public String getName() {
        return foodName;
    }

    public void setTitle(String foodName) {
        this.foodName = foodName;
    }

    public String getPic() {
        return foodPic;
    }

    public void setPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public String getDescription() {
        return foodDescription;
    }

    public void setDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public Double getPrice() {
        return foodPrice;
    }

    public void setPrice(Double fee) {
        this.foodPrice = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
