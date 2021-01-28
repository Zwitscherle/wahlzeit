package org.wahlzeit.model;


import org.wahlzeit.utils.PatternInstance;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Der FoodPhotoManager Singleton wird zu Beginn initalisiert und verwaltet alle FoodPhotos
    und delegiert die Erstellung an die FoodPhotoFactory.
 */
@PatternInstance(
        patternNames = {"Mediator Pattern", "Singleton"},
        participants ={"MediatorInstance", "Singleton"}
)
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
        if (rset == null) {
            throw new IllegalArgumentException("ResultSet can not be empty");
        }
        return FoodPhotoFactory.getInstance().createPhoto(rset);
    }
}
