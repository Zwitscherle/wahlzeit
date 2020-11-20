package org.wahlzeit.model;


import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodPhotoManager extends PhotoManager {

    /**
     *
     */
    protected static final FoodPhotoManager instance = new FoodPhotoManager();

    /**
     *
     */
    public FoodPhotoManager() {
        super();
    }

    /**
     *
     */
    @Override
     protected FoodPhoto createObject(ResultSet rset) throws SQLException {
        return FoodPhotoFactory.getInstance().createPhoto(rset);
    }
}
