    package tz.co.comptech.m_safariproduction.Auth;

    import android.app.ProgressDialog;
    import android.arch.lifecycle.ViewModelProviders;
    import android.content.Intent;
    import android.support.v7.app.AlertDialog;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.AppCompatButton;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.android.volley.Request;
    import com.android.volley.toolbox.StringRequest;

    import org.json.JSONException;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Objects;

    import okhttp3.RequestBody;
    import tz.co.comptech.m_safariproduction.Helpers.ErrorSms;
    import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
    import tz.co.comptech.m_safariproduction.Helpers.FormValues;
    import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
    import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
    import tz.co.comptech.m_safariproduction.Helpers.ViewGutter;
    import tz.co.comptech.m_safariproduction.R;
    import tz.co.comptech.m_safariproduction.Register;
    import tz.co.comptech.m_safariproduction.ResponseModel.auth.SignIn;
    import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

    public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
        EditText first_name, last_name, phone, password, email;
        TextView errorText;
        Button btnSignUp, btnSignIn;
        Map<String, String> valueReturn;
        Map<String, RequestBody> formData;

        AuthenticationViewModel authView;
        private AppCompatButton buttonConfirm;
        private EditText editTextConfirmOtp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_auth_signup);

            formData = new HashMap<>();
            first_name = findViewById(R.id.fragment_auth_signup_first_name);
            errorText = findViewById(R.id.m_safari_error_text);
            last_name = findViewById(R.id.fragment_auth_signup_last_name);
            phone = findViewById(R.id.fragment_auth_signup_email);
            password = findViewById(R.id.fragment_auth_signup_password);
            email = findViewById(R.id.fragment_auth_signup_phone_no);

            btnSignUp = findViewById(R.id.fragment_auth_signup_signup);
            btnSignIn = findViewById(R.id.fragment_auth_signup_signin);

            btnSignIn.setOnClickListener(this);
            btnSignUp.setOnClickListener(this);

            authView = ViewModelProviders.of(this).get(AuthenticationViewModel.class);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fragment_auth_signup_signup:
                        funSignUp();
                    break;
                case R.id.fragment_auth_signup_signin:
                        funSignIn();
                    break;
            }
        }

        private void funSignIn() {
            startActivity(new Intent(RegisterActivity.this, SignInActivity.class));
        }

        private void funSignUp() {
            formData.put(FormValues.FIRST_NAME, FormHelper.createPartFormString(ViewGutter.getString(first_name)));
            formData.put(FormValues.LAST_NAME, FormHelper.createPartFormString(ViewGutter.getString(last_name)));
            formData.put(FormValues.PHONE_NO, FormHelper.createPartFormString(ViewGutter.getString(phone)));
            formData.put(FormValues.PASSWORD, FormHelper.createPartFormString(ViewGutter.getString(password)));
            formData.put(FormValues.EMAIL, FormHelper.createPartFormString(ViewGutter.getString(email)));

            authView.getSignUp201(formData).observe(this, signUp201 -> {

                SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(RegisterActivity.this, SharedValues.SHARED_REGISTER_DATA);
                sharedPreferenceHelper.editor();
                if(signUp201 != null) {
                    sharedPreferenceHelper.setString(SharedValues.OTP_ID, signUp201.get_id());
                    sharedPreferenceHelper.setString(SharedValues.OTP_MOBILE, signUp201.getOtp_mobile());
                    sharedPreferenceHelper.setString(SharedValues.OTP_CUSTOMER_ID, signUp201.getCustomer_id());
                    sharedPreferenceHelper.setString(SharedValues.OTP_SERVICE, signUp201.getService());
                    sharedPreferenceHelper.setString(SharedValues.OTP_SERVICE, signUp201.getSms());
                    sharedPreferenceHelper.apply();
                    if(signUp201.getStatus()) {
                        Toast.makeText(getApplicationContext(),"sms " + signUp201.getSms(),Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, VerifyPhoneActivity.class));
                    }else{
                        ErrorSms.setErrorSms(errorText,signUp201.getSms());
                    }
                }else{
                    Log.e("worker_model","Nothing ");
                }


            });
        }
    }
