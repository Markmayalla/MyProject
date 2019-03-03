package tz.co.comptech.m_safariproduction.ResponseModel.search;

import com.google.gson.annotations.SerializedName;

public class RouteData {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("__v")
    private String __v;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String get__v() {
        return __v;
    }
}
