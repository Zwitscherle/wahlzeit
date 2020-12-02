package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

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
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        if (this.radius == 0 && sphericCoordinate.getRadius() == 0) {
            return true;
        }
        return Math.abs(sphericCoordinate.getPhi() - this.phi) <= this.MAX_ERROR &&
                Math.abs(sphericCoordinate.getTheta() - this.theta) <= this.MAX_ERROR &&
                Math.abs(sphericCoordinate.getRadius() - this.radius) <= this.MAX_ERROR;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.phi, this.theta, this.radius);
    }

}
