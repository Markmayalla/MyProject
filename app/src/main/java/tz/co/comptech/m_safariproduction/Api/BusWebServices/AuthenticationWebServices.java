package tz.co.comptech.m_safariproduction.Api.BusWebServices;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Url;
import tz.co.comptech.m_safariproduction.Api.Authentication;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpResetModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpVerificationModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ResetPasswordModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignInModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201Model;

public interface AuthenticationWebServices {
    @Multipart
    @POST(Authentication.register_user)
    Call<ResponseBody> signUp(@PartMap Map<String, RequestBody> register);

    @Multipart
    @POST(Authentication.login_user)
    Call<SignInModel> signIn(@PartMap Map<String, RequestBody> login);

    @Multipart
    @POST(Authentication.resend_otp)
    Call<OtpResetModel> resendOtp(@PartMap Map<String, RequestBody> otp);

    @Multipart
    @POST(Authentication.validate_otp)
    Call<OtpVerificationModel> verifyOtp(@PartMap Map<String, RequestBody> otpValidate);

    @Multipart
    @POST(Authentication.reset_password_by_phone)
    Call<ResetPasswordModel> resetPassword(@PartMap Map<String, RequestBody> password);
}


