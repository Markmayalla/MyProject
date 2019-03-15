package tz.co.comptech.m_safariproduction.Model;

import com.google.gson.annotations.SerializedName;

public class Seat {
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

    public int getRow() {
        return row;
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
}
