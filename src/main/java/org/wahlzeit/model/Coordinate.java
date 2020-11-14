package org.wahlzeit.model;

import org.wahlzeit.services.Persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Coordinate represents the coordinates of a location object
 */
public class Coordinate implements Persistent {

    // TODO handle ids correctly
    /**
     *
     */
    protected transient int writeCount = 0;

    private int id = 0;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    /**
     *
     * @methodtype constructor
     */
    public Coordinate() {
        // TODO replace with coordinate nextId
//        id = PhotoId.getNextId();
        incWriteCount();
    }

    /**
     *
     */
    public Coordinate(int id) {
        id = id;
    }

    /**
     *
     * @methodtype constructor
     */
    public Coordinate(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.id += 1;
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

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public void incWriteCount() {
        writeCount++;
    }

    @Override
    public void resetWriteCount() {

    }

    @Override
    public String getIdAsString() {
        return null;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        xCoordinate = rset.getDouble("x_coordinate");
        yCoordinate = rset.getDouble("y_coordinate");
        zCoordinate = rset.getDouble("z_coordinate");
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateDouble("x_coordinate", xCoordinate);
        rset.updateDouble("y_coordinate", yCoordinate);
        rset.updateDouble("z_coordinate", zCoordinate);
    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {

    }
}
