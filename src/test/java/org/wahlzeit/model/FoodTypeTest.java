package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTypeTest {

    @Test
    public void testIsEqual() {
        FoodType one = new FoodType("testType", true);
        FoodType two = new FoodType("testType", true);

        Boolean isEqual = one.equals(two);

        assertTrue(isEqual);
    }

    @Test
    public void testIsNotEqual() {
        FoodType one = new FoodType("testType", true);
        FoodType two = new FoodType("testType", false);

        Boolean isEqual = one.equals(two);

        assertFalse(isEqual);
    }

    @Test
    public void testAddSubType() {
        FoodType child = new FoodType("child", false);
        FoodType parent = new FoodType("parent", true);

        parent.addSubType(child);

        assertEquals(child.superType, parent);
    }


    @Test
    public void testHasInstance() {
        FoodType child = new FoodType("child", false);
        FoodType parent = new FoodType("parent", true);
        parent.addSubType(child);
        Food one = new Food(child);

        assertTrue(parent.hasInstance(one));
    }

    @Test
    public void testHasNoInstance() {
        FoodType child = new FoodType("child", false);
        FoodType parent = new FoodType("parent", true);
        parent.addSubType(child);
        Food one = new Food(parent);

        assertFalse(child.hasInstance(one));
    }

    @Test
    public void testIsSubtype() {
        FoodType children = new FoodType("child", false);
        FoodType parents = new FoodType("parent", true);
        FoodType grandParents = new FoodType("grandParents", false);
        FoodType greatGrandParents = new FoodType("greatGrandParents", false);

        greatGrandParents.addSubType(grandParents);
        grandParents.addSubType(parents);
        parents.addSubType(children);

        assertTrue(children.isSubType(greatGrandParents));
        assertTrue(parents.isSubType(greatGrandParents));
    }

    @Test
    public void testIsNoSubtype() {
        FoodType children = new FoodType("child", false);
        FoodType parents = new FoodType("parent", true);
        FoodType kartoffel = new FoodType("Kartoffel", true);
        FoodType grandParents = new FoodType("grandParents", false);
        FoodType greatGrandParents = new FoodType("greatGrandParents", false);

        greatGrandParents.addSubType(grandParents);
        grandParents.addSubType(parents);
        parents.addSubType(children);
        greatGrandParents.addSubType(kartoffel);

        assertFalse(children.isSubType(kartoffel));
    }


}
