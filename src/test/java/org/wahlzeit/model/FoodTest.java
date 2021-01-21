package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class FoodTest extends TestCase {

    @Test
    public void testIsEqual() {
        FoodType test = new FoodType("testType", true);
        Food one = new Food(test, "test", 1.00, "Aldi");
        Food two = new Food(test, "test", 1.00, "Aldi");

        Boolean isEqual = one.isEqual(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        FoodType test = new FoodType("testType", true);
        Food one = new Food(test, "test1", 1.00, "Aldi");
        Food two = new Food(test, "test", 1.00, "Aldi");

        Boolean isEqual = one.isEqual(two);

        assertFalse(isEqual);
    }
}
