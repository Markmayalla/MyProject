package tz.co.comptech.m_safariproduction.Auth;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.R;

public class ResetPassword extends Fragment implements  View.OnClickListener{
    Map<String, String> valueReturn;
    Map<String, RequestBody> formData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View resetPasswordView = inflater.inflate(R.layout.fragment_password_config,container,false);

        return resetPasswordView;
    }

    OnResetClickListener buttonClickListener;

    @Override
    public void onClick(View view) {

    }

    public interface OnResetClickListener{
        void onResetClicked(Map<String, String> string,  Map<String, RequestBody> formData);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonClickListener = (OnResetClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " Must implement OnButtonClick listener");
        }
    }
}
