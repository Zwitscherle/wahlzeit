package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodPhotoFactory extends PhotoFactory {

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static FoodPhotoFactory instance = null;

    /**
     * Override public singleton access method. Initialize as FoodPhotoFactory.
     */
    public static synchronized FoodPhotoFactory getInstance() {
        if (instance == null) {
            SysLog.logSysInfo("setting generic FoodPhotoFactory");
            setInstance(new FoodPhotoFactory());
        }
        return instance;
    }

    /**
     * Method to set the singleton instance of FoodPhotoFactory.
     */
    protected static synchronized void setInstance(FoodPhotoFactory foodPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize FoodPhotoFactory twice");
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
    }

    /**
     * @methodtype factory
     */
    @Override
    public FoodPhoto createPhoto() {
        return new FoodPhoto();
    }

    /**
     * @methodtype factory
     */
    @Override
    public FoodPhoto createPhoto(PhotoId id) {
        if (id == null) {
            throw new IllegalArgumentException("PhotoId can not be empty");
        }
        return new FoodPhoto(id);
    }

    /**
     * @methodtype factory
     */
    public FoodPhoto createPhoto(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food can not be empty");
        }
        return new FoodPhoto(food);
    }

    /**
     * @methodtype factory
     */
    @Override
    public FoodPhoto createPhoto(ResultSet rs) throws SQLException {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet can not be empty");
        }
        return new FoodPhoto(rs);
    }

}
