package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationManager extends ObjectManager {

    /**
     *
     */
    protected static LocationManager instance = new LocationManager();

    /**
     *
     * @methodtype factory
     */
    @Override
    protected Location createObject(ResultSet rset) throws SQLException {
        int location_id = rset.getInt("id");
        int coordinates_id = rset.getInt("coordinate_id");
        Coordinate curCoor = CoordinateManager.instance.getCoordinateFromId(coordinates_id);
        Location result = new Location();
        result.coordinate = curCoor;
        return result;
    }

    protected Location getLocationById(int location_id) throws SQLException {
        PreparedStatement loc_stmt = getReadingStatement("SELECT * FROM locations WHERE id = ?");
        loc_stmt.setInt(1, location_id);
        ResultSet result = loc_stmt.executeQuery(); //.getInt("coordinate_id");
        return createObject(result);
    }
}
