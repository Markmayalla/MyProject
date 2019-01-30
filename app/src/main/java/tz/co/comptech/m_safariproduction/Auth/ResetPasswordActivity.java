package tz.co.comptech.m_safariproduction.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import androidx.lifecycle.ViewModelProviders;
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
import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignUp201Model;
import tz.co.comptech.m_safariproduction.ViewModel.ApplicationViewModel;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    EditText inputTextNewPassword,inputTextConfirmPassword;
    Button buttonResetPassword;
    ApplicationViewModel applicationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_auth_reset_password);

        formData = new HashMap<>();
        applicationViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        inputTextNewPassword = findViewById(R.id.fragment_auth_reset_password_new_password);
        inputTextConfirmPassword = findViewById(R.id.fragment_auth_reset_password_confirm_new_password);
        buttonResetPassword = findViewById(R.id.fragment_auth_reset_password_button);

        buttonResetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_auth_reset_password_button:
                funPasswordRest();
                break;
        }
    }

    private void funPasswordRest() {
        if(ViewGutter.getString(inputTextNewPassword).equals(ViewGutter.getString(inputTextConfirmPassword))) {
            SharedPreferenceHelper helper = new SharedPreferenceHelper(ResetPasswordActivity.this, SharedValues.SHARED_RESET_DATA);
            formData.put(FormValues.KEY, FormHelper.createPartFormString(helper.getString(SharedValues.KEY,"")));
            formData.put(FormValues.NEW_PASSWORD, FormHelper.createPartFormString(ViewGutter.getString(inputTextNewPassword)));
            applicationViewModel.postDataToServer(Authentication.reset_password_by_phone, formData).observe(this, passwordReset -> {
                Gson gson = new Gson();
                if(StringHelper.getCode(passwordReset).equals("400")){
                    ErrorDataModel errorDataModel = gson.fromJson(passwordReset,ErrorDataModel.class);
                    //ErrorSms.setErrorSms(errorText,errorDataModel.getSms());
                    Toast.makeText(ResetPasswordActivity.this,"data " + errorDataModel.getSms(), Toast.LENGTH_LONG).show();
                }

                if(StringHelper.getCode(passwordReset).equals("200")){
                    startActivity(new Intent(ResetPasswordActivity.this, SignInActivity.class));
                }
            });
        }else{
            inputTextConfirmPassword.setError("Password Mismatch");
        }
    }
}
