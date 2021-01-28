package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class FoodManager extends ObjectManager {

    // FoodManager as Singleton
    protected static final FoodManager instance = new FoodManager();

    protected HashMap<Integer, FoodType> typesCache = new HashMap<Integer, FoodType>();
    protected HashMap<Integer, Food> foodCache = new HashMap<Integer, Food>();

    public Food createFood(FoodType foodType) {
        assertIsValidType(foodType);
        FoodType type = this.typesCache.get(foodType.hashCode());
        Food food = type.createInstance();
        this.foodCache.put(food.hashCode(), food);
        return food;
    }

    public Food createFood(FoodType foodType, String foodName, double price, String vendor) {
        assertIsValidType(foodType);
        FoodType type = this.typesCache.get(foodType.hashCode());
        Food food = type.createInstance(foodName, price, vendor);
        this.foodCache.put(food.hashCode(), food);
        return food;
    }

    public FoodType createOrGetFoodType(String foodName, boolean vegetarian) {
        FoodType newFoodType = new FoodType(foodName, vegetarian);
        FoodType existingFood = this.typesCache.get(newFoodType.hashCode());
        if (existingFood != null) {
            return existingFood;
        }
        this.typesCache.put(newFoodType.hashCode(), newFoodType);
        return newFoodType;
    }

    public static final FoodManager getInstance() {
        return instance;
    }

    private void assertIsValidType(FoodType foodType) {
        if(!this.typesCache.containsKey(foodType.hashCode())) {
            throw new IllegalArgumentException("Food type does not exist");
        }
    }

    // not sure what to do with this function, not really needed here
    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException {
        return null;
    }
}
