package tz.co.comptech.m_safariproduction.Room.Dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.Model.Routes;

@Dao
public interface RegionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Region region);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPoint(RegionPoints regionPoints);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRoute(Routes routes);

    @Query("SELECT DISTINCT(name) as name, * FROM regionTable ORDER BY name ASC")
    LiveData<List<Region>> getRegion();

    @Query("SELECT DISTINCT(name) as name, * FROM routes ORDER BY name ASC")
    LiveData<List<Routes>> getRoutes();

    @Query("SELECT * FROM regions_point ORDER BY point ASC")
    LiveData<List<RegionPoints>> getRegionPoints();

    @Query("SELECT * FROM regions_point WHERE region_ids=:region ORDER BY point ASC")
    LiveData<List<RegionPoints>> getRegionPoints(String region);

    //@Query("SELECT * FROM regionTable INNSER JOIN regions_point ON region_id = region_ids")
    //LiveData<List<RegionPoints>> joinRegionPoint();
}
