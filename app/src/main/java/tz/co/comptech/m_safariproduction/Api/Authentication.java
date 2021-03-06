package tz.co.comptech.m_safariproduction.Api;
/*
    Created in 05/11/2018

    This file extend AppConnection this hold all Authentication Api's
 */
public class Authentication extends AppConnection {
    /*
        Variable holding Authentication Url extend from connection
     */
    private final static String authApi = "auth/";
    public final static String register_user = authApi + "signup_by_phone";
    public final static String login_user = authApi + "login_by_phone";
    public final static String validate_otp = authApi + "verify_customer_phone";
    public final static String resend_otp = authApi + "resend_signup_otp";
    public final static String reset_password_by_phone = authApi + "reset_password";
    public final static String request_pass_reset_otp = authApi + "request_pass_reset_otp";
}

