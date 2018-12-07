package tz.co.comptech.m_safariproduction.Auth;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.R;

public class VerifyPhone extends Fragment implements View.OnClickListener {
    EditText otp_secrete;
    Button resetPassword;

    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View verifyPassword = inflater.inflate(R.layout.fragment_auth_verify_phone,container,false);
        otp_secrete = (EditText)verifyPassword.findViewById(R.id.fragment_auth_verify_phone_otp);
        return verifyPassword;
    }

    OnVerifyClickListener buttonClickListener;

    @Override
    public void onClick(View view) {

    }

    public interface OnVerifyClickListener{
        void onVerifyClicked(Map<String, String> string,  Map<String, RequestBody> formData);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonClickListener = (OnVerifyClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " Must implement OnButtonClick listener");
        }
    }
}
