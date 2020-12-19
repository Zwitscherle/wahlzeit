package org.wahlzeit.model;

import java.util.Objects;

/**
 * Coordinate represents the coordinates of a location object
 */
public class CartesianCoordinate extends AbstractCoordinate{

    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        assertValidDouble(x);
        assertValidDouble(y);
        assertValidDouble(z);
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
        assertValidDouble(x);
        this.x = x;
    }

    /**
     *
     * @methodtype get
     */
    public double getY() { return y; }

    /**
     *
     * @methodtype set
     */
    public void setY(double y) {
        assertValidDouble(y);
        this.y = y;
    }

    /**
     *
     * @methodtype get
     */
    public double getZ() { return z; }

    /**
     *
     * @methodtype set
     */
    public void setZ(double z) {
        assertValidDouble(z);
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        this.assertClassInvariants();
        double radius = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        double theta = 0;
        if (radius != 0) {
            theta = Math.acos(this.z / radius);
        }
        double phi = Math.atan2(this.y, this.x);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        this.assertClassInvariants();
        return sphericCoordinate;
    }

    /**
     *
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        this.assertNotNull(coordinate);
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return Math.abs(cartesianCoordinate.getX() - this.x) <= this.MAX_ERROR &&
                Math.abs(cartesianCoordinate.getY() - this.y) <= this.MAX_ERROR &&
                Math.abs(cartesianCoordinate.getZ() - this.z) <= this.MAX_ERROR;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y, this.z);
    }

    @Override
    protected void assertClassInvariants(){
        assertValidDouble(this.x);
        assertValidDouble(this.y);
        assertValidDouble(this.z);
    };

}
