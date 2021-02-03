package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
I will describe the object creation process, if everything would be fully implemented.
(client based food creation from ui, which is currently not part of wahlzeit)
Food object creation from FoodManager:
    1. FoodPhotoManager is called, and the createPhoto method is executed (from parent class PhotoManager)
    2. In createPhoto from PhotoManager the PhotoUtils createPhoto method will be called
    3. In PhotoUtils the FoodPhotoFactory createPhoto method is called
    4. Here finally the FoodPhoto constructor is called, which also uses parts of the Photo constructor (which is the parent class of FoodPhoto)
    (For a full implementation we also would need to create the corresponding Food object of the FoodPhoto class.
    Which would most likely also be done via the FoodManager, but this is currently not implemented in wahlzeit)
    5. After that the FoodPhoto object will be saved in the PhotoCache of the FoodPhotoManager

The object creation as a point in the solution space:
    1. Delegation of Object Creation: separate-object (FoodPhotoFactory).
    2. Selection of Concrete Class: By-subclassing (extends the Photo object).
    3. Configuration of Class Mapping: In-code (no special configuration)
    4. Instantiation of Concrete Class: In-code (Constructor is called by a Factory)
    5. Initialization of New Object: Default, fixed field assignment in constructor
    6. Building of Object Structure: Default, New object creates dependent object structure(like ids),
    (Maybe also a bit By-building regarding the food object, which has to be created beforehand)
*/
/**
 *  Collaboration Photo/FoodPhoto:
 *  - Description/Purpose:
 *    Uses common functionality of Parent class Photo, provides more specific functionality
 *    in providing additional information about a Photo
 *  - Role: Child of Photo
 *  - Binds: FoodPhoto with Photo
 */
@PatternInstance(
        patternNames = {"Abstract Factory"},
        participants = {"ConcreteProduct"}
)
public class FoodPhoto extends Photo {

    private static FoodManager manager = FoodManager.getInstance();

    /**
     *  Collaboration Food/FoodPhoto:
     *  - Description/Purpose:
     *    Provides main domain functionality for FoodPhotos, which uses
     *    food object for detail information
     *  - Role: Client of Food
     *  - Binds: FoodPhoto with Food
     */
    private Food food;

    public FoodPhoto() {
        super();
    }

    public FoodPhoto(PhotoId myId) {
        super(myId);
    }

    public FoodPhoto(Food food) {
        super();
        if (food == null) {
            throw new IllegalArgumentException("Food can not be empty");
        }
        this.food = food;
    }

    public FoodPhoto(ResultSet rset) throws SQLException {
        if (rset == null) {
            throw new IllegalArgumentException("ResultSet can not be empty");
        }
        readFrom(rset);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food can not be empty");
        }
        this.food = food;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        String typeName = rset.getString("typeName");
        String foodName = rset.getString("foodName");
        double price = rset.getDouble("price");
        boolean vegetarian = rset.getBoolean("vegetarian");
        String vendor = rset.getString("vendor");
        FoodType foodType = this.manager.createOrGetFoodType(typeName, vegetarian);
        this.manager.createFood(foodType, foodName, price, vendor);
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString("foodName", food.getFoodName());
        rset.updateDouble("price", food.getPrice());
        rset.updateBoolean("vegetarian", food.getFoodType().isVegetarian());
        rset.updateString("vendor", food.getVendor());
        rset.updateString("typeName", food.getFoodType().getTypeName());
    }

}
