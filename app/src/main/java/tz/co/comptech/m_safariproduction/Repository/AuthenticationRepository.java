package tz.co.comptech.m_safariproduction.Repository;


import android.support.annotation.NonNull;
import android.util.Log;

import tz.co.comptech.m_safariproduction.Api.*;

import tz.co.comptech.m_safariproduction.Api.BusWebServices.AuthenticationWebServices;
import tz.co.comptech.m_safariproduction.Model.Customer;
import tz.co.comptech.m_safariproduction.Model.OTP;
import tz.co.comptech.m_safariproduction.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tz.co.comptech.m_safariproduction.Model.UserLoginModel;

public class AuthenticationRepository {
    public AuthenticationWebServices authenticationWebServices;
    private Customer users;
    private ResponseModel responseModel;

    public AuthenticationRepository() {
        authenticationWebServices = AppConnection.getClient().create(AuthenticationWebServices.class);
    }

    public Customer getUsers(Customer userId){
        authenticationWebServices.getUser(userId).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                users = response.body();
                Log.e("Retrofit_Result","back " + users.getFirst_name());
                Log.e("Retrofit_Result",response.code() + " " + response.message());
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Log.e("Retrofit_Result","error " + t.getMessage());
            }
        });
        return users;
    }

    public ResponseModel createUser(Customer customer){
        authenticationWebServices.createNewUser(customer).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
                responseModel = response.body();
                Log.e("Retrofit_Result","back " + responseModel.getFirst_name());
                Log.e("Retrofit_Result",response.code() + " " + response.message());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call,@NonNull Throwable t) {
                Log.e("Retrofit_Result","error " + t.getMessage());
            }
        });
        return responseModel;
    }

    public ResponseModel updateUser(Customer Customer){
        authenticationWebServices.updateUser(Customer).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                responseModel = response.body();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
        return responseModel;
    }

    public Customer loginToSystem(UserLoginModel userLoginModel){
        authenticationWebServices.loginToSystem(userLoginModel).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
               users = response.body();
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });
        return users;
    }

    public ResponseModel validateOtp(OTP otpModel){
        authenticationWebServices.validateOtp(otpModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                responseModel = response.body();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
        return responseModel;
    }
}
