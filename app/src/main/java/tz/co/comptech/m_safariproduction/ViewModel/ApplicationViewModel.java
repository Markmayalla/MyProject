package tz.co.comptech.m_safariproduction.ViewModel;

import android.app.Application;
import android.content.Context;

import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Repository.ApiRepository;

public class ApplicationViewModel extends AndroidViewModel {
    private MutableLiveData<String> repos;
    private ApiRepository apiRepository;
    private Context context;

    public ApplicationViewModel(@NonNull Application application){
        super(application);
        this.context = context;
        apiRepository = new ApiRepository(application);
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
}
