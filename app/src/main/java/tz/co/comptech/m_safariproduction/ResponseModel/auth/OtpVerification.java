package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class OtpVerification {
    @SerializedName("customer_id")
    private String customer_id;

    @SerializedName("verification")
    private Boolean verification;

    public String getCustomer_id() {
        return customer_id;
    }

    public Boolean getVerification() {
        return verification;
    }
}
