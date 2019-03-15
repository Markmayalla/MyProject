package tz.co.comptech.m_safariproduction.Repository;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Api.BusWebServices.RoutesWebService;
import tz.co.comptech.m_safariproduction.Model.Bus;
import tz.co.comptech.m_safariproduction.Model.BusCenter;
import tz.co.comptech.m_safariproduction.Model.Response;
import tz.co.comptech.m_safariproduction.Room.Dao.CenterDao;

public class RouteRepository {
    CenterDao centerDao;
    RoutesWebService webService;
    MutableLiveData<List<Bus>> buses;
    MutableLiveData<List<BusCenter>> centers;
    String errorTag = "ApiError";
    List<BusCenter> busCenters;
    public RouteRepository() {
        webService = AppConnection.getClient().create(RoutesWebService.class);
        if (buses == null) {
            buses = new MutableLiveData<>();
        }
    }

    public LiveData<List<Bus>> searchRoutes(String from, String to, String date) {

        webService.searchRoute(from, to, date).enqueue(new Callback<Response<List<Bus>>>() {
            @Override
            public void onResponse(Call<Response<List<Bus>>> call, retrofit2.Response<Response<List<Bus>>> response) {
                if (response.isSuccessful()) {
                    buses.postValue(response.body().getData());
                } else {
                    Log.e(errorTag, "Code: " + response.code() + ", Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Response<List<Bus>>> call, Throwable t) {

            }
        });

        return buses;
    }


    public void populateCenters() {


        webService.getCenters().enqueue(new Callback<Response<List<BusCenter>>>() {
            @Override
            public void onResponse(Call<Response<List<BusCenter>>> call, retrofit2.Response<Response<List<BusCenter>>> response) {
                if (response.isSuccessful()) {
                    busCenters = response.body().getData();
                } else {
                    Log.e(errorTag, "Not Successful");
                }
            }

            @Override
            public void onFailure(Call<Response<List<BusCenter>>> call, Throwable t) {

            }
        });

        if (busCenters != null && busCenters.size() > 0) {
            centerDao.insert(busCenters);
            Log.e(errorTag, "Bus Centers Obtained: " + busCenters);
        } else {
            Log.e(errorTag, "Null Bus Centers");

        }
    }

}
