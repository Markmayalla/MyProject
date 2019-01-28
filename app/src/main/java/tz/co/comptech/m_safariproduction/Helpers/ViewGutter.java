package tz.co.comptech.m_safariproduction.Helpers;

import android.widget.EditText;
import android.widget.TextView;

public class ViewGutter {
    public static String getString(EditText editText){
        return editText.getText().toString();
    }

    public static String getString(TextView textView){
        return textView.getText().toString();
    }
}
