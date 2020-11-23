package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class CartesianCoordinateTest extends TestCase {

    @Test
    public void testIsEqual() {
        CartesianCoordinate one = new CartesianCoordinate(1.0001,2, 3);
        CartesianCoordinate two = new CartesianCoordinate(1.0001,2,3);

        Boolean isEqual = one.isEqual(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        CartesianCoordinate one = new CartesianCoordinate(2.0001,2, 3);
        CartesianCoordinate two = new CartesianCoordinate(1.0001,2,3);

        Boolean isEqual = one.isEqual(two);

        assertFalse(isEqual);
    }

    @Test
    public void testGetCartesianDistance() {
        CartesianCoordinate one = new CartesianCoordinate(1,1, 1);
        CartesianCoordinate two = new CartesianCoordinate(2,2,2);

        double distance = one.getCartesianDistance(two);
        double correctValue = Math.sqrt(3);

        assertEquals(correctValue, distance, 0.000001);
    }

}
