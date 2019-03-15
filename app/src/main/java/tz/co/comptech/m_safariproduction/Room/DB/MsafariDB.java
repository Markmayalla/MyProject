package tz.co.comptech.m_safariproduction.Room.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import okhttp3.Route;
import tz.co.comptech.m_safariproduction.Convetors;
import tz.co.comptech.m_safariproduction.Model.BusCenter;
import tz.co.comptech.m_safariproduction.Room.Dao.CenterDao;
import tz.co.comptech.m_safariproduction.Room.Dao.RegionDao;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.Model.Routes;


@Database(entities = {Region.class, RegionPoints.class, Routes.class, BusCenter.class}, version = 3, exportSchema = false)
@TypeConverters({Convetors.class})
public abstract class MsafariDB extends RoomDatabase {

   public abstract RegionDao regionDao();

   public abstract CenterDao centerDao();

   private static volatile MsafariDB INSTANCE;

   public static MsafariDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MsafariDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MsafariDB.class, "msafariDatabase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}