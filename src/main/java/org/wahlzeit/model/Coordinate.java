package org.wahlzeit.model;

public interface Coordinate {

    final double MAX_ERROR = 0.00001;

    public CartesianCoordinate asCartesianCoordinate();
    public double getCartesianDistance(Coordinate coordinate);
    public SphericCoordinate asSphericCoordinate();
    public double getCentralAngle(Coordinate coordinate);
    public boolean isEqual(Coordinate coordinate);

}
