package tz.co.comptech.m_safariproduction.Model;

import com.google.gson.annotations.SerializedName;

public class Blank_seats_obj_array {
    @SerializedName("row")
    private int row;

    @SerializedName("col")
    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
