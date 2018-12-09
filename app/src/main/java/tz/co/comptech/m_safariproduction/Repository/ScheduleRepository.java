package tz.co.comptech.m_safariproduction.Repository;

import android.arch.lifecycle.MutableLiveData;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Api.BusWebServices.ScheduleWebService;
import tz.co.comptech.m_safariproduction.Model.BusRoute;
import tz.co.comptech.m_safariproduction.Model.BusSchedule;
import tz.co.comptech.m_safariproduction.Model.ResponseModel;

public class ScheduleRepository {
    ScheduleWebService webService;

    MutableLiveData<BusSchedule> busScheduleMutableLiveData;
    MutableLiveData<ResponseModel> responseModelMutableLiveData;
    public ScheduleRepository() {
        webService = AppConnection.getClient().create(ScheduleWebService.class);
        if (busScheduleMutableLiveData == null){
            busScheduleMutableLiveData = new MutableLiveData<>();
        }
        if (responseModelMutableLiveData == null){
            responseModelMutableLiveData = new MutableLiveData<>();
        }
    }

    public MutableLiveData<BusSchedule> requestTrip(final Map<String, RequestBody> trip){
        webService.getTrip(trip).enqueue(new Callback<BusSchedule>() {
            @Override
            public void onResponse(Call<BusSchedule> call, Response<BusSchedule> response) {
                busScheduleMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BusSchedule> call, Throwable t) {

            }
        });
        return busScheduleMutableLiveData;
    }
    
}
