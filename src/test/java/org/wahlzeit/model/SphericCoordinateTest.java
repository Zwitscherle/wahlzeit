package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void testSameSphericCoordinate() throws AssertionError{
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(10,45, 3);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(10,45, 3);
        assertSame( one, two);
    }

    @Test
    public void testIsEqual() {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(10,45, 3);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(10,45,3);

        Boolean isEqual = one.isEqual(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(10,45, 3);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(20,45,3);

        Boolean isEqual = one.isEqual(two);

        assertFalse(isEqual);
    }

    @Test
    public void testEquals() {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(10,45, 3);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(10,45,3);

        Boolean isEqual = one.equals(two);

        assertTrue(isEqual);
    }

    @Test
    public void testNotEquals() {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(10,45, 3);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(20,45,3);

        Boolean isEqual = one.equals(two);

        assertFalse(isEqual);
    }

    @Test
    public  void testAsCartesianCoordinate() {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(1.107148,0.640522, 3.741657);

        CartesianCoordinate two = one.asCartesianCoordinate();
        CartesianCoordinate expected = CartesianCoordinate.createOrGetCartesianCoordinate(1,2,3);

        assertEquals(expected.getX(), two.getX(), 0.00001);
        assertEquals(expected.getY(), two.getY(), 0.00001);
        assertEquals(expected.getZ(), two.getZ(), 0.00001);
    }

    @Test
    public void testGetCartesianDistance() {
        // 1,2,3 to 2,3,4 in cartesian coordinates
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(1.107148,0.640522, 3.741657);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(0.982793,0.733581,5.385164);

        double distance = one.getCartesianDistance(two);
        double correctValue = Math.sqrt(3);

        assertEquals(correctValue, distance, 0.000001);
    }

    @Test
    public void testGetCentralAngle() {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(0.7853981633974484, 1.5707963267948966, 1.4142135623730951);
        SphericCoordinate two = SphericCoordinate.createOrGetSphericCoordinate(2.356194490192345, 1.5707963267948966, 1.4142135623730951);

        double angle = one.getCentralAngle(two);
        double correctValue = 90;

        assertEquals(correctValue, angle, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSphericCoordinateNaN() throws IllegalArgumentException {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(Double.NaN,1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSphericCoordinateInvalid() throws IllegalArgumentException {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(1,1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCentralAngleNull() throws NullPointerException {
        SphericCoordinate one = SphericCoordinate.createOrGetSphericCoordinate(1,1,1);
        CartesianCoordinate two = null;
        one.getCentralAngle(two);
    }

}
