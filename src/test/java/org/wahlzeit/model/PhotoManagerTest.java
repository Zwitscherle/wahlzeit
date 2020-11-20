package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class PhotoManagerTest extends TestCase {

    /**
     * Check that PhotoManager uses the instance of FoodPhotoManager
     */
    @Test
    public void testGetInstanceClass() {
        PhotoManager instance = PhotoManager.getInstance();
        assertEquals(FoodPhotoManager.class, instance.getClass());
    }

}
