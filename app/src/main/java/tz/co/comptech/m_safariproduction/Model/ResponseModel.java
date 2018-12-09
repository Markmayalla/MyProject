package tz.co.comptech.m_safariproduction.Model;

import android.util.JsonReader;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {
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
