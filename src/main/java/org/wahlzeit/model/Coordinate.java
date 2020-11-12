package org.wahlzeit.model;

/**
 * Coordinate represents the coordinates of a location object
 */
public class Coordinate {

    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    /**
     *
     * @methodtype constructor
     */
    public Coordinate(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    /**
     *
     * @methodtype get
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     *
     * @methodtype get
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     *
     * @methodtype get
     */
    public double getzCoordinate() {
        return zCoordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setzCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    /**
     *
     * @methodtype boolean-query
     */
    public boolean isEqual(Coordinate coordinate) {
        Double x = coordinate.getxCoordinate();
        Double y = coordinate.getyCoordinate();
        Double z = coordinate.getzCoordinate();
        Double x2 = this.xCoordinate;
        Double y2 = this.yCoordinate;
        Double z2 = this.zCoordinate;
        return (x.equals(x2) && y.equals(y2) && z.equals(z2));
    }

    /**
     * calculates the cartesian distance to another coordinate object
     * @methodtype calculation
     */
    public double getDistance(Coordinate coordinate) {
        double distance = Math.sqrt(Math.pow((coordinate.getxCoordinate() - this.xCoordinate), 2) +
                Math.pow((coordinate.getyCoordinate() - this.yCoordinate),2) +
                Math.pow((coordinate.getzCoordinate() - this.zCoordinate), 2));
        return distance;
    }

}
