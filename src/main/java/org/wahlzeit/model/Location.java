package org.wahlzeit.model;


/**
 * A Location saves the position of a photo
 */
public class Location {

    public CartesianCoordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(CartesianCoordinate coordinate) {
        this.coordinate = coordinate;
    }

}
