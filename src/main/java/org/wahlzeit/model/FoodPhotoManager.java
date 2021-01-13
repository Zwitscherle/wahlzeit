package org.wahlzeit.model;


import org.wahlzeit.utils.PatternInstance;

import java.sql.ResultSet;
import java.sql.SQLException;


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
