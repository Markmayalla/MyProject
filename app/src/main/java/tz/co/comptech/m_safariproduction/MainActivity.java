package tz.co.comptech.m_safariproduction;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

public class MainActivity extends AppCompatActivity {
    AuthenticationViewModel authenticationViewModel;
    Map<String, RequestBody> registrationData;

    private String customer_id = "";
    private String otp_id = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrationData = new HashMap<>();
        authenticationViewModel = ViewModelProviders.of(this).get(AuthenticationViewModel.class);
    }

    public void createUserNew(View view) {
        registrationData.put("first_name",FormHelper.createPartFormString("Hemedi"));
        registrationData.put("last_name",FormHelper.createPartFormString("Mshamu"));
        registrationData.put("phone_no",FormHelper.createPartFormString("255673852003"));
        registrationData.put("email",FormHelper.createPartFormString("jkus@gmail.com"));
        registrationData.put("password",FormHelper.createPartFormString("mypassword"));

        authenticationViewModel.getSignUp201(registrationData).observe(this, signUp201 -> {

            String backSms = "";
            assert signUp201 != null;
            try {
                customer_id = backSms = signUp201.getCustomer().get_id();
                otp_id = signUp201.get_id();
            }catch (NullPointerException e){
                backSms = signUp201.getSms();
            }

            TextView myText = (TextView)findViewById(R.id.myText);
            myText.setText(backSms);
        });
    }

    public void resendOtp(View view) {
        registrationData = new HashMap<>();
        registrationData.put("customer_id",FormHelper.createPartFormString(customer_id));
        authenticationViewModel.resendOtp(registrationData).observe(this, signUp201 -> {
            TextView myText = (TextView)findViewById(R.id.myText);
            myText.setText("Sent to " + signUp201.getCustomer().getPhone_no());
        });
    }

    public void verifyPhone(View view) {
        EditText otp = (EditText)findViewById(R.id.otp_secrete);
        registrationData = new HashMap<>();
        registrationData.put("customer_id",FormHelper.createPartFormString(customer_id));
        registrationData.put("_id",FormHelper.createPartFormString(otp_id));
        registrationData.put("otp_secrete",FormHelper.createPartFormString(otp.getText().toString()));

        authenticationViewModel.verifyPhone(registrationData).observe(this, otpVerification -> {
            TextView myText = (TextView)findViewById(R.id.myText);
            myText.setText("Verification is  " + otpVerification.getVerification());
        });
    }

    public void resetPassword(View view) {
        EditText phone = (EditText)findViewById(R.id.phone_no);
        registrationData = new HashMap<>();
        registrationData.put("phone_no",FormHelper.createPartFormString(phone.getText().toString()));
        authenticationViewModel.resetPassword(registrationData).observe(this, resetPassword -> {
            TextView myText = (TextView)findViewById(R.id.myText);
            myText.setText("," + resetPassword.getSms());
        });
    }

    public void signIn(View view) {
        EditText phone = (EditText)findViewById(R.id.phone_no);
        EditText password = (EditText)findViewById(R.id.otp_secrete);
        registrationData = new HashMap<>();
        registrationData.put("phone_no",FormHelper.createPartFormString(phone.getText().toString()));
        registrationData.put("password",FormHelper.createPartFormString(password.getText().toString()));
        authenticationViewModel.signIn(registrationData).observe(this, signIn -> {
            TextView myText = (TextView)findViewById(R.id.myText);
            if(signIn.getStatus()) {
                myText.setText(signIn.getSms() + " " + signIn.getData().getCustomer().getFirst_name() + " " + signIn.getData().getCustomer().getLast_name());
            }else{
                myText.setText(signIn.getSms());
            }
        });
    }
}