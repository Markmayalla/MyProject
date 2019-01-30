package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class ResetPasswordModel {
    @SerializedName("customer_id")
    private String customer_id;

    @SerializedName("verification")
    private Boolean verification;

    @SerializedName("msg")
    private  String sms;

    public String getSms() {
        return sms;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public Boolean getVerification() {
        return verification;
    }
}
