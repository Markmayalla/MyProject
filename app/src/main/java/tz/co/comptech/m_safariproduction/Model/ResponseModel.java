package tz.co.comptech.m_safariproduction.Model;

import android.util.JsonReader;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {
     @SerializedName("first_name")
     private
     String first_name;
     @SerializedName("last_name")
     private
     String last_name;
     @SerializedName("email")
     private
     String email;
     @SerializedName("password")
     private
     String password;
     @SerializedName("gender")
     private
     String gender;
     @SerializedName("address")
     private
     String address;
     @SerializedName("phone_number")
     private
     String phone_number;
     @SerializedName("nida_id")
     private
     String nida_id;

     public ResponseModel(String first_name, String last_name, String email, String password, String gender, String address, String phone_number, String nida_id) {
          this.first_name = first_name;
          this.last_name = last_name;
          this.email = email;
          this.password = password;
          this.gender = gender;
          this.address = address;
          this.phone_number = phone_number;
          this.nida_id = nida_id;
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

    public String getPhone_number() {
        return phone_number;
    }

    public String getNida_id() {
        return nida_id;
    }
}
