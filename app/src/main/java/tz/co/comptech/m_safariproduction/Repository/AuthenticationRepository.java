package tz.co.comptech.m_safariproduction.Repository;


import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Api.BusWebServices.AuthenticationWebServices;
import tz.co.comptech.m_safariproduction.Api.ServiceGenerator;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpReset;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpVerification;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ResetPassword;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignIn;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp400;

public class AuthenticationRepository {
    public AuthenticationWebServices authenticationWebServices;
    public AuthenticationWebServices loginService;

    MutableLiveData<SignUp201> signUp201;
    MutableLiveData<OtpReset> otpReset;
    MutableLiveData<SignUp400> signUp400;
    MutableLiveData<OtpVerification> otpVerification;
    MutableLiveData<ResetPassword> resetPassword;
    MutableLiveData<SignIn> signIn;
    public AuthenticationRepository() {
        authenticationWebServices = AppConnection.getClient().create(AuthenticationWebServices.class);
        signUp201 = new MutableLiveData<>();
        signUp400 = new MutableLiveData<>();
        otpReset = new MutableLiveData<>();
        otpVerification = new MutableLiveData<>();
        resetPassword = new MutableLiveData<>();
        signIn = new MutableLiveData<>();
    }


    public MutableLiveData<SignUp201> getSignUp(final Map<String, RequestBody> signUpData) {
        authenticationWebServices.signUp(signUpData).enqueue(new Callback<SignUp201>() {
            @Override
            public void onResponse(Call<SignUp201> call, Response<SignUp201> response) {
                if (response.isSuccessful()) {
                    signUp201.postValue(response.body());
                }else{

                }

              Log.e("Back_Request", response.code() + response.message());
            }

            @Override
                public void onFailure(Call<SignUp201> call, Throwable t) {
            }
        });
        return signUp201;
    }

    public MutableLiveData<OtpReset> resendOtp(final Map<String, RequestBody> otpData){
        authenticationWebServices.resendOtp(otpData).enqueue(new Callback<OtpReset>() {
            @Override
            public void onResponse(Call<OtpReset> call, Response<OtpReset> response) {
               otpReset.postValue(response.body());
            }

            @Override
            public void onFailure(Call<OtpReset> call, Throwable t) {

            }
        });
        return otpReset;
    }

    public MutableLiveData<OtpVerification> verifyPhone(final Map<String, RequestBody> otpData){
        authenticationWebServices.verifyOtp(otpData).enqueue(new Callback<OtpVerification>() {
            @Override
            public void onResponse(Call<OtpVerification> call, Response<OtpVerification> response) {
                otpVerification.postValue(response.body());
            }

            @Override
            public void onFailure(Call<OtpVerification> call, Throwable t) {

            }
        });
        return otpVerification;
    }

    public MutableLiveData<ResetPassword> resetPassword(final Map<String , RequestBody> passwordReset){
        authenticationWebServices.resetPassword(passwordReset).enqueue(new Callback<ResetPassword>() {
            @Override
            public void onResponse(Call<ResetPassword> call, Response<ResetPassword> response) {
                resetPassword.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResetPassword> call, Throwable t) {

            }
        });
        return  resetPassword;
    }

    public MutableLiveData<SignIn> signIn(final  Map<String, RequestBody> signBody){
        loginService = ServiceGenerator.createService(AuthenticationWebServices.class,"Hemedi.manyinja@neymonict.com","123456");
        loginService.signIn(signBody).enqueue(new Callback<SignIn>() {
            @Override
            public void onResponse(Call<SignIn> call, Response<SignIn> response) {
                if (response.isSuccessful()) {
                    // user object available
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<SignIn> call, Throwable t) {

            }
        });
        return signIn;
    }
}
