package tz.co.comptech.m_safariproduction.Room.ViewModel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.Repo.M_Room_Repo;

public class RoomViewModel extends AndroidViewModel {

    private M_Room_Repo pre_datas;
    private LiveData<List<Region>> regions;
    private LiveData<List<RegionPoints>> region_points;

    public RoomViewModel(@NonNull Application application) {
        super(application);
        pre_datas = new M_Room_Repo(application);
        regions = pre_datas.getRegions();
        region_points = pre_datas.getRegions_points();
    }

    public LiveData<List<Region>> getRegions(){ return regions;};
    public LiveData<List<RegionPoints>> getRegion_points(){ return region_points;};

    public void insert(Region region){ pre_datas.insert(region);}
    public void insert(RegionPoints region){ pre_datas.insert_points(region);}
}
