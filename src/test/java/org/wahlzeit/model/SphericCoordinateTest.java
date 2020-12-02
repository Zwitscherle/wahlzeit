package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class SphericCoordinateTest extends TestCase {

    @Test
    public void testIsEqual() {
        SphericCoordinate one = new SphericCoordinate(10,45, 3);
        SphericCoordinate two = new SphericCoordinate(10,45,3);

        Boolean isEqual = one.isEqual(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        SphericCoordinate one = new SphericCoordinate(10,45, 3);
        SphericCoordinate two = new SphericCoordinate(20,45,3);

        Boolean isEqual = one.isEqual(two);

        assertFalse(isEqual);
    }

    @Test
    public void testEquals() {
        SphericCoordinate one = new SphericCoordinate(10,45, 3);
        SphericCoordinate two = new SphericCoordinate(10,45,3);

        Boolean isEqual = one.equals(two);

        assertTrue(isEqual);
    }

    @Test
    public void testNotEquals() {
        SphericCoordinate one = new SphericCoordinate(10,45, 3);
        SphericCoordinate two = new SphericCoordinate(20,45,3);

        Boolean isEqual = one.equals(two);

        assertFalse(isEqual);
    }

    @Test
    public  void testAsCartesianCoordinate() {
        SphericCoordinate one = new SphericCoordinate(1.107148,0.640522, 3.741657);

        CartesianCoordinate two = one.asCartesianCoordinate();
        CartesianCoordinate expected = new CartesianCoordinate(1,2,3);

        assertEquals(expected.getX(), two.getX(), 0.00001);
        assertEquals(expected.getY(), two.getY(), 0.00001);
        assertEquals(expected.getZ(), two.getZ(), 0.00001);
    }

    @Test
    public void testGetCartesianDistance() {
        // 1,2,3 to 2,3,4 in cartesian coordinates
        SphericCoordinate one = new SphericCoordinate(1.107148,0.640522, 3.741657);
        SphericCoordinate two = new SphericCoordinate(0.982793,0.733581,5.385164);

        double distance = one.getCartesianDistance(two);
        double correctValue = Math.sqrt(3);

        assertEquals(correctValue, distance, 0.000001);
    }

    @Test
    public void testGetCentralAngle() {
        SphericCoordinate one = new SphericCoordinate(0.7853981633974484, 1.5707963267948966, 1.4142135623730951);
        SphericCoordinate two = new SphericCoordinate(2.356194490192345, 1.5707963267948966, 1.4142135623730951);

        double angle = one.getCentralAngle(two);
        double correctValue = 90;

        assertEquals(correctValue, angle, 0.1);
    }
}
