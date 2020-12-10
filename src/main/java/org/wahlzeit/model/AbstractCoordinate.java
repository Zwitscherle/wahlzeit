package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

    final double MAX_ERROR = 0.00001;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate otherCoordinate = (Coordinate) o;
        return isEqual(otherCoordinate);
    }

    /**
     *
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        this.assertNotNull(coordinate);
        CartesianCoordinate curCoordinate = this.asCartesianCoordinate();
        return curCoordinate.isEqual(coordinate);
    }

    /**
     * calculates the cartesian distance to another coordinate object
     * @methodtype calculation
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        this.assertNotNull(coordinate);
        CartesianCoordinate firstCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate otherCoordinate = coordinate.asCartesianCoordinate();
        double distance = Math.sqrt(Math.pow((otherCoordinate.getX() - firstCoordinate.getX()), 2) +
                Math.pow((otherCoordinate.getY() - firstCoordinate.getY()),2) +
                Math.pow((otherCoordinate.getZ() - firstCoordinate.getZ()), 2));
        return distance;
    }

    /**
     * calculates the central angle between two coordinate objects
     * @methodtype calculation
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        this.assertNotNull(coordinate);
        SphericCoordinate firstCoordinate = this.asSphericCoordinate();
        SphericCoordinate secondCoordinate = coordinate.asSphericCoordinate();
        double centralAngle = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(firstCoordinate.getPhi())) *
                Math.sin(Math.toRadians(secondCoordinate.getPhi())) *
                Math.cos(Math.toRadians(firstCoordinate.getPhi())) * Math.cos(Math.toRadians(secondCoordinate.getPhi())) *
                Math.cos(Math.toRadians(secondCoordinate.getTheta() - firstCoordinate.getTheta()))));
        return centralAngle;
    }

    protected void assertNotNull(Coordinate coordinate) {
        assert coordinate != null;
    }

    protected abstract void assertClassInvariants();

    protected void assertValidDouble(double value) {
        assert Double.isFinite(value);
    }
}
