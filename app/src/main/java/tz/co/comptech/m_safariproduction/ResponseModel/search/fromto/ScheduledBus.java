package tz.co.comptech.m_safariproduction.ResponseModel.search.fromto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import tz.co.comptech.m_safariproduction.Model.Bus;
import tz.co.comptech.m_safariproduction.Model.Company;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorModel;

public class ScheduledBus{
    @SerializedName("estimated_time")
    private String estimated_time;

    @SerializedName("departure_time")
    private String departure_time;

    @SerializedName("arrival_time")
    private String arrival_time;

    @SerializedName("multi_fare_support")
    private String multi_fare_support;

    @SerializedName("has_multi_seat_level")
    private String has_multi_seat_level;

    @SerializedName("base_fare")
    private String base_fare;

    @SerializedName("cancellation_policy")
    private String cancellation_policy;

    @SerializedName("help_line_no")
    private String help_line_no;

    @SerializedName("min_booking_hrs")
    private String min_booking_hrs;

    @SerializedName("trip_status")
    private String trip_status;

    @SerializedName("fare_per_flow")
    private ArrayList<String> fare_per_flow;

    @SerializedName("booked_seat")
    private ArrayList<String> booked_seat;

    @SerializedName("created_date")
    private String created_date;

    @SerializedName("updated_date")
    private String updated_date;

    @SerializedName("_id")
    private String _id;

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("sch_date")
    private String sch_date;

    @SerializedName("__v")
    private String __v;

    @SerializedName("created_by_worker_id")
    private String created_by_worker_id;

    @SerializedName("company_id")
    private Company company_id;

    @SerializedName("bus_id")
    private Bus bus;

    public String getEstimated_time() {
        return estimated_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getMulti_fare_support() {
        return multi_fare_support;
    }

    public String getHas_multi_seat_level() {
        return has_multi_seat_level;
    }

    public String getBase_fare() {
        return base_fare;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public String getHelp_line_no() {
        return help_line_no;
    }

    public String getMin_booking_hrs() {
        return min_booking_hrs;
    }

    public String getTrip_status() {
        return trip_status;
    }

    public ArrayList<String> getFare_per_flow() {
        return fare_per_flow;
    }

    public ArrayList<String> getBooked_seat() {
        return booked_seat;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public String get_id() {
        return _id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSch_date() {
        return sch_date;
    }

    public String get__v() {
        return __v;
    }

    public String getCreated_by_worker_id() {
        return created_by_worker_id;
    }

    public Company getCompany_id() {
        return company_id;
    }

    public Bus getBus() {
        return bus;
    }
}
