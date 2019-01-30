package tz.co.comptech.m_safariproduction.Repository;


import androidx.lifecycle.MutableLiveData;
import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Api.BusWebServices.AuthenticationWebServices;
import tz.co.comptech.m_safariproduction.Api.ServiceGenerator;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpResetModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpVerificationModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ResetPasswordModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignInModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201Model;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorModel;

public class AuthenticationRepository {
    public AuthenticationWebServices authenticationWebServices;
    public AuthenticationWebServices loginService;

    MutableLiveData<SignUp201Model> signUp201;
    MutableLiveData<OtpResetModel> otpReset;
    MutableLiveData<ErrorModel> signUp400;
    MutableLiveData<OtpVerificationModel> otpVerification;
    MutableLiveData<ResetPasswordModel> resetPassword;
    MutableLiveData<SignInModel> signIn;
    MutableLiveData<String> responseBody;
    public AuthenticationRepository() {
        authenticationWebServices = AppConnection.getClient().create(AuthenticationWebServices.class);
        signUp201 = new MutableLiveData<>();
        signUp400 = new MutableLiveData<>();
        otpReset = new MutableLiveData<>();
        otpVerification = new MutableLiveData<>();
        resetPassword = new MutableLiveData<>();
        responseBody = new MutableLiveData<>();
        signIn = new MutableLiveData<>();
    }


    public MutableLiveData<String> getSignUp(final Map<String, RequestBody> signUpData) {

        authenticationWebServices.signUp(signUpData).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        responseBody.postValue(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.e("Back_Request", response.code() +" " +response.message());
                }

            }

            @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
        return responseBody;
    }

    public MutableLiveData<OtpResetModel> resendOtp(final Map<String, RequestBody> otpData){
        authenticationWebServices.resendOtp(otpData).enqueue(new Callback<OtpResetModel>() {
            @Override
            public void onResponse(Call<OtpResetModel> call, Response<OtpResetModel> response) {
               otpReset.postValue(response.body());
            }

            @Override
            public void onFailure(Call<OtpResetModel> call, Throwable t) {

            }
        });
        return otpReset;
    }

    public MutableLiveData<OtpVerificationModel> verifyPhone(final Map<String, RequestBody> otpData){
        authenticationWebServices.verifyOtp(otpData).enqueue(new Callback<OtpVerificationModel>() {
            @Override
            public void onResponse(Call<OtpVerificationModel> call, Response<OtpVerificationModel> response) {
                otpVerification.postValue(response.body());
            }

            @Override
            public void onFailure(Call<OtpVerificationModel> call, Throwable t) {

            }
        });
        return otpVerification;
    }

    public MutableLiveData<ResetPasswordModel> resetPassword(final Map<String , RequestBody> passwordReset){
        authenticationWebServices.resetPassword(passwordReset).enqueue(new Callback<ResetPasswordModel>() {
            @Override
            public void onResponse(Call<ResetPasswordModel> call, Response<ResetPasswordModel> response) {
                resetPassword.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResetPasswordModel> call, Throwable t) {

            }
        });
        return  resetPassword;
    }

    public MutableLiveData<SignInModel> signIn(final  Map<String, RequestBody> signBody){
        loginService = ServiceGenerator.createService(AuthenticationWebServices.class,"Hemedi.manyinja@neymonict.com","123456");
        loginService.signIn(signBody).enqueue(new Callback<SignInModel>() {
            @Override
            public void onResponse(Call<SignInModel> call, Response<SignInModel> response) {
                signIn.postValue(response.body());
            }

            @Override
            public void onFailure(Call<SignInModel> call, Throwable t) {

            }
        });
        return signIn;
    }
}
