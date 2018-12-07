package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import com.google.gson.annotations.SerializedName;

public class Customer {
 @SerializedName("first_name")
 private String first_name;
 @SerializedName("last_name")
 private String last_name;
 @SerializedName("email")
 private String email;
 @SerializedName("password")
 private String password;
 @SerializedName("gender")
 private String gender;
 @SerializedName("address")
 private String address;
 @SerializedName("role")
 private String role;
 @SerializedName("phone_verified")
 private Boolean phone_verified;
 @SerializedName("blocked")
 private Boolean blocked;
 @SerializedName("_id")
 private String _id;
 @SerializedName("phone_no")
 private String phone_no;
 @SerializedName("nida_id")
 private String nida_id;
 @SerializedName("__v")
 private Float __v;
 @SerializedName("created_date")
 private String created_date;
 @SerializedName("updated_date")
 private String updated_date;

 public Customer(String first_name, String last_name, String email, String password, String gender, String address, String phone_no, String nida_id) {
  this.first_name = first_name;
  this.last_name = last_name;
  this.email = email;
  this.password = password;
  this.gender = gender;
  this.address = address;
  this.phone_no = phone_no;
  this.nida_id = nida_id;
 }

 public Customer(String first_name, String last_name, String email, String password, String gender, String address, String role, Boolean phone_verified, Boolean blocked, String _id, String phone_no, String nida_id, Float __v) {
  this.first_name = first_name;
  this.last_name = last_name;
  this.email = email;
  this.password = password;
  this.gender = gender;
  this.address = address;
  this.role = role;
  this.phone_verified = phone_verified;
  this.blocked = blocked;
  this._id = _id;
  this.phone_no = phone_no;
  this.nida_id = nida_id;
  this.__v = __v;
 }

 public Customer(String first_name, String last_name, String email, String password, String phone_no) {
  this.first_name = first_name;
  this.last_name = last_name;
  this.email = email;
  this.password = password;
  this.phone_no = phone_no;
 }

 // Getter Methods

 public String getCreated_date() {
  return created_date;
 }

 public String getUpdated_date() {
  return updated_date;
 }

 public String getFirst_name() {
  return first_name;
 }

 public String getLast_name() {
  return last_name;
 }

 public String getEmail() {
  return email;
 }

 public String getPassword() {
  return password;
 }

 public String getGender() {
  return gender;
 }

 public String getAddress() {
  return address;
 }

 public String getRole() {
  return role;
 }

 public Boolean getPhone_verified() {
  return phone_verified;
 }

 public Boolean getBlocked() {
  return blocked;
 }

 public String get_id() {
  return _id;
 }

 public String getPhone_no() {
  return phone_no;
 }

 public String getNida_id() {
  return nida_id;
 }

 public Float get__v() {
  return __v;
 }
}