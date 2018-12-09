package tz.co.comptech.m_safariproduction.Api.BusWebServices;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import tz.co.comptech.m_safariproduction.Api.Authentication;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpVerification;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ResetPassword;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignIn;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201;

public interface AuthenticationWebServices {
    @Multipart
    @POST(Authentication.register_user)
    Call<SignUp201> signUp(@PartMap Map<String, RequestBody> register);

    @Multipart
    @POST(Authentication.login_user)
    Call<SignIn> signIn(@PartMap Map<String, RequestBody> login);

    @Multipart
    @POST(Authentication.resend_otp)
    Call<SignUp201> resendOtp(@PartMap Map<String, RequestBody> otp);

    @Multipart
    @POST(Authentication.validate_otp)
    Call<OtpVerification> verifyOtp(@PartMap Map<String, RequestBody> otpValidate);

    @Multipart
    @POST(Authentication.reset_password_by_phone)
    Call<ResetPassword> resetPassword(@PartMap Map<String, RequestBody> password);
}


