package tz.co.comptech.m_safariproduction.ViewModel;

import java.util.Map;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Repository.ApiRepository;

public class ApplicationViewModel extends ViewModel {
    private MutableLiveData<String> repos;
    private ApiRepository apiRepository;

    public ApplicationViewModel(){
        apiRepository = new ApiRepository();
    }

    public MutableLiveData<String> getDataFromServer(final String url,final Map<String , RequestBody> signUpData) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = apiRepository.getDataFromServer(url,signUpData);
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

    public MutableLiveData<String> deleteDataFromServer(final String url,final Map<String , RequestBody> signUpData) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = apiRepository.deleteDataFromServer(url,signUpData);
        return repos;
    }
}
