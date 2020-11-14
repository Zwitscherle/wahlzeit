package org.wahlzeit.model;

import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;
import org.wahlzeit.services.SysLog;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinateManager extends ObjectManager {

    /**
     *
     */
    protected static CoordinateManager instance = new CoordinateManager();


    @Override
    protected Coordinate createObject(ResultSet rset) throws SQLException {
        int id = rset.getInt("id");
        Coordinate result = new Coordinate(id);
        result.readFrom(rset);
        return result;
    }

    /**
     *
     */
    public Coordinate getCoordinateFromId(int id) throws SQLException {
        PreparedStatement stmt = null;
        stmt = getReadingStatement("SELECT * FROM coordinates WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();
        return createObject(result);
    }

    /**
     *
     */
    public void addCoordinate(Coordinate coordinate) throws Exception {
        PreparedStatement stmt = getReadingStatement("INSERT INTO coordinates (id, x_coordinate, y_coordinate, z_coordinate) " +
                "VALUES(?, ?, ?, ?)");
        stmt.setDouble(1, coordinate.writeCount);
        stmt.setDouble(2, coordinate.getxCoordinate());
        stmt.setDouble(3, coordinate.getyCoordinate());
        stmt.setDouble(4, coordinate.getzCoordinate());

    }


}
