package org.wahlzeit.model;

import java.util.Objects;

/**
 * Coordinate represents the coordinates of a location object
 */
public class CartesianCoordinate implements Coordinate{

    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @methodtype set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @methodtype set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     *
     * @methodtype set
     */
    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        double theta = Math.acos(this.z / radius);
        double phi = Math.atan2(this.y, this.x);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        return sphericCoordinate;
    }

    /**
     *
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return Math.abs(cartesianCoordinate.getX() - this.x) <= this.MAX_ERROR &&
                Math.abs(cartesianCoordinate.getY() - this.y) <= this.MAX_ERROR &&
                Math.abs(cartesianCoordinate.getZ() - this.z) <= this.MAX_ERROR;
    }

    /**
     * calculates the cartesian distance to another coordinate object
     * @methodtype calculation
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        double distance = Math.sqrt(Math.pow((cartesianCoordinate.getX() - this.x), 2) +
                Math.pow((cartesianCoordinate.getY() - this.y),2) +
                Math.pow((cartesianCoordinate.getZ() - this.z), 2));
        return distance;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return coordinate.asCartesianCoordinate().getCentralAngle(coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianCoordinate otherCoordinate = (CartesianCoordinate) o;
        return isEqual(otherCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y, this.z);
    }

}
