package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodPhoto extends Photo {

    private Food food;

    public FoodPhoto() {
        super();
    }

    public FoodPhoto(PhotoId myId) {
        super(myId);
    }

    public FoodPhoto(Food food) {
        super();
        if (food == null) {
            throw new IllegalArgumentException("Food can not be empty");
        }
        this.food = food;
    }

    public FoodPhoto(ResultSet rset) throws SQLException {
        if (rset == null) {
            throw new IllegalArgumentException("ResultSet can not be empty");
        }
        readFrom(rset);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food can not be empty");
        }
        this.food = food;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        String foodName = rset.getString("foodName");
        double price = rset.getDouble("price");
        boolean vegetarian = rset.getBoolean("vegetarian");
        String vendor = rset.getString("vendor");
        this.food = new Food(foodName, price, vegetarian, vendor);
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString("foodName", food.getFoodName());
        rset.updateDouble("price", food.getPrice());
        rset.updateBoolean("vegetarian", food.isVegetarian());
        rset.updateString("vendor", food.getVendor());
    }


}
