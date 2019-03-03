package tz.co.comptech.m_safariproduction.Room.Model;

import com.google.gson.internal.$Gson$Types;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "regionTable", indices = {@Index("region_id")})
public class Region {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "region_id")
    private String region_id;

    @ColumnInfo(name = "_id")
    private String _id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "__v")
    private String __v;

    public Region(@NonNull String region_id, String _id, String name, String __v) {
        this.region_id = region_id;
        this._id = _id;
        this.name = name;
        this.__v = __v;
    }

    @NonNull
    public String getRegion_id() {
        return region_id;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String get__v() {
        return __v;
    }
}
