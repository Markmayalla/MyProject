package tz.co.comptech.m_safariproduction.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tz.co.comptech.m_safariproduction.Room.Model.Region;

public interface ScheduleWebService {



    @GET()
    Call<List<Region>> getRegions();
}
