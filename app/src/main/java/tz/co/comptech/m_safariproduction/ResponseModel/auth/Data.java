package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

import tz.co.comptech.m_safariproduction.Model.Customer;

public class Data {
    @SerializedName("user")
    private Customer customer;
    @SerializedName("token")
    private String token;

    public Customer getCustomer() {
        return customer;
    }

    public String getToken() {
        return token;
    }
}
