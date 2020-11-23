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
        // 1,2,3 to 2,3,4 in cartesian coordinates
        SphericCoordinate one = new SphericCoordinate(1.107148,0.640522, 3.741657);
        SphericCoordinate two = new SphericCoordinate(0.982793,0.733581,5.385164);

        double angle = one.getCentralAngle(two);
        System.out.println(angle);
        // TODO create test with solid values (draw example...)
        double correctValue = Math.sqrt(3);

        assertEquals(correctValue, angle, 0.000001);
    }
}
