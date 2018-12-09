package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

import tz.co.comptech.m_safariproduction.Model.Customer;

public class SignUp201 {
    @SerializedName("otp_id")
    private String _id;
    @SerializedName("customer")
    private Customer customer;
    @SerializedName("token")
    private String token;
    @SerializedName("msg")
    private String sms;

    public String get_id() {
        return _id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getToken() {
        return token;
    }

    public String getSms() {
        return sms;
    }
}
