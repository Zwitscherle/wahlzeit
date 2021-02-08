package org.wahlzeit.model;

import java.util.Objects;

/*
Food object creation starting from FoodManager:
    1. CreateFood methode in the FoodManager is called
    2. CreateInstance methode with the corresponding FoodType is called
    3. Food constructor is called and the Food object gets created
    4. Object gets registered in the FoodManager Cache

The object creation as a point in the solution space:
    1. Delegation of Object Creation: separate-object (Through FoodType and FoodManager).
    2. Selection of Concrete Class: On-the-spot has its own hard coded constructor
    3. Configuration of Class Mapping: In-code (no special configuration)
    4. Instantiation of Concrete Class: By-class-object, there is a FoodType object which creates the Concrete Class
    (does not match perfectly, because th Food class is still the same, but I think this is more reasonable than in-code)
    5. Initialization of New Object: Default, fixed field assignment in constructor
    6. Building of Object Structure: Default, New object creates dependent object structure
    (Maybe also a bit By-building regarding the FoodType, which has to be created beforehand)
*/
public class Food {

    /**
     * Collaboration Food/FoodPhoto (Client-Service Collaboration) (no attribute here):
     * - Description/Purpose:
     *   Provides specific information about the FoodPhoto content
     * - Role: Service
     * - Binds: Food with FoodPhoto
     */

    /**
     * Food/FoodType Collaboration (Client-Service Collaboration):
     * - Description/Purpose:
     *   Has knowledge to which FoodType an Instance belongs
     * - Role: Base Object
     * - Binds: Food with a certain FoodType
    */
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
