package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate implements Coordinate {

    private double phi; // longitude
    private double theta; // latitude
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        return cartesianCoordinate;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate targetCoordinate = coordinate.asSphericCoordinate();
        double centralAngle = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(this.phi)) *
                Math.sin(Math.toRadians(targetCoordinate.getPhi())) *
                Math.cos(Math.toRadians(this.phi)) * Math.cos(Math.toRadians(targetCoordinate.getPhi())) *
                Math.cos(Math.toRadians(targetCoordinate.getTheta() - this.theta))));
        return centralAngle;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        return this.asCartesianCoordinate().isEqual(coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphericCoordinate otherCoordinate = (SphericCoordinate) o;
        return isEqual(otherCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.phi, this.theta, this.radius);
    }

}
