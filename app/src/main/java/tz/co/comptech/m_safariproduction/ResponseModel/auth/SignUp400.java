package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class SignUp400 {
    @SerializedName("msg")
    private String sms;

    public String getSms() {
        return sms;
    }
}
