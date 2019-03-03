package tz.co.comptech.m_safariproduction.Room.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "regions_point", foreignKeys = @ForeignKey(
                                                                entity = Region.class,
                                                                parentColumns = "region_id",
                                                                childColumns = "region_ids"
                                                            ), indices = {@Index("region_ids")})
public class RegionPoints {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "point")
    private String local_point;

    @ColumnInfo(name = "region_ids")
    private String region_id;

    public RegionPoints(int id, String local_point, String region_id) {
        this.id = id;
        this.local_point = local_point;
        this.region_id = region_id;
    }

    public int getId() {
        return id;
    }

    public String getLocal_point() {
        return local_point;
    }

    public String getRegion_id() {
        return region_id;
    }
}
