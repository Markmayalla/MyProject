package tz.co.comptech.m_safariproduction.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Model.Customer;
import tz.co.comptech.m_safariproduction.Repository.AuthenticationRepository;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpReset;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpVerification;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ResetPassword;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignIn;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201;

public class AuthenticationViewModel extends ViewModel {

    private AuthenticationRepository authenticationRepository;
    private MutableLiveData<SignUp201> signUp201;
    private MutableLiveData<OtpReset> otpReset;
    private MutableLiveData<OtpVerification> otpVerification;
    private MutableLiveData<ResetPassword> resetPassword;
    private MutableLiveData<SignIn> signIn;

    public AuthenticationViewModel(){
        authenticationRepository = new AuthenticationRepository();
    }


    public MutableLiveData<SignUp201> getSignUp201(final Map<String , RequestBody> signUpData) {
        if(signUp201 == null){
            signUp201 = new MutableLiveData<>();
        }
        signUp201 = authenticationRepository.getSignUp(signUpData);
        return signUp201;
    }

    public  MutableLiveData<OtpReset> resendOtp(final Map<String , RequestBody> otpData){
        if(otpReset == null){
            otpReset = new MutableLiveData<>();
        }
        otpReset = authenticationRepository.resendOtp(otpData);
        return otpReset;
    }

    public MutableLiveData<OtpVerification>  verifyPhone(final  Map<String, RequestBody> otpData){
        if(otpVerification == null){
            otpVerification = new MutableLiveData<>();
        }
        otpVerification = authenticationRepository.verifyPhone(otpData);
        return otpVerification;
    }

    public MutableLiveData<ResetPassword> resetPassword(final  Map<String, RequestBody> passwordReset){
        if(resetPassword == null){
            resetPassword = new MutableLiveData<>();
        }
        resetPassword = authenticationRepository.resetPassword(passwordReset);
        return resetPassword;
    }

    public MutableLiveData<SignIn> signIn(final Map<String, RequestBody> signBody){
        if(signIn == null){
            signIn = new MutableLiveData<>();
        }
        signIn = authenticationRepository.signIn(signBody);
        return  signIn;
    }

    public MutableLiveData<SignUp201> getSignUp201(){
        if(signUp201 == null){
            signUp201 = new MutableLiveData<>();
        }
        return  signUp201;
    }
}
