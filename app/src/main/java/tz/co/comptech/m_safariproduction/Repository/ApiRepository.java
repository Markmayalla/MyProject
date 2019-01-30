package tz.co.comptech.m_safariproduction.Repository;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import androidx.lifecycle.MutableLiveData;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tz.co.comptech.m_safariproduction.Api.ApiWebInterface;
import tz.co.comptech.m_safariproduction.Api.AppConnection;

public class ApiRepository {
    private ApiWebInterface webInterface;
    private MutableLiveData<String> responseBody;

    public ApiRepository() {
        webInterface = AppConnection.getClient().create(ApiWebInterface.class);
        responseBody = new MutableLiveData<>();
    }

    public MutableLiveData<String> postDataToServer(final String url, final Map<String, RequestBody> signUpData) {

        webInterface.postDataToServer(url, signUpData).enqueue(new Callback<ResponseBody>() {
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

    public MutableLiveData<String> getDataFromServer(final String url, final Map<String, RequestBody> signUpData) {
        webInterface.getDataFroServer(url, signUpData).enqueue(new Callback<ResponseBody>() {
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


    public MutableLiveData<String> deleteDataFromServer(final String url, final Map<String, RequestBody> signUpData) {
        webInterface.deleteDataFroServer(url, signUpData).enqueue(new Callback<ResponseBody>() {
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

    public MutableLiveData<String> putDataFroServer(final String url, final Map<String, RequestBody> signUpData) {
        webInterface.putDataFroServer(url, signUpData).enqueue(new Callback<ResponseBody>() {
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
}
