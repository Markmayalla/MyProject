package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class OtpResetModel {
    @SerializedName("customer_id")
    private String customer_id;
    @SerializedName("otp_mobile")
    private String otp_mobile;

    public String getCustomer_id() {
        return customer_id;
    }

    public String getOtp_mobile() {
        return otp_mobile;
    }
}
