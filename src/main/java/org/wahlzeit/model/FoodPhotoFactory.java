package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

public class FoodPhotoFactory extends PhotoFactory {

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static FoodPhotoFactory instance = null;

    /**
     * Public singleton access method. TODO needed?
     */
    public static synchronized FoodPhotoFactory getInstance() {
        if (instance == null) {
            SysLog.logSysInfo("setting generic PhotoFactory");
            setInstance(new FoodPhotoFactory());
        }
        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(FoodPhotoFactory foodPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize PhotoFactory twice");
        }
        instance = foodPhotoFactory;
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     *
     */
    protected FoodPhotoFactory() {
        super();
    }

    /**
     * @methodtype factory
     */
    public FoodPhoto createFoodPhoto() {
        return new FoodPhoto();
    }

    /**
     * @methodtype factory
     */
    public FoodPhoto createFoodPhoto(PhotoId id) {
        return new FoodPhoto(id);
    }

    /**
     * @methodtype factory
     */
    public FoodPhoto createFoodPhoto(Food food) {
        return new FoodPhoto(food);
    }

}
