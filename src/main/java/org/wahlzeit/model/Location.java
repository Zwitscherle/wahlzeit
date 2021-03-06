package org.wahlzeit.model;


/**
 * A Location saves the position of a photo
 */
public class Location {

    public Coordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(Coordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("Coordinate can not be empty");
        }
        this.coordinate = coordinate;
    }

}
