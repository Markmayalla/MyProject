package tz.co.comptech.m_safariproduction.Api;
/*
    Created in 05/11/2018

    This file extend AppConnection this hold all Authentication Api's
 */
public class Authentication extends AppConnection {
    /*
        Variable holding Authentication Url extend from connection
     */
    public final static String authApi = "auth/";
    public final static String register_user = authApi + "users/create/";
    public final static String update_user = authApi + "users/update/";
    public final static String select_user = "insert_seat.php";
    public final static String login_user = authApi + "login/";
    public final static String validate_otp = authApi + "otp/";
}

