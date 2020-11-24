package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class FoodTest extends TestCase {

    @Test
    public void testIsEqual() {
        Food one = new Food("test", 1.00, true, "Aldi");
        Food two = new Food("test", 1.00, true, "Aldi");

        Boolean isEqual = one.isEqual(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        Food one = new Food("test", 1.00, true, "Aldi");
        Food two = new Food("test", 1.00, true, "Lidl");

        Boolean isEqual = one.isEqual(two);

        assertFalse(isEqual);
    }
}
