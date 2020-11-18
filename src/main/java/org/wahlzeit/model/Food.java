package org.wahlzeit.model;

public class Food {

    private String foodName;
    private double price;
    private boolean vegetarian;
    private String vendor;

    public Food(String foodName, double price, boolean vegetarian, String vendor) {
        this.foodName = foodName;
        this.price = price;
        this.vegetarian = vegetarian;
        this.vendor = vendor;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
