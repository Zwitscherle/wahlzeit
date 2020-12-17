package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class FoodPhotoTest extends TestCase {

    @Test
    public void testCreateFoodPhoto() {
        Food testFood = new Food("Kartoffel", 1.0, true, "Edeka");

        FoodPhoto testPhoto= new FoodPhoto(testFood);

        assertEquals(testPhoto.getClass(),FoodPhoto.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFoodPhotoNull() {
        Food testFood = null;
        FoodPhoto testPhoto= new FoodPhoto(testFood);
    }

}
