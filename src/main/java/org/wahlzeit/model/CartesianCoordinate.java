package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;
import java.util.Objects;

/**
 * Coordinate represents the coordinates of a location object
 */
@PatternInstance(
        patternNames = {"Value Object"},
        participants = {"ValueObject"}
)
public class CartesianCoordinate extends AbstractCoordinate{

    // map for sharing coordinates
    private static HashMap<Integer, CartesianCoordinate> cartesianCoordinatesMap = new HashMap<>();

    private final double x;
    private final double y;
    private final double z;

    /**
     *
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z) {
        assertValidDouble(x);
        assertValidDouble(y);
        assertValidDouble(z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static CartesianCoordinate createOrGetCartesianCoordinate(double x, double y, double z) {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        int currentHash = cartesianCoordinate.hashCode();
        synchronized (cartesianCoordinatesMap) {
            CartesianCoordinate coordinateInMap = cartesianCoordinatesMap.get(currentHash);
            if (coordinateInMap == null) {
                cartesianCoordinatesMap.put(currentHash, cartesianCoordinate);
                return cartesianCoordinate;
            } else {
                return coordinateInMap;
            }
        }
    }

    public double getX() {
        return x;
    }

    public double getY() { return y; }

    public double getZ() { return z; }

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
        SphericCoordinate sphericCoordinate = SphericCoordinate.createOrGetSphericCoordinate(phi, theta, radius);
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
