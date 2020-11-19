package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class CoordinateTest extends TestCase {

    @Test
    public void testIsEqual() {
        Coordinate one = new Coordinate(1.0001,2, 3);
        Coordinate two = new Coordinate(1.0001,2,3);

        Boolean isEqual = one.isEqual(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        Coordinate one = new Coordinate(2.0001,2, 3);
        Coordinate two = new Coordinate(1.0001,2,3);

        Boolean isEqual = one.isEqual(two);

        assertFalse(isEqual);
    }

    @Test
    public void testGetDistance() {
        Coordinate one = new Coordinate(1,1, 1);
        Coordinate two = new Coordinate(2,2,2);

        double distance = one.getDistance(two);
        double correctValue = Math.sqrt(3);

        assertEquals(correctValue, distance, 0.000001);
    }

}
