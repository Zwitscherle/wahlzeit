package org.wahlzeit.model;


import org.wahlzeit.services.Persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A Location saves the position of a photo
 */
public class Location implements Persistent {

    /**
     *
     */
    public Coordinate coordinate;

    protected transient int writeCount = 0;

    private int id = 0;

    /**
     *
     * @methodtype constructor
     */
    public Location() {
        // TODO replace with coordinate nextId
//        id = PhotoId.getNextId();
        incWriteCount();
    }

    public Location(int id){
        id = id;
    }

    /**
     *
     */
    public Location(int id, Coordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
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

    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {

    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {

    }
}
