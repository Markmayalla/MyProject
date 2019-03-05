package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Company {
 @SerializedName("company_name")
 private String company_name;
 @SerializedName("phone")
 private String phone;
    @SerializedName("_id")
    private String _id;
// @SerializedName("email")
// private String email;
// @SerializedName("website_url")
// private String website_url;
// @SerializedName("profile")
// private String profile;
// @SerializedName("blocked")
// private boolean blocked;
// @SerializedName("addresses")
// ArrayList<CompanyAddress> addresses;


    public String getCompany_name() {
        return company_name;
    }

    public String getPhone() {
        return phone;
    }

    public String get_id() {
        return _id;
    }
}