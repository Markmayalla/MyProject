package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

class SignInError {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("msg")
    private String sms;
    @SerializedName("code")
    private Integer code;

    public Boolean getStatus() {
        return status;
    }

    public String getSms() {
        return sms;
    }

    public Integer getCode() {
        return code;
    }
}
