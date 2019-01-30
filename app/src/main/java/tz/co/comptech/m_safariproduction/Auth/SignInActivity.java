package tz.co.comptech.m_safariproduction.Auth;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Api.Authentication;
import tz.co.comptech.m_safariproduction.Helpers.ErrorSms;
import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
import tz.co.comptech.m_safariproduction.Helpers.FormValues;
import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.Helpers.StringHelper;
import tz.co.comptech.m_safariproduction.Helpers.ViewGutter;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorDataModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignInModel;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201Model;
import tz.co.comptech.m_safariproduction.ViewModel.ApplicationViewModel;
import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText phone, password;
    TextView errorText;
    Button btnSignIn, forgetPassword, btnSignUp;
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    Gson gson;
    ApplicationViewModel authView;
    SharedPreferenceHelper sharedPreferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_auth_signin);

        gson = new Gson();
        valueReturn = new HashMap<>();
        formData = new HashMap<>();

        authView = ViewModelProviders.of(this).get(ApplicationViewModel.class);

        phone = findViewById(R.id.fragment_auth_signin_phone);
        errorText = findViewById(R.id.sign_m_safari_error_text);
        password = findViewById(R.id.fragment_auth_signin_password);
        btnSignIn = findViewById(R.id.fragment_auth_signin_button);
        btnSignUp = findViewById(R.id.fragment_auth_signup_button);

        phone.setText("+255685639653");
        password.setText("1234567890");
        forgetPassword = findViewById(R.id.fragment_auth_signin_forget_password);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_auth_signin_forget_password:
                    if(!phone.getText().toString().isEmpty()) {
                        funSignPassword();
                    }else{
                        ErrorSms.setErrorSms(errorText,"Phone Required");
                    }
                break;
            case R.id.fragment_auth_signin_button:
                    funSignIn();
                break;
            case R.id.fragment_auth_signup_button:
                    funSignUp();
                break;
        }
    }

    private void funSignUp() {
        startActivity(new Intent(SignInActivity.this, RegisterActivity.class));
    }

    private void funSignIn() {
            formData.put(FormValues.PHONE_NO, FormHelper.createPartFormString(ViewGutter.getString(phone)));
            formData.put(FormValues.PASSWORD, FormHelper.createPartFormString(ViewGutter.getString(password)));

            authView.postDataToServer(Authentication.login_user,formData).observe(this, signIn -> {
                if(StringHelper.compare(signIn,"200")){
                    Log.e("d","success" + signIn);
                    SignInModel signInModel = gson.fromJson(signIn, SignInModel.class);
                    sharedPreferenceHelper = new SharedPreferenceHelper(SignInActivity.this, SharedValues.SHARED_REGISTER_DATA);
                    sharedPreferenceHelper.editor();
                    sharedPreferenceHelper.clear();

                    sharedPreferenceHelper = new SharedPreferenceHelper(SignInActivity.this, SharedValues.SHARED_LOGIN_DATA);
                    sharedPreferenceHelper.editor();
                        sharedPreferenceHelper.setString(SharedValues.FIRST_NAME,signInModel.getData().getCustomer().getFirst_name());
                        sharedPreferenceHelper.setString(SharedValues.MIDDLE_NAME,signInModel.getData().getCustomer().getMiddle_name());
                        sharedPreferenceHelper.setString(SharedValues.LAST_NAME,signInModel.getData().getCustomer().getLast_name());
                        sharedPreferenceHelper.setString(SharedValues.GENDER,signInModel.getData().getCustomer().getGender());
                        sharedPreferenceHelper.setString(SharedValues.ADDRESS,signInModel.getData().getCustomer().getAddress());
                        sharedPreferenceHelper.setString(SharedValues.ROLE,signInModel.getData().getCustomer().getRole());
                        sharedPreferenceHelper.setBoolean(SharedValues.PHONE_VERIFIED,signInModel.getData().getCustomer().getPhone_verified());
                        sharedPreferenceHelper.setBoolean(SharedValues.BLOCKED,signInModel.getData().getCustomer().getBlocked());
                        sharedPreferenceHelper.setString(SharedValues.PROFILE_PIC,signInModel.getData().getCustomer().getProfile_pic());
                        sharedPreferenceHelper.setString(SharedValues.REGION,signInModel.getData().getCustomer().getRegion());
                        sharedPreferenceHelper.setString(SharedValues.COUNTRY,signInModel.getData().getCustomer().getCountry());
                        sharedPreferenceHelper.setString(SharedValues.CREATED_DATE,signInModel.getData().getCustomer().getCreated_date());
                        sharedPreferenceHelper.setString(SharedValues.UPDATED_DATE,signInModel.getData().getCustomer().getUpdated_date());
                        sharedPreferenceHelper.setString(SharedValues._ID,signInModel.getData().getCustomer().get_id());
                        sharedPreferenceHelper.setString(SharedValues.PHONE_NO,signInModel.getData().getCustomer().getPhone_no());
                        sharedPreferenceHelper.setString(SharedValues.EMAIL,signInModel.getData().getCustomer().getEmail());
                        sharedPreferenceHelper.setString(SharedValues.TOKEN,signInModel.getData().getToken());
                    sharedPreferenceHelper.apply();

                    startActivity(new Intent(SignInActivity.this,Dashboard.class));
                    finish();
                }else if(StringHelper.compare(signIn,"401")){
                    ErrorDataModel errorDataModel = gson.fromJson(signIn,ErrorDataModel.class);
                    ErrorSms.setErrorSms(errorText,errorDataModel.getSms());
                }
            });
    }

    private void funSignPassword() {
        formData.put(FormValues.PHONE_NO, FormHelper.createPartFormString(ViewGutter.getString(phone)));
        authView.postDataToServer(Authentication.request_pass_reset_otp,formData).observe(this, responseBody -> {
            Gson gson = new Gson();
            if(StringHelper.getCode(responseBody).equals("400")){
                ErrorDataModel errorDataModel = gson.fromJson(responseBody,ErrorDataModel.class);
                ErrorSms.setErrorSms(errorText,errorDataModel.getSms());
            }

            if(StringHelper.getCode(responseBody).equals("201")){
                SignUp201Model success = gson.fromJson(responseBody,SignUp201Model.class);
                ErrorSms.setErrorSms(errorText,success.getSms());
                SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(getApplicationContext(), SharedValues.SHARED_REGISTER_DATA);
                sharedPreferenceHelper.editor();
                sharedPreferenceHelper.setString(SharedValues.OTP_CUSTOMER_ID,success.getDataModel().getCustomer_id());
                sharedPreferenceHelper.setString(SharedValues.OTP_ID,success.getDataModel().get_id());
                sharedPreferenceHelper.setString(SharedValues.OTP_MOBILE,success.getDataModel().getOtp_mobile());
                sharedPreferenceHelper.setString(SharedValues.OTP_SERVICE,success.getDataModel().getService());
                sharedPreferenceHelper.apply();
                startActivity(new Intent(SignInActivity.this, VerifyPhoneActivity.class));
            }

        });
    }
}
