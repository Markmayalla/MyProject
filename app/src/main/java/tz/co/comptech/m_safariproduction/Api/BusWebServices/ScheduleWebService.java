package tz.co.comptech.m_safariproduction.Api.BusWebServices;

import retrofit2.Call;
import retrofit2.http.GET;
import tz.co.comptech.m_safariproduction.Api.Bus;
import tz.co.comptech.m_safariproduction.Helpers.RouteQueryModel;

public interface ScheduleWebService {
    @GET(Bus.busApi + "/{from}/{to}/{date}")
    Call<ScheduleModel> getSchedule(RouteQueryModel routeQueryModel);
}
