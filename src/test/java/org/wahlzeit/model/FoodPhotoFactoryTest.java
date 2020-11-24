package org.wahlzeit.model;

import org.junit.Test;

public class FoodPhotoFactoryTest {

    @Test(expected = IllegalStateException.class)
    public void testIllegalStateException() throws Exception {
        FoodPhotoFactory.initialize();
        FoodPhotoFactory test = new FoodPhotoFactory();

        FoodPhotoFactory.setInstance(test);
    }

}
