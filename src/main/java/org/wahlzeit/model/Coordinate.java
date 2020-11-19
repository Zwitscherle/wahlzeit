package org.wahlzeit.model;

import java.util.Objects;

/**
 * Coordinate represents the coordinates of a location object
 */
public class Coordinate {

    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype constructor
     */
    public Coordinate(double x, double y, double z) {
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

    /**
     *
     * @methodtype boolean-query
     */
    public boolean isEqual(Coordinate coordinate) {
        Double x = coordinate.getX();
        Double y = coordinate.getY();
        Double z = coordinate.getZ();
        Double x2 = this.x;
        Double y2 = this.y;
        Double z2 = this.z;
        return (x.compareTo(x2) == 0 && y.compareTo(y2) == 0 && z.compareTo(z2) == 0);
    }

    /**
     * calculates the cartesian distance to another coordinate object
     * @methodtype calculation
     */
    public double getDistance(Coordinate coordinate) {
        double distance = Math.sqrt(Math.pow((coordinate.getX() - this.x), 2) +
                Math.pow((coordinate.getY() - this.y),2) +
                Math.pow((coordinate.getZ() - this.z), 2));
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate otherCoordinate = (Coordinate) o;
        return isEqual(otherCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
