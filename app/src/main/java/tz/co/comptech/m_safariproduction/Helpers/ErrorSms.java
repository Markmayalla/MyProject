package tz.co.comptech.m_safariproduction.Helpers;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class ErrorSms {
    public static void setErrorSms(TextView textView, String s){
        textView.setVisibility(View.VISIBLE);
        textView.setText(s);
    }
}
