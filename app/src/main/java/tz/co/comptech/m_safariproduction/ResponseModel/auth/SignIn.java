package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class SignIn {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("data")
    private Data data;
    @SerializedName("msg")
    private String sms;

    public Boolean getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public String getSms() {
        return sms;
    }
}
