package tz.co.comptech.m_safariproduction.Model;

import com.google.gson.annotations.SerializedName;

public class SeatDrawingObject {
    @SerializedName("row")
    private int row;

    @SerializedName("col")
    private int col;

    @SerializedName("level")
    private int level;

    @SerializedName("index")
    private int index;

    @SerializedName("_id")
    private String _id;

    @SerializedName("is_seat_empty")
    private Boolean is_seat_empty;

    @SerializedName("bus_name")
    private String bus_name;

    @SerializedName("company_id")
    private String company_id;

    @SerializedName("bus_id")
    private String bus_id;

    public int getRow() {
        return row;
    }

    public SeatDrawingObject(int row, int col, int level, int index, String _id, Boolean is_seat_empty) {
        this.row = row;
        this.col = col;
        this.level = level;
        this.index = index;
        this._id = _id;
        this.is_seat_empty = is_seat_empty;
    }

    public SeatDrawingObject(int row, int col, int level, int index, String _id, Boolean is_seat_empty, String bus_name, String company_id, String bus_id) {
        this.row = row;
        this.col = col;
        this.level = level;
        this.index = index;
        this._id = _id;
        this.is_seat_empty = is_seat_empty;
        this.bus_name = bus_name;
        this.company_id = company_id;
        this.bus_id = bus_id;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getBus_id() {
        return bus_id;
    }

    public int getCol() {
        return col;
    }

    public int getLevel() {
        return level;
    }

    public int getIndex() {
        return index;
    }

    public String get_id() {
        return _id;
    }

    public Boolean getIs_seat_empty() {
        return is_seat_empty;
    }
}
