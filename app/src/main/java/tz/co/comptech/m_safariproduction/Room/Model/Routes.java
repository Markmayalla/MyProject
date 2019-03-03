package tz.co.comptech.m_safariproduction.Room.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "routes", indices = {@Index("route_id")})
public class Routes {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "route_id")
    private String _id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "__v")
    private String __v;

    public Routes(@NonNull String _id, String name, String __v) {
        this._id = _id;
        this.name = name;
        this.__v = __v;
    }

    @NonNull
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
