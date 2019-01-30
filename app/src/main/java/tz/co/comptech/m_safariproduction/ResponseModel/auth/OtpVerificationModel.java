package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class OtpVerificationModel {
    @SerializedName("customer_id")
    private String customer_id;

    @SerializedName("verification")
    private Boolean verification;

    @SerializedName("key")
    private String key;


    public String getCustomer_id() {
        return customer_id;
    }

    public Boolean getVerification() {
        return verification;
    }

    public String getKey() { return key; }
}
