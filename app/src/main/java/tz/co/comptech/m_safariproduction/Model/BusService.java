package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import com.google.gson.annotations.SerializedName;

public class BusService {
 @SerializedName("service_name")
 private String service_name;
 @SerializedName("code")
 private String code;
 @SerializedName("img")
 private String img;

 public String getService_name() {
  return service_name;
 }

 public String getCode() {
  return code;
 }

 public String getImg() {
  return img;
 }
}