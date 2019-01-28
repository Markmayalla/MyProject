package tz.co.comptech.m_safariproduction.Auth;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Helpers.ErrorSms;
import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
import tz.co.comptech.m_safariproduction.Helpers.FormValues;
import tz.co.comptech.m_safariproduction.Helpers.ViewGutter;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText phone, password;
    TextView error;
    Button btnSignIn, forgetPassword, btnSignUp;
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;

    AuthenticationViewModel authView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_auth_signin);

        valueReturn = new HashMap<>();
        formData = new HashMap<>();

        authView = ViewModelProviders.of(this).get(AuthenticationViewModel.class);

        phone = findViewById(R.id.fragment_auth_signin_phone);
        error = findViewById(R.id.sign_m_safari_error_text);
        password = findViewById(R.id.fragment_auth_signin_password);
        btnSignIn = findViewById(R.id.fragment_auth_signin_button);
        btnSignUp = findViewById(R.id.fragment_auth_signup_button);

        forgetPassword = findViewById(R.id.fragment_auth_signin_forget_password);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_auth_signin_forget_password:
                    funSignPassword();
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

            authView.signIn(formData).observe(this, signIn -> {
                assert signIn != null;
                if(signIn.getStatus()) {
                    startActivity(new Intent(SignInActivity.this, Dashboard.class));
                }else{
                    ErrorSms.setErrorSms(error,signIn.getSms());
                }
            });
    }

    private void funSignPassword() {
        startActivity(new Intent(SignInActivity.this, ResetPasswordActivity.class));
    }
}
