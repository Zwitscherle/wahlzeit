package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


@PatternInstance(
        patternNames = {"Value Object"},
        participants = {"ValueObject"}
)
public class SphericCoordinate extends AbstractCoordinate {

    // map for sharing coordinates
    private static ConcurrentHashMap<Integer, SphericCoordinate> sphericCoordinatesMap = new ConcurrentHashMap<>();

    final static double ANGLE_MIN = 0;
    final static double ANGLE_MAX = 360;

    private final double phi; // longitude
    private final double theta; // latitude
    private final double radius;

    private SphericCoordinate(double phi, double theta, double radius) {
        assertValidDouble(phi);
        assertValidDouble(theta);
        assertValidDouble(radius);
        assertValidRadius(radius);
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public static SphericCoordinate createOrGetSphericCoordinate(double phi, double theta, double radius) {
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        int currentHash = sphericCoordinate.hashCode();
        synchronized (sphericCoordinatesMap) {
            SphericCoordinate coordinateInMap = sphericCoordinatesMap.get(currentHash);
            if (coordinateInMap == null) {
                sphericCoordinatesMap.put(currentHash, sphericCoordinate);
                return sphericCoordinate;
            } else {
                return coordinateInMap;
            }
        }
    }

    public double getPhi() {
        return phi;
    }

    public double getTheta() {
        return theta;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        this.assertClassInvariants();
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.createOrGetCartesianCoordinate(x, y, z);
        this.assertClassInvariants();
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
        if (radius < 0) {
            throw new IllegalArgumentException("radius can not be negative");
        }
    }
}
