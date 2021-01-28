package org.wahlzeit.model;

import java.util.Objects;

/*
Food Objekt Erstellung von FoodManager aus:
    1. createFood Methode im FoodManager wird aufgerufen
    2. createInstance Methode im zugehörigen FoodType wird aufgerufen
    3. Food Constructor wird aufgerufen und Objekt erstellt
    4. Objekt wird im FoodManager registriert
*/
public class Food {

    private FoodType foodType;
    private String foodName;
    private double price;
    private String vendor;

    private final double MAX_ERROR = 0.000001;

    public Food(FoodType foodType) {
        this.foodType = foodType;
    }

    public Food(FoodType foodType, String foodName, double price, String vendor) {
        this.foodType = foodType;
        this.foodName = foodName;
        this.price = price;
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    /**
     *
     * @methodtype boolean-query
     */
    public boolean isEqual(Food food) {
        return  food.getFoodName().equals(this.foodName) &&
                Math.abs(food.getPrice() - this.price) <= this.MAX_ERROR &&
                food.getVendor().equals(this.vendor) &&
                food.getFoodType().equals(this.foodType);
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
        return Objects.hash(this.foodName, this.price, this.vendor, this.foodType);
    }

}
