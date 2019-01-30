package tz.co.comptech.m_safariproduction.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Api.Authentication;
import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
import tz.co.comptech.m_safariproduction.Helpers.FormValues;
import tz.co.comptech.m_safariproduction.Helpers.ServiceNameList;
import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.Helpers.StringHelper;
import tz.co.comptech.m_safariproduction.Helpers.ViewGutter;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.OnPasswordRestModel;
import tz.co.comptech.m_safariproduction.ViewModel.ApplicationViewModel;
import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class VerifyPhoneActivity extends AppCompatActivity implements View.OnClickListener {
    EditText otp_secrete;
    Button resendOTP, verifyOTP;

    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;

    SharedPreferenceHelper sharedPreferenceHelper;

    ApplicationViewModel authView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_auth_verify_phone);
        otp_secrete = (EditText)findViewById(R.id.fragment_auth_verify_phone_otp);

        formData = new HashMap<>();
        sharedPreferenceHelper = new SharedPreferenceHelper(this, SharedValues.SHARED_REGISTER_DATA);
        authView = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        resendOTP = findViewById(R.id.fragment_auth_verify_phone_resend);
        verifyOTP = findViewById(R.id.fragment_auth_verify_phone_verify);

        resendOTP.setOnClickListener(this);
        verifyOTP.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_auth_verify_phone_verify:
                funVerifyOtp();
                break;
            case R.id.fragment_auth_verify_phone_resend:
                funResendOtp();
                break;
        }
    }

    private void funResendOtp() {
        formData.put(FormValues.CUSTOMER_ID, FormHelper.createPartFormString(sharedPreferenceHelper.getString(SharedValues.OTP_CUSTOMER_ID,"")));
        authView.postDataToServer(Authentication.resend_otp, formData).observe(VerifyPhoneActivity.this, otpVerification -> {
            if(StringHelper.compare(otpVerification,"200")){
                Log.e("d","success " + otpVerification);
                otp_secrete.setText("6666");
                finish();
            }else if(StringHelper.compare(otpVerification,"400")){
                Log.e("d","error");
                otp_secrete.setText("Error");
            }
        });
    }

    private void funVerifyOtp() {
        String service = sharedPreferenceHelper.getString(SharedValues.OTP_SERVICE,"");
        formData.put(FormValues.OTP_MOBILE, FormHelper.createPartFormString(sharedPreferenceHelper.getString(SharedValues.OTP_MOBILE,"")));
        formData.put(FormValues.OTP_SERVICE, FormHelper.createPartFormString(service));
        formData.put(FormValues.OTP_SECRETE, FormHelper.createPartFormString(ViewGutter.getString(otp_secrete)));
        authView.postDataToServer(Authentication.validate_otp, formData).observe(VerifyPhoneActivity.this, otpVerification -> {
            if(StringHelper.compare(otpVerification,"200")){
                Log.e("back_data","success " + otpVerification);
                if(ServiceNameList.SERVICE_PASSWORD_RESET.equals(service)) {
                    Gson gson = new Gson();
                    OnPasswordRestModel onPasswordRestModel = gson.fromJson(otpVerification, OnPasswordRestModel.class);
                    sharedPreferenceHelper = new SharedPreferenceHelper(VerifyPhoneActivity.this, SharedValues.SHARED_RESET_DATA);
                    sharedPreferenceHelper.editor();
                    sharedPreferenceHelper.setString(SharedValues.CUSTOMER_ID,onPasswordRestModel.getDataModel().getCustomer_id());
                    sharedPreferenceHelper.setString(SharedValues.KEY,onPasswordRestModel.getDataModel().getKey());
                    sharedPreferenceHelper.setBoolean(SharedValues.VERIFICATION,onPasswordRestModel.getDataModel().getVerification());
                    sharedPreferenceHelper.apply();

                    startActivity(new Intent(VerifyPhoneActivity.this, ResetPasswordActivity.class));
                }else if(ServiceNameList.SERVICE_REGISTER.equals(service)){
                    startActivity(new Intent(VerifyPhoneActivity.this, Dashboard.class));
                }
                finish();
            }else if(StringHelper.compare(otpVerification,"400")){
                Log.e("d","error");
            }
        });
    }
}
