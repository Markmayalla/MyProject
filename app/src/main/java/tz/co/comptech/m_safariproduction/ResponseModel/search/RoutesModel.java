package tz.co.comptech.m_safariproduction.ResponseModel.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorModel;

public class RoutesModel extends ErrorModel {
    @SerializedName("data")
    private List<RouteData> routeData;

    public List<RouteData> getRouteData() {
        return routeData;
    }
}
