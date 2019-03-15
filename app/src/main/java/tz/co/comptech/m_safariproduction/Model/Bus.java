package tz.co.comptech.m_safariproduction.Model;
/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/

import java.util.ArrayList;

public class Bus {
 BusSeatConfig Seat_configObject;
 private String bus_name;
 private String seat_type;
 private String model;
 private String manager_incharge;
 private String phone;
 private String schedulling_type;
 ArrayList< BusService > services = new ArrayList < BusService > ();
 private float visible;
 private String status;
 private String profile;
 ArrayList < String > images = new ArrayList < String > ();
 private boolean seat_config_set;
 private String _id;
 private String company_id;
 private float __v;

 public BusSeatConfig getSeat_configObject() {
  return Seat_configObject;
 }

 public void setSeat_configObject(BusSeatConfig seat_configObject) {
  Seat_configObject = seat_configObject;
 }

 public String getBus_name() {
  return bus_name;
 }

 public void setBus_name(String bus_name) {
  this.bus_name = bus_name;
 }

 public String getSeat_type() {
  return seat_type;
 }

 public void setSeat_type(String seat_type) {
  this.seat_type = seat_type;
 }

 public String getModel() {
  return model;
 }

 public void setModel(String model) {
  this.model = model;
 }

 public String getManager_incharge() {
  return manager_incharge;
 }

 public void setManager_incharge(String manager_incharge) {
  this.manager_incharge = manager_incharge;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getSchedulling_type() {
  return schedulling_type;
 }

 public void setSchedulling_type(String schedulling_type) {
  this.schedulling_type = schedulling_type;
 }

 public ArrayList<BusService> getServices() {
  return services;
 }

 public void setServices(ArrayList<BusService> services) {
  this.services = services;
 }

 public float getVisible() {
  return visible;
 }

 public void setVisible(float visible) {
  this.visible = visible;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public String getProfile() {
  return profile;
 }

 public void setProfile(String profile) {
  this.profile = profile;
 }

 public ArrayList<String> getImages() {
  return images;
 }

 public void setImages(ArrayList<String> images) {
  this.images = images;
 }

 public boolean isSeat_config_set() {
  return seat_config_set;
 }

 public void setSeat_config_set(boolean seat_config_set) {
  this.seat_config_set = seat_config_set;
 }

 public String get_id() {
  return _id;
 }

 public void set_id(String _id) {
  this._id = _id;
 }

 public String getCompany_id() {
  return company_id;
 }

 public void setCompany_id(String company_id) {
  this.company_id = company_id;
 }

 public float get__v() {
  return __v;
 }

 public void set__v(float __v) {
  this.__v = __v;
 }
}