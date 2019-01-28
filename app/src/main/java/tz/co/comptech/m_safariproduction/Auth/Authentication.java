package tz.co.comptech.m_safariproduction.Auth;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Map;
import java.util.Objects;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Helpers.FragmentHelper;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

public class Authentication extends AppCompatActivity implements SignUp.OnSignUpClickListener, SignIn.OnSignInClickListener, VerifyPhone.OnVerifyClickListener, ResetPassword.OnResetClickListener{
    SignUp signUp;
    SignIn signIn;
    VerifyPhone verifyPhone;
    ResetPassword resetPassword;
    FragmentHelper fragmentHelper;
    AuthenticationViewModel authenticationViewModel;

    public static final String activitySignIn = "signIn";
    public static final String activitySignUp = "signUp";
    public static final String activityForget = "forgetPassword";
    public static final String activityVerify = "verifyPhone";

    private final int fragmentView = R.id.activity_authentication_fragment_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        authenticationViewModel = ViewModelProviders.of(this).get(AuthenticationViewModel.class);
        setSignUp();
    }

    @Override
    public void onResetClicked(Map<String, String> string, Map<String, RequestBody> formData) {

    }

    @Override
    public void onSignInClicked(Map<String, String> string,  Map<String, RequestBody> formData) {
        if(Objects.requireNonNull(string.get("activity")).equals(activityForget)){
            setResetPassword();
        }else if(Objects.requireNonNull(string.get("activity")).equals(activitySignIn)){
            authenticationViewModel.signIn(formData).observe(this,signInData -> {
                if (Objects.requireNonNull(signInData).getStatus()) {
                    setSignUp();
                }else{
                    Toast.makeText(getApplicationContext(),"Data " + signInData.getSms(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onSignUpClicked(Map<String, String> string, Map<String, RequestBody> formData) {

    }

    @Override
    public void onVerifyClicked(Map<String, String> string,  Map<String, RequestBody> formData) {

    }


    public void setSignUp() {
        signUp = new SignUp();
        fragmentHelper = new FragmentHelper(this);
        fragmentHelper.add(fragmentView,signUp);
    }

    public void repSignUp() {
        signUp = new SignUp();
        Bundle bundle = new Bundle();
        fragmentHelper = new FragmentHelper(this);
        fragmentHelper.replace(fragmentView,signUp);
    }

    public void setSignIn() {
        signIn = new SignIn();
        fragmentHelper = new FragmentHelper(this);
        fragmentHelper.replace(fragmentView,signIn);
    }

    public void setVerifyPhone() {
        verifyPhone = new VerifyPhone();
        fragmentHelper = new FragmentHelper(this);
        fragmentHelper.replace(fragmentView,verifyPhone);
    }

    public void setResetPassword() {
        resetPassword = new ResetPassword();
        fragmentHelper = new FragmentHelper(this);
        fragmentHelper.replace(fragmentView,resetPassword);
    }
}
