package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


public class OTP {
 private String otp_mobile;
 private String otp_secrete;
 private String group_type;
 private String service;
 private float created_time;
 private String _id;
 private float __v;







 // Getter Methods 

 public String getOtp_mobile() {
  return otp_mobile;
 }

 public String getOtp_secrete() {
  return otp_secrete;
 }

 public String getGroup_type() {
  return group_type;
 }

 public String getService() {
  return service;
 }

 public float getCreated_time() {
  return created_time;
 }

 public String get_id() {
  return _id;
 }

 public float get__v() {
  return __v;
 }

 // Setter Methods 

 public void setOtp_mobile(String otp_mobile) {
  this.otp_mobile = otp_mobile;
 }

 public void setOtp_secrete(String otp_secrete) {
  this.otp_secrete = otp_secrete;
 }

 public void setGroup_type(String group_type) {
  this.group_type = group_type;
 }

 public void setService(String service) {
  this.service = service;
 }

 public void setCreated_time(float created_time) {
  this.created_time = created_time;
 }

 public void set_id(String _id) {
  this._id = _id;
 }

 public void set__v(float __v) {
  this.__v = __v;
 }
}