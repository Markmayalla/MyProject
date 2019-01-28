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

public class SignIn extends Fragment implements View.OnClickListener {
    EditText phone, password;
    Button btnSignIn, forgetPassword;
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        valueReturn = new HashMap<>();
        formData = new HashMap<>();
        View signIn = inflater.inflate(R.layout.fragment_auth_signin,container,false);
            phone = (EditText)signIn.findViewById(R.id.fragment_auth_signin_phone);
            password = (EditText)signIn.findViewById(R.id.fragment_auth_signin_password);
            btnSignIn = (Button) signIn.findViewById(R.id.fragment_auth_signin_button);
            forgetPassword = (Button)signIn.findViewById(R.id.fragment_auth_signin_forget_password);
            btnSignIn.setOnClickListener(this);
            forgetPassword.setOnClickListener(this);
        return signIn;
    }




   OnSignInClickListener buttonClickListener;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_auth_signin_button:
                formData.put("phone",FormHelper.createPartFormString(phone.getText().toString()));
                formData.put("password",FormHelper.createPartFormString(password.getText().toString()));
                valueReturn.put("activity",Authentication.activitySignIn);
                break;
            case R.id.fragment_auth_signin_forget_password:
                valueReturn.put("activity",Authentication.activityForget);
                break;
        }

        buttonClickListener.onSignInClicked(valueReturn,formData);
    }

    public interface OnSignInClickListener{
         void onSignInClicked(Map<String, String> string,  Map<String, RequestBody> formData);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonClickListener = (OnSignInClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " Must implement OnButtonClick listener");
        }
    }
}
