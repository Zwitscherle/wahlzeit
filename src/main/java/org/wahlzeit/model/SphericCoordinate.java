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
        this.assertClassInvariants();
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        assertValidDouble(phi);
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        assertValidDouble(theta);
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        assertValidDouble(radius);
        assertValidRadius(radius);
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        cartesianCoordinate.assertClassInvariants();
        return cartesianCoordinate;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.phi, this.theta, this.radius);
    }

    @Override
    protected void assertClassInvariants() {
        assertValidDouble(this.phi);
        assertValidDouble(this.theta);
        assertValidDouble(this.radius);
        assertValidRadius(this.radius);
    }

    private void assertValidRadius(double radius) {
        assert radius >= 0;
    }
}
