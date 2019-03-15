package tz.co.comptech.m_safariproduction.ResponseModel.search.fromto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorModel;

public class ScheduleBusModel extends ErrorModel {
    @SerializedName("data")
    private ArrayList<ScheduledBus> scheduledBuses;

    public ArrayList<ScheduledBus> getScheduledBuses() {
        return scheduledBuses;
    }
}
