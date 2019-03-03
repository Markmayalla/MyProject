package tz.co.comptech.m_safariproduction.ResponseModel.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorModel;

public class CenterData extends ErrorModel {
    @SerializedName("data")
    private List<CenterDataModel> dataModels;

    public List<CenterDataModel> getDataModels() {
        return dataModels;
    }
}
