package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class ErrorDataModel extends ErrorModel {
    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }
}
