package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FoodPhotoTest {

    @Test
    public void testCreateFoodPhoto() {
        Food testFood = new Food("Kartoffel", 1.0, true, "Edeka");

        FoodPhoto testPhoto= new FoodPhoto(testFood);

        assertEquals(testPhoto.getClass(),FoodPhoto.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFoodPhotoNull() throws IllegalArgumentException {
        Food testFood = null;
        FoodPhoto testPhoto= new FoodPhoto(testFood);
    }

}
