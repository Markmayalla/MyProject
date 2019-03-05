package tz.co.comptech.m_safariproduction.Model;
/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Bus {
// @SerializedName("Seat_configObject")
// BusSeatConfig Seat_configObject;
 @SerializedName("bus_name")
 private String bus_name;
 @SerializedName("seat_type")
 private String seat_type;
 @SerializedName("model")
 private String model;
// @SerializedName("manager_incharge")
// private String manager_incharge;
// @SerializedName("phone")
// private String phone;
// @SerializedName("schedulling_type")
// private String schedulling_type;
 @SerializedName("services")
List<BusService> services;
// @SerializedName("visible")
// private float visible;
// @SerializedName("status")
// private String status;
 @SerializedName("profile")
 private String profile;
// @SerializedName("images")
// ArrayList <String> images;
 @SerializedName("seat_config_set")
 private boolean seat_config_set;
 @SerializedName("_id")
 private String _id;
 @SerializedName("no_of_flows")
 private int no_of_flows;
// @SerializedName("__v")
// private float __v;


 public String getBus_name() {
  return bus_name;
 }

 public String getSeat_type() {
  return seat_type;
 }

 public String getModel() {
  return model;
 }

 public List<BusService> getServices() {
  return services;
 }

 public String getProfile() {
  return profile;
 }

 public boolean isSeat_config_set() {
  return seat_config_set;
 }

 public String get_id() {
  return _id;
 }

 public int getNo_of_flows() {
  return no_of_flows;
 }
}