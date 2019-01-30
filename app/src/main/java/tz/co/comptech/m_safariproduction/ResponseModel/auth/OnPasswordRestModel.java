package tz.co.comptech.m_safariproduction.ResponseModel.auth;

import com.google.gson.annotations.SerializedName;

public class OnPasswordRestModel extends ErrorModel {
    @SerializedName("data")
    private KeySignUpData keySignUpData;

    public KeySignUpData getDataModel() {
        return keySignUpData;
    }
}
