package tz.co.comptech.m_safariproduction.Api.BusWebServices;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import tz.co.comptech.m_safariproduction.Api.Bus;
import tz.co.comptech.m_safariproduction.Api.SearchApi;
import tz.co.comptech.m_safariproduction.Model.BusSchedule;
import tz.co.comptech.m_safariproduction.Model.ResponseModel;

public interface ScheduleWebService {


    @Multipart
    @PUT(Bus.requestTrip)
    Call<BusSchedule> getTrip(Map<String, RequestBody> trip);

    @Multipart
    @PUT(Bus.cancelTrip)
    Call<RequestBody> cancelTrip(@PartMap Map<String, RequestBody> trip);

    @Multipart
    @PUT(Bus.updateTrip)
    Call<ResponseModel> updateTrip(@PartMap Map<String, RequestBody> trip);

    @Multipart
    @PUT(Bus.historyTrip)
    Call<ResponseModel> historyTrip(@PartMap Map<String, RequestBody> trip);


}
