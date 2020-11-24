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
    public void testAsSphericCoordinate() {
        CartesianCoordinate one = new CartesianCoordinate(1,2, 3);

        SphericCoordinate two = one.asSphericCoordinate();
        SphericCoordinate expected = new SphericCoordinate(1.107148,0.640522, 3.741657);

        assertEquals(expected.getPhi(), two.getPhi(), 0.000001);
        assertEquals(expected.getTheta(), two.getTheta(), 0.000001);
        assertEquals(expected.getRadius(), two.getRadius(), 0.000001);
    }


    @Test
    public void testGetCartesianDistance() {
        CartesianCoordinate one = new CartesianCoordinate(1,1, 1);
        CartesianCoordinate two = new CartesianCoordinate(2,2,2);

        double distance = one.getCartesianDistance(two);
        double correctValue = Math.sqrt(3);

        assertEquals(correctValue, distance, 0.000001);
    }

    @Test
    public void testGetCentralAngle() {
        CartesianCoordinate one = new CartesianCoordinate(1,1,0);
        CartesianCoordinate two = new CartesianCoordinate(-1,1,0 );

        double angle = one.getCentralAngle(two);
        double correctValue = 90;

        assertEquals(correctValue, angle, 0.1);
    }

}