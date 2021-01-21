package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FoodPhotoTest {

    @Test
    public void testCreateFoodPhoto() {
        FoodType type = new FoodType("Gemüse", true);
        Food testFood = new Food(type, "Karotte", 1.0, "Edeka");

        FoodPhoto testPhoto= new FoodPhoto(testFood);

        assertEquals(testPhoto.getClass(),FoodPhoto.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFoodPhotoNull() throws IllegalArgumentException {
        Food testFood = null;
        FoodPhoto testPhoto= new FoodPhoto(testFood);
    }

}
