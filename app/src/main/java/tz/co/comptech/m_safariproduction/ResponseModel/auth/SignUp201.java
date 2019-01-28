package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import tz.co.comptech.m_safariproduction.Model.Customer;

public class SignUp201 extends SignUp400{
    @SerializedName("otp_id")
    private String _id;
    @SerializedName("status")
    private Boolean status;
    @SerializedName("customer_id")
    private String customer_id;
    @SerializedName("otp_mobile")
    private String otp_mobile;
    @SerializedName("service")
    private String service;
    
    public String get_id() {
        return _id;
    }

    
    public String getCustomer_id() {
        return customer_id;
    }

    
    public String getOtp_mobile() {
        return otp_mobile;
    }

    
    public String getService() {
        return service;
    }

    
    public Boolean getStatus() {
        return status;
    }
}
