package tz.co.comptech.m_safariproduction.Auth;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;
import java.util.Queue;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
import tz.co.comptech.m_safariproduction.Helpers.FormValues;
import tz.co.comptech.m_safariproduction.Helpers.ViewGutter;
import tz.co.comptech.m_safariproduction.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    EditText inputTextEmail,inputTextNewPassword,inputTextConfirmPassword;
    Button buttonResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_auth_reset_password);

        inputTextEmail = findViewById(R.id.fragment_auth_reset_password_phone);
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
            formData.put(FormValues.KEY, FormHelper.createPartFormString(ViewGutter.getString(inputTextEmail)));
            formData.put(FormValues.NEW_PASSWORD, FormHelper.createPartFormString(ViewGutter.getString(inputTextEmail)));
        }else{
            inputTextConfirmPassword.setError("Password Mismatch");
        }
    }
}
