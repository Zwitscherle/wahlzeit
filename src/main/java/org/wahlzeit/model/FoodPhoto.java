package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
Ich beschreibe hier den eigentlichen Objekterstellungsablauf, insofern alle Teile vollständig ausprogrammiert wären.
Food Objekt Erstellung von FoodManager aus:
        1. FoodPhotoManager wird aufgerufen, hier createPhoto der Parent Klasse (PhotoManager)
        2. Von dort wird über PhotoUtils die FoodPhotoFactory aufgerufen
        3. Hier wird der Constructor von FoodPhoto aufgerufen
        (zuvor müsste gegebenenfalls noch über den FoodManager das dazugehörige Food und FoodType Objekt erstellt werden.
        Dies ist hier aber in Wahlzeit, da auch in der UI nicht verfügbar aktuell nicht umgesetzt.)
        4. FoodPhoto wird im PhotoCache hinterlegt
*/
@PatternInstance(
        patternNames = {"Abstract Factory"},
        participants = {"ConcreteProduct"}
)
public class FoodPhoto extends Photo {

    private static FoodManager manager = FoodManager.getInstance();

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
