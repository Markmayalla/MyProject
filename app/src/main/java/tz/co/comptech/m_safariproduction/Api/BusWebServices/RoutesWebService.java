package tz.co.comptech.m_safariproduction.Api.BusWebServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tz.co.comptech.m_safariproduction.Api.SearchApi;
import tz.co.comptech.m_safariproduction.Model.Bus;
import tz.co.comptech.m_safariproduction.Model.BusCenter;
import tz.co.comptech.m_safariproduction.Model.Response;

public interface RoutesWebService {

    @GET(SearchApi.GET_SCHEDULLED + "/{date}/{from}/{to}")
    Call<Response<List<Bus>>> searchRoute(@Path("from") String from, @Path("to") String to, @Path("date") String date);

    @GET(SearchApi.BUS_CENTERS)
    Call<Response<List<BusCenter>>> getCenters();
}
