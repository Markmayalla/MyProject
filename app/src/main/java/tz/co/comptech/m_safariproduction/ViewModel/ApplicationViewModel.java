package tz.co.comptech.m_safariproduction.ViewModel;

import android.app.Application;
import android.content.Context;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Repository.ApiRepository;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.Repo.M_Room_Repo;

public class ApplicationViewModel extends AndroidViewModel {
    private MutableLiveData<String> repos;
    private ApiRepository apiRepository;
    private Context context;

    //Room variables
    private M_Room_Repo pre_datas;
    private LiveData<List<Region>> regions;
    private LiveData<List<RegionPoints>> region_points;

    public ApplicationViewModel(@NonNull Application application){
        super(application);
        this.context = context;
        apiRepository = new ApiRepository(application);


        ///Room
        pre_datas = new M_Room_Repo(application);
        regions = pre_datas.getRegions();
        region_points = pre_datas.getRegions_points();
    }

    public MutableLiveData<String> getDataFromServer(final String url) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = apiRepository.getDataFromServer(url);
        return repos;
    }

    public MutableLiveData<String> postDataToServer(final String url,final Map<String , RequestBody> signUpData) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = apiRepository.postDataToServer(url,signUpData);
        return repos;
    }

    public MutableLiveData<String> putDataFroServer(final String url,final Map<String , RequestBody> signUpData) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = apiRepository.putDataFroServer(url,signUpData);
        return repos;
    }

    public MutableLiveData<String> deleteDataFromServer(final String url) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = apiRepository.deleteDataFromServer(url);
        return repos;
    }

    ////Rooom

    public LiveData<List<Region>> getRegions(){ return regions;};
    public LiveData<List<RegionPoints>> getRegion_points(){ return region_points;};

    public void insert(Region region){ pre_datas.insert(region);}
    public void insert(RegionPoints region){ pre_datas.insert_points(region);}
}
