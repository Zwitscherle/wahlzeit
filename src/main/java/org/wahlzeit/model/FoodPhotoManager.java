package org.wahlzeit.model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodPhotoManager extends PhotoManager {

    public FoodPhoto[] photos;

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
     * TODO maybe this needs an adjustment
     */
    protected Photo createObject(ResultSet rset) throws SQLException {
        return PhotoFactory.getInstance().createPhoto(rset);
    }

    /**
     * @methodtype command
     * @methodproperties primitive
     */
    protected void doAddPhoto(Photo myPhoto) {
        photoCache.put(myPhoto.getId(), myPhoto);
    }

    // TODO add some new Method like isVegetarian?? (or maybe not because of UI)

    /**
     * TODO how to create new FoodPhoto
     */
    public Photo createPhoto(File file) throws Exception {
        PhotoId id = PhotoId.getNextId();
        Photo result = PhotoUtil.createPhoto(file, id);
        addPhoto(result);
        return result;
    }

}
