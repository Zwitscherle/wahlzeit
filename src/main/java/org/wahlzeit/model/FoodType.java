package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class FoodType {

    private static FoodManager manager = FoodManager.getInstance();
    // type specific fields
    private String typeName;
    private boolean vegetarian;
    // super and subTypes
    protected FoodType superType = null;
    protected Set<FoodType> subTypes = new HashSet<FoodType>();

    public FoodType(String typeName, boolean vegetarian) {
        this.typeName = typeName;
        this.vegetarian = vegetarian;
    }

    public Food createInstance() {
        return new Food(this);
    }

    public Food createInstance(String foodName, double price, String vendor) {
        return new Food(this, foodName, price, vendor);
    }

    // FoodType hierarchy:
    public boolean hasInstance(Food food) {
        assert (food != null): "food is null";
        if (food.getFoodType() == this) {
            return true;
        }
        for (FoodType type: subTypes) {
            if (type.hasInstance(food)) {
                return  true;
            }
        }
        return false;
    }

    public FoodType getSuperType() {
        return this.superType;
    }

    public void setSuperType(FoodType foodType) {
        this.superType = foodType;
    }

    public Iterator<FoodType> getSubTypeIterator() {
        return this.subTypes.iterator();
    }

    public void addSubType(FoodType foodType) {
        assert(foodType != null): "foodType is null";
        foodType.setSuperType(this);
        this.subTypes.add(foodType);
    }

    public boolean isSubType(FoodType foodType) {
        FoodType curType = this.superType;
        while (curType != null) {
            if(curType.equals(foodType)) {
                return true;
            }
            curType = curType.getSuperType();
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodType foodType = (FoodType) o;
        return isEqual(foodType);
    }

    public boolean isEqual(FoodType foodType) {
        return this.typeName.equals(foodType.typeName) && this.vegetarian == foodType.vegetarian;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName + vegetarian);
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
}
