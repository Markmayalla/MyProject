package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


public class Customer {
 private String first_name;
 private String last_name;
 private String email;
 private String password;
 private String gender;
 private String address;
 private String role;
 private boolean phone_verified;
 private boolean blocked;
 private String _id;
 private String phone_no;
 private String nida_id;
 private float __v;

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

 // Getter Methods

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

 public boolean getPhone_verified() {
  return phone_verified;
 }

 public boolean getBlocked() {
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

 public float get__v() {
  return __v;
 }

 // Setter Methods 

 public void setFirst_name(String first_name) {
  this.first_name = first_name;
 }

 public void setLast_name(String last_name) {
  this.last_name = last_name;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public void setGender(String gender) {
  this.gender = gender;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public void setRole(String role) {
  this.role = role;
 }

 public void setPhone_verified(boolean phone_verified) {
  this.phone_verified = phone_verified;
 }

 public void setBlocked(boolean blocked) {
  this.blocked = blocked;
 }

 public void set_id(String _id) {
  this._id = _id;
 }

 public void setPhone_no(String phone_no) {
  this.phone_no = phone_no;
 }

 public void setNida_id(String nida_id) {
  this.nida_id = nida_id;
 }

 public void set__v(float __v) {
  this.__v = __v;
 }
}