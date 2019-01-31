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
import android.widget.TextView;

import com.google.gson.Gson;
import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;
import com.shuhart.stepview.StepView;

import java.util.HashMap;
import java.util.Map;

public class VerifyPhoneActivity extends AppCompatActivity implements View.OnClickListener {
    OtpView otp_secrete;
    StepView stepView;
    TextView response, header_title, header_subtitle;
    Button resendOTP, verifyOTP;

    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;

    SharedPreferenceHelper sharedPreferenceHelper;

    ApplicationViewModel authView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_otp_verification);
        otp_secrete = findViewById(R.id.otp_view);

        stepView = findViewById(R.id.step_view);
        formData = new HashMap<>();
        sharedPreferenceHelper = new SharedPreferenceHelper(this, SharedValues.SHARED_REGISTER_DATA);
        authView = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        resendOTP = findViewById(R.id.otp_resend);
        verifyOTP = findViewById(R.id.otp_validate);
        response = findViewById(R.id.response);

        header_title = findViewById(R.id.header_title);
        header_subtitle = findViewById(R.id.header_subtitle);
        header_title.setText("Register");
        header_subtitle.setText("OTP Verification");

        stepView.go(2,true);
        otp_secrete.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String s) {
                funVerifyOtp();
            }
        });
        resendOTP.setOnClickListener(this);
        verifyOTP.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.otp_validate:
                funVerifyOtp();
                break;
            case R.id.otp_resend:
                funResendOtp();
                break;
        }
    }

    private void funResendOtp() {
        formData.put(FormValues.CUSTOMER_ID, FormHelper.createPartFormString(sharedPreferenceHelper.getString(SharedValues.OTP_CUSTOMER_ID,"")));
        authView.postDataToServer(Authentication.resend_otp, formData).observe(VerifyPhoneActivity.this, otpVerification -> {
            if(StringHelper.compare(otpVerification,"201")){
                Log.e("d","success " + otpVerification);

                response.setText("SMS Service is Down, Kindly use 6666");
            }else if(StringHelper.compare(otpVerification,"400")){
                Log.e("d","error");
                response.setText("Something wen't wrong");
            }
        });
    }

    private void funVerifyOtp() {
        if (otp_secrete.getText().toString().isEmpty()) {
            response.setText("OTP Secret is Required");
            return;
        }
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
                    Gson gson = new Gson();
                    OnPasswordRestModel onPasswordRestModel = gson.fromJson(otpVerification, OnPasswordRestModel.class);
                    sharedPreferenceHelper = new SharedPreferenceHelper(VerifyPhoneActivity.this, SharedValues.SHARED_RESET_DATA);
                    sharedPreferenceHelper.editor();
                    sharedPreferenceHelper.setString(SharedValues.CUSTOMER_ID,onPasswordRestModel.getDataModel().getCustomer_id());
                    sharedPreferenceHelper.setString(SharedValues.KEY,onPasswordRestModel.getDataModel().getKey());
                    sharedPreferenceHelper.setBoolean(SharedValues.VERIFICATION,onPasswordRestModel.getDataModel().getVerification());
                    sharedPreferenceHelper.apply();

                    startActivity(new Intent(VerifyPhoneActivity.this, ResetPasswordActivity.class));
                }
                finish();
            }else if(StringHelper.compare(otpVerification,"400")){
                Log.e("d","error");
            } else {
                response.setText("Invalid OTP, Please enter the digits carefully or resend OTP");
            }
        });
    }
}
