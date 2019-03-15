package tz.co.comptech.m_safariproduction.Model;/*
 *
 * m-safari App
 * By GrandMaster
 * 2018 Nov
 *
 */


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BusCenter {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String region;
    private String name;
    ArrayList<String> local_points;

    public ArrayList<String> getLocal_points() {
        return local_points;
    }

    public void setLocal_points(ArrayList<String> local_points) {
        this.local_points = local_points;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public int getId() {
        return id;
    }

    // Getter Methods

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setRegion(String region) {
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }
}