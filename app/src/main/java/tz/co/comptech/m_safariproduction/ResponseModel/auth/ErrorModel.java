package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class ErrorModel {
    @SerializedName("msg")
    private String sms;
    @SerializedName("status")
    private Boolean status;
    @SerializedName("code")
    private String code;

    public String getSms() {
        return sms;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
