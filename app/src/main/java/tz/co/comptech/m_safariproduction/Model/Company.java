package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import java.util.ArrayList;

public class Company {
 private String company_name;
 private String phone;
 private String email;
 private String website_url;
 private String profile;
 private boolean blocked;
 ArrayList<CompanyAddress> addresses = new ArrayList <CompanyAddress> ();
 private String _id;
 private float __v;

 // Getter Methods 

 public String getCompany_name() {
  return company_name;
 }

 public String getPhone() {
  return phone;
 }

 public String getEmail() {
  return email;
 }

 public String getWebsite_url() {
  return website_url;
 }

 public String getProfile() {
  return profile;
 }

 public boolean getBlocked() {
  return blocked;
 }

 public String get_id() {
  return _id;
 }

 public float get__v() {
  return __v;
 }

 // Setter Methods 

 public void setCompany_name(String company_name) {
  this.company_name = company_name;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public void setWebsite_url(String website_url) {
  this.website_url = website_url;
 }

 public void setProfile(String profile) {
  this.profile = profile;
 }

 public void setBlocked(boolean blocked) {
  this.blocked = blocked;
 }

 public void set_id(String _id) {
  this._id = _id;
 }

 public void set__v(float __v) {
  this.__v = __v;
 }
}