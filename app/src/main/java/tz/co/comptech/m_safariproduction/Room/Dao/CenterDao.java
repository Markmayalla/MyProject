package tz.co.comptech.m_safariproduction.Room.Dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import tz.co.comptech.m_safariproduction.Model.BusCenter;

@Dao
public interface CenterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<BusCenter> centers);

    @Query("SELECT * FROM buscenter WHERE name LIKE :region")
    List<BusCenter> getCentersBy(String region);
}
