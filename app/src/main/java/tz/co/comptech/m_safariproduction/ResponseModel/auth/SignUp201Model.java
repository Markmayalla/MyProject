package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class SignUp201Model extends ErrorModel {
    @SerializedName("data")
    private SignUpDataModel dataModel;

    public SignUpDataModel getDataModel() {
        return dataModel;
    }
}
