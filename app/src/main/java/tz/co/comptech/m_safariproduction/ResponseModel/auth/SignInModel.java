package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class SignInModel extends ErrorModel{
    @SerializedName("data")
    private DataModel data;

    @SerializedName("token")
    private String _token;

    public DataModel getData() {
        return data;
    }

    public String get_token() {
        return _token;
    }
}
