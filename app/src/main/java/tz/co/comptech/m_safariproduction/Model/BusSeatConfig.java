package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BusSeatConfig {
    @SerializedName("flow_name")
    private String flow_name;

    @SerializedName("total_seats_per_flow")
    private Integer total_seats_per_flow;

    @SerializedName("no_rows")
    private Integer no_rows;

    @SerializedName("no_cols")
    private Integer no_cols;

    @SerializedName("cols_naming_type")
    private String cols_naming_type;

    @SerializedName("rows_naming_type")
    private String rows_naming_type;

    @SerializedName("blank_seats_simple_array")
    private List<String> blank_seats_simple_array;

    @SerializedName("blank_seats_obj_array")
    private List<Blank_seats_obj_array> blank_seats_obj_array;

    @SerializedName("supported_levels")
    private List<Integer> supported_levels;

    @SerializedName("has_multi_levels")
    private Boolean has_multi_levels;

    @SerializedName("seats")
    private List<Seat> seats;

    @SerializedName("_id")
    private String _id;

    public String getFlow_name() {
        return flow_name;
    }

    public Integer getTotal_seats_per_flow() {
        return total_seats_per_flow;
    }

    public Integer getNo_rows() {
        return no_rows;
    }

    public Integer getNo_cols() {
        return no_cols;
    }

    public String getCols_naming_type() {
        return cols_naming_type;
    }

    public String getRows_naming_type() {
        return rows_naming_type;
    }

    public List<String> getBlank_seats_simple_array() {
        return blank_seats_simple_array;
    }

    public List<Blank_seats_obj_array> getBlank_seats_obj_array() {
        return blank_seats_obj_array;
    }

    public List<Integer> getSupported_levels() {
        return supported_levels;
    }

    public Boolean getHas_multi_levels() {
        return has_multi_levels;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String get_id() {
        return _id;
    }
}