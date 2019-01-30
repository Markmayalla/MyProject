package tz.co.comptech.m_safariproduction.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import tz.co.comptech.m_safariproduction.Repository.AuthenticationRepository;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpResetModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OtpVerificationModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ResetPasswordModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignInModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201Model;

public class AuthenticationViewModel extends ViewModel {

    private AuthenticationRepository authenticationRepository;
    private MutableLiveData<SignUp201Model> signUp201;
    private MutableLiveData<OtpResetModel> otpReset;
    private MutableLiveData<OtpVerificationModel> otpVerification;
    private MutableLiveData<ResetPasswordModel> resetPassword;
    private MutableLiveData<SignInModel> signIn;
    private MutableLiveData<String> repos;

    public AuthenticationViewModel(){
        authenticationRepository = new AuthenticationRepository();
    }


    public MutableLiveData<String> getSignUp201(final Map<String , RequestBody> signUpData) {
        if(repos == null){
            repos = new MutableLiveData<>();
        }
        repos = authenticationRepository.getSignUp(signUpData);
        return repos;
    }

    public  MutableLiveData<OtpResetModel> resendOtp(final Map<String , RequestBody> otpData){
        if(otpReset == null){
            otpReset = new MutableLiveData<>();
        }
        otpReset = authenticationRepository.resendOtp(otpData);
        return otpReset;
    }

    public MutableLiveData<OtpVerificationModel>  verifyPhone(final  Map<String, RequestBody> otpData){
        if(otpVerification == null){
            otpVerification = new MutableLiveData<>();
        }
        otpVerification = authenticationRepository.verifyPhone(otpData);
        return otpVerification;
    }

    public MutableLiveData<ResetPasswordModel> resetPassword(final  Map<String, RequestBody> passwordReset){
        if(resetPassword == null){
            resetPassword = new MutableLiveData<>();
        }
        resetPassword = authenticationRepository.resetPassword(passwordReset);
        return resetPassword;
    }

    public MutableLiveData<SignInModel> signIn(final Map<String, RequestBody> signBody){
        if(signIn == null){
            signIn = new MutableLiveData<>();
        }
        signIn = authenticationRepository.signIn(signBody);
        return  signIn;
    }

    public MutableLiveData<SignUp201Model> getSignUp201(){
        if(signUp201 == null){
            signUp201 = new MutableLiveData<>();
        }
        return  signUp201;
    }
}
