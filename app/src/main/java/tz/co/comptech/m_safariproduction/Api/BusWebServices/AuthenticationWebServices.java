package tz.co.comptech.m_safariproduction.Api.BusWebServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import tz.co.comptech.m_safariproduction.Api.Authentication;
import tz.co.comptech.m_safariproduction.Model.Customer;
import tz.co.comptech.m_safariproduction.Model.OTP;
import tz.co.comptech.m_safariproduction.Model.ResponseModel;
import tz.co.comptech.m_safariproduction.Model.UserLoginModel;

public interface AuthenticationWebServices {
    @POST(Authentication.select_user)
    Call<Customer> getUser(@Body Customer Customer);

    @POST(Authentication.select_user)
    Call<ResponseModel> createNewUser(@Body Customer Customer);

    @PUT(Authentication.update_user)
    Call<ResponseModel> updateUser(@Body Customer Customer);

    @POST(Authentication.login_user)
    Call<Customer> loginToSystem(@Body UserLoginModel userLoginModel);

    @POST(Authentication.validate_otp)
    Call<ResponseModel> validateOtp(@Body OTP otpModel);
}


