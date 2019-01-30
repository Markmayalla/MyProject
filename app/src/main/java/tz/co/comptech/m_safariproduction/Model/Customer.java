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
 @SerializedName("middle_name")
 private String middle_name;
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
 @SerializedName("profile_pic")
 private String profile_pic;
 @SerializedName("region")
 private String region;
 @SerializedName("country")
 private String country;
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

      public String getMiddle_name() {
         return middle_name;
      }
      public String getProfile_pic() {
       return profile_pic;
      }

      public String getRegion() {
       return region;
      }

      public String getCountry() {
       return country;
      }
}