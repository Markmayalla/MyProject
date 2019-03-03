package tz.co.comptech.m_safariproduction.Api;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiWebInterface {
    @Multipart
    @POST
    Call<ResponseBody> postDataToServer(@Url String url, @PartMap Map<String, RequestBody> data);

    @Multipart
    @POST
    Call<ResponseBody> postDataToServer(@Url String url, @PartMap Map<String, RequestBody> data, @Header("Authorization") String token);

    @GET
    Call<ResponseBody> getDataFroServer(@Url String url);

    @GET
    Call<ResponseBody> getDataFroServer(@Url String url, @Header("Authorization") String token);

    @DELETE
    Call<ResponseBody> deleteDataFroServer(@Url String url);

    @DELETE
    Call<ResponseBody> deleteDataFroServer(@Url String url, @Header("Authorization") String token);

    @Multipart
    @PUT
    Call<ResponseBody> putDataFroServer(@Url String url, @PartMap Map<String, RequestBody> data);

    @Multipart
    @PUT
    Call<ResponseBody> putDataFroServer(@Url String url, @PartMap Map<String, RequestBody> data, @Header("Authorization") String token);
}
