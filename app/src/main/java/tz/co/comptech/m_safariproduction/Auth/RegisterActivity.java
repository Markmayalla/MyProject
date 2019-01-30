    package tz.co.comptech.m_safariproduction.Auth;

    import androidx.annotation.Nullable;
    import androidx.lifecycle.ViewModelProviders;

    import android.app.PendingIntent;
    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.IntentFilter;
    import android.content.IntentSender;
    import android.os.Bundle;
    import androidx.appcompat.widget.AppCompatButton;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.google.android.gms.auth.api.Auth;
    import com.google.android.gms.auth.api.credentials.Credential;
    import com.google.android.gms.auth.api.credentials.HintRequest;
    import com.google.android.gms.auth.api.phone.SmsRetriever;
    import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
    import com.google.android.gms.common.api.CommonStatusCodes;
    import com.google.android.gms.common.api.GoogleApiClient;
    import com.google.android.gms.common.api.Status;
    import com.google.android.gms.tasks.Task;
    import com.google.gson.Gson;

    import java.io.IOException;
    import java.util.HashMap;
    import java.util.Map;

    import okhttp3.RequestBody;
    import tz.co.comptech.m_safariproduction.Api.Authentication;
    import tz.co.comptech.m_safariproduction.Api.BusWebServices.AuthenticationWebServices;
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
    import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

    public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
        private static final int RESOLVE_HINT = 567;
        private EditText first_name, last_name, phone, password, email;
        private TextView errorText;
        private Button btnSignUp, btnSignIn;
        private Map<String, String> valueReturn;
        private Map<String, RequestBody> formData;

        ApplicationViewModel authView;
        private AppCompatButton buttonConfirm;
        private EditText editTextConfirmOtp;
        private BroadcastReceiver broadcastReceiver;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_auth_signup);

            formData = new HashMap<>();
            first_name = findViewById(R.id.fragment_auth_signup_first_name);
            errorText = findViewById(R.id.m_safari_error_text);
            last_name = findViewById(R.id.fragment_auth_signup_last_name);
            phone = findViewById(R.id.fragment_auth_signup_phone_no);
            password = findViewById(R.id.fragment_auth_signup_password);
            email = findViewById(R.id.fragment_auth_signup_email);

            btnSignUp = findViewById(R.id.fragment_auth_signup_signup);
            btnSignIn = findViewById(R.id.fragment_auth_signup_signin);

            btnSignIn.setOnClickListener(this);
            btnSignUp.setOnClickListener(this);
            requestHint();

            authView = ViewModelProviders.of(this).get(ApplicationViewModel.class);
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

            authView.postDataToServer(Authentication.register_user,formData).observe(this, responseBody -> {
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
                    startActivity(new Intent(RegisterActivity.this, VerifyPhoneActivity.class));
                }

            });
        }

        private void requestHint() {
            HintRequest hintRequest = new HintRequest.Builder()
                    .setPhoneNumberIdentifierSupported(true)
                    .build();


            GoogleApiClient googleApiClient =  new GoogleApiClient.Builder(this)
                    .addApi(Auth.CREDENTIALS_API)
                    .build();;

            PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(
                    googleApiClient, hintRequest);
            try {
                        startIntentSenderForResult(intent.getIntentSender(),
                        RESOLVE_HINT, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                Log.e("sms_retriver",e.getMessage());
            }
        }

        public void startSmsRetriever() {
            SmsRetrieverClient client =  SmsRetriever.getClient(getApplicationContext());
            Task<Void> task = client.startSmsRetriever();

            task.addOnSuccessListener(aVoid -> {
                Log.e("sms_retriver","1 Started listening for SMS");
            });

            task.addOnFailureListener(e -> {
                Log.e("sms_retriver","2 Failed listening for SMS");
            });
        }

        void addBroadcastRecieverForSMS() {
            Log.e("sms_retriver","addBroadcastReceiverForSMS");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);

            broadcastReceiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.e("sms_retriver","SMS Broadcast receiver onReceive()");
                    Bundle extras = intent.getExtras();
                    Status status = (Status) extras.get(SmsRetriever.EXTRA_STATUS);

                    switch(status.getStatusCode()) {
                        case CommonStatusCodes.SUCCESS:
                            Log.e("sms_retriver","onReceive() success");
                            // Get SMS message contents
                            String message = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                            String otp = extraSMSCode(message);
                            //Sent OTP to backend for verification
                            break;

                        case CommonStatusCodes.TIMEOUT:
                            Log.e("sms_retriver","onReceive() timeout");
                            break;

                        default :
                            break;
                    }
                }
            };

            startSmsRetriever();
            registerReceiver(broadcastReceiver,intentFilter);
        }

        private String extraSMSCode(String message) {
            return "6666";
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RESOLVE_HINT) {
                if (resultCode == RESULT_OK) {
                    Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                    phone.setText(credential.getId());
                    addBroadcastRecieverForSMS();
                }
            }
        }
    }
