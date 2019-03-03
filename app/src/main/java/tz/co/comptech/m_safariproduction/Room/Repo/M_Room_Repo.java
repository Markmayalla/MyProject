package tz.co.comptech.m_safariproduction.Room.Repo;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import tz.co.comptech.m_safariproduction.Room.DB.MsafariDB;
import tz.co.comptech.m_safariproduction.Room.Dao.RegionDao;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.Model.Routes;

public class M_Room_Repo {
    private RegionDao regionDao;
    private LiveData<List<Region>> regions;
    private LiveData<List<RegionPoints>> regions_points;
    private LiveData<List<Routes>> routes;

    public M_Room_Repo(Application application) {
        MsafariDB db = MsafariDB.getDatabase(application);
        regionDao = db.regionDao();
        regions = regionDao.getRegion();
        routes = regionDao.getRoutes();
        regions_points = regionDao.getRegionPoints();
    }

    public LiveData<List<Region>> getRegions() {
        return regions;
    }

    public LiveData<List<RegionPoints>> getRegions_points() {
        return regions_points;
    }

    public LiveData<List<Routes>> getRoutes() {
        return routes;
    }


    public void insert (Region region) {
        new insertAsyncTask(regionDao).execute(region);
    }

    private static class insertAsyncTask extends AsyncTask<Region, Void, Void> {

        private RegionDao mAsyncTaskDao;

        insertAsyncTask(RegionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Region... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


    public void insert_points (RegionPoints region) {
        new insertAsyncTaskPoint(regionDao).execute(region);
    }

    private static class insertAsyncTaskPoint extends AsyncTask<RegionPoints, Void, Void> {

        private RegionDao mAsyncTaskDao;

        insertAsyncTaskPoint(RegionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final RegionPoints... params) {
            mAsyncTaskDao.insertPoint(params[0]);
            return null;
        }
    }


    public void insert_routes (Routes routes) {
        new insertAsyncTaskRoute(regionDao).execute(routes);
    }

    private static class insertAsyncTaskRoute extends AsyncTask<Routes, Void, Void> {

        private RegionDao mAsyncTaskDao;

        insertAsyncTaskRoute(RegionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Routes... params) {
            mAsyncTaskDao.insertRoute(params[0]);
            return null;
        }
    }
}
