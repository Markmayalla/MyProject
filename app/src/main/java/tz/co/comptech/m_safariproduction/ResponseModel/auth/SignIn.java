package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class SignIn extends SignInError{
    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }
}
