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
 @SerializedName("seat_config")
 private List<BusSeatConfig> Seat_configObject;
 @SerializedName("bus_name")
 private String bus_name;
 @SerializedName("seat_type")
 private String seat_type;
 @SerializedName("model")
 private String model;
 @SerializedName("phone")
 private String phone;
 @SerializedName("schedulling_type")
 private String schedulling_type;
 @SerializedName("services")
 private List<String> services;
 @SerializedName("visible")
 private int visible;
 @SerializedName("status")
 private String status;
 @SerializedName("profile")
 private String profile;
 @SerializedName("max_extra_images")
 private String max_extra_images;
 @SerializedName("images")
 private List<String> images;
 @SerializedName("seat_config_set")
 private boolean seat_config_set;
 @SerializedName("_id")
 private String _id;
 @SerializedName("no_of_flows")
 private int no_of_flows;
 @SerializedName("__v")
 private float __v;
 @SerializedName("company_id")
 private String company_id;
 @SerializedName("created_date")
 private String created_date;
 @SerializedName("updated_date")
 private String updated_date;

 public List<BusSeatConfig> getSeat_configObject() {
  return Seat_configObject;
 }

 public String getBus_name() {
  return bus_name;
 }

 public String getSeat_type() {
  return seat_type;
 }

 public String getModel() {
  return model;
 }

 public String getPhone() {
  return phone;
 }

 public String getSchedulling_type() {
  return schedulling_type;
 }

 public List<String> getServices() {
  return services;
 }

 public int getVisible() {
  return visible;
 }

 public String getStatus() {
  return status;
 }

 public String getProfile() {
  return profile;
 }

 public String getMax_extra_images() {
  return max_extra_images;
 }

 public List<String> getImages() {
  return images;
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

 public float get__v() {
  return __v;
 }

 public String getCompany_id() {
  return company_id;
 }

 public String getCreated_date() {
  return created_date;
 }

 public String getUpdated_date() {
  return updated_date;
 }
}