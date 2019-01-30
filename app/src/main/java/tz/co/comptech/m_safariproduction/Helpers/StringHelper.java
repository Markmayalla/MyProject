package tz.co.comptech.m_safariproduction.Helpers;

import android.util.Log;

public class StringHelper {
    public static String getCode(String responseBody){
        Log.e("worker",responseBody);
        int index = responseBody.indexOf("code") + 7;
        return responseBody.substring(index,index + 3);
    }

    public static Boolean compare(String response, String code){
        return getCode(response).equals(code);
    }
}
