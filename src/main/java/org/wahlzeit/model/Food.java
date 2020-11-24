package org.wahlzeit.model;

import java.util.Objects;

public class Food {

    private String foodName;
    private double price;
    private boolean vegetarian;
    private String vendor;

    private final double MAX_ERROR = 0.000001;

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

    /**
     *
     * @methodtype boolean-query
     */
    public boolean isEqual(Food food) {
        return  food.getFoodName().equals(this.foodName) &&
                Math.abs(food.getPrice() - this.price) <= this.MAX_ERROR &&
                food.isVegetarian() == this.vegetarian &&
                food.getVendor().equals(this.vendor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food otherFood = (Food) o;
        return isEqual(otherFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.foodName, this.price, this.vegetarian, this.vendor);
    }
}
