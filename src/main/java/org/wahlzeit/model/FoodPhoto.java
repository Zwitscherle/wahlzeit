package org.wahlzeit.model;

public class FoodPhoto extends Photo {

    private Food food;

    // TODO dont know why this should be needed?!
    FoodPhotoManager manager;

    public FoodPhoto() {
        super();
    }

    public FoodPhoto(PhotoId myId) {
        super(myId);
    }

    public FoodPhoto(Food food) {
        super();
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
