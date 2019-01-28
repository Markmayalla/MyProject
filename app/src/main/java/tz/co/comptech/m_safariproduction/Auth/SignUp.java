package tz.co.comptech.m_safariproduction.Auth;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Helpers.FormHelper;
import tz.co.comptech.m_safariproduction.R;

public class SignUp extends Fragment implements View.OnClickListener {
    EditText first_name, last_name, phone, password, email;
    Button btnSignUp, btnSignIn;
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        valueReturn = new HashMap<>();
        formData = new HashMap<>();
        View signUp = inflater.inflate(R.layout.fragment_auth_signup,container,false);
            first_name = (EditText)signUp.findViewById(R.id.fragment_auth_signup_first_name);
            last_name = (EditText)signUp.findViewById(R.id.fragment_auth_signup_last_name);
            phone = (EditText)signUp.findViewById(R.id.fragment_auth_signup_email);
            password = (EditText)signUp.findViewById(R.id.fragment_auth_signup_password);
            email = (EditText)signUp.findViewById(R.id.fragment_auth_signup_phone_no);

            btnSignUp = (Button)signUp.findViewById(R.id.fragment_auth_signup_signup);
            btnSignIn = (Button)signUp.findViewById(R.id.fragment_auth_signup_signin);

            btnSignIn.setOnClickListener(this);
            btnSignUp.setOnClickListener(this);
        return signUp;
    }



    OnSignUpClickListener buttonClickListener;

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fragment_auth_signup_signup:
                formData.put("first_name", FormHelper.createPartFormString(first_name.getText().toString()));
                formData.put("last_name", FormHelper.createPartFormString(last_name.getText().toString()));
                formData.put("phone_no", FormHelper.createPartFormString(phone.getText().toString()));
                formData.put("password", FormHelper.createPartFormString(password.getText().toString()));
                formData.put("email", FormHelper.createPartFormString(email.getText().toString()));
                valueReturn.put("activity",Authentication.activitySignUp);
                break;
            case R.id.fragment_auth_signup_signin:
                valueReturn.put("activity",Authentication.activitySignIn);
                break;
        }
        buttonClickListener.onSignUpClicked(valueReturn,formData);
    }

    public interface OnSignUpClickListener{
        void onSignUpClicked(Map<String, String> string,  Map<String, RequestBody> formData);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonClickListener = (OnSignUpClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " Must implement OnButtonClick listener");
        }
    }
}
