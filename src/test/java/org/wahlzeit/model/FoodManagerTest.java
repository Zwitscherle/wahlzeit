package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FoodManagerTest {

    @Test
    public void testGetInstanceClass() {
        FoodManager manager = FoodManager.getInstance();
        assertEquals(FoodManager.class, manager.getClass());
    }

    @Test
    public void testCreateOrGetFoodType() {
        FoodType one = FoodManager.getInstance().createOrGetFoodType("testType", true);
        FoodType two = FoodManager.getInstance().createOrGetFoodType("testType", true);
        // expect both FoodTypes reference the same object, and hashmap has only one entry
        assertSame(one, two);
        // check for size is here ok, because there is no test which creates another different FoodType,
        // else this would be a problem because of the static manager...
        assertEquals(FoodManager.getInstance().typesCache.size(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssertValidFoodType() throws IllegalArgumentException {
        // foodType not registered in FoodManager throws exception
        FoodType one = new FoodType("newType", true);
        FoodManager.getInstance().createFood(one);
    }

    @Test
    public void testCreateFood() {
        FoodType one = FoodManager.getInstance().createOrGetFoodType("testType", true);
        Food newFood = FoodManager.getInstance().createFood(one);
        assertTrue(newFood.getFoodType().getTypeName().equals("testType"));
        assertTrue(newFood.getFoodType().isVegetarian());
        assertEquals(FoodManager.getInstance().foodCache.size(), 1);
    }

}
