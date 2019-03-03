package tz.co.comptech.m_safariproduction.ResponseModel.search;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorModel;

public class CenterDataModel {
    @SerializedName("name")
    private String regionName;

    @SerializedName("local_points")
    private ArrayList points;

    @SerializedName("_id")
    private String id;

    @SerializedName("region_id")
    private String region_id;

    @SerializedName("__v")
    private String __v;

    public String getRegionName() {
        return regionName;
    }

    public ArrayList getPoints() {
        return points;
    }

    public String getId() {
        return id;
    }

    public String getRegion_id() {
        return region_id;
    }

    public String get__v() {
        return __v;
    }
}
