package tz.co.comptech.m_safariproduction.Helpers;

import android.util.Log;

public class StringHelper {
    public static String getCode(String responseBody){
        Log.e("worker",responseBody);
        int index = responseBody.indexOf("code") + 7;
        String data = responseBody.substring(index,index + 3);
        Log.e("finaly_block", "dd" + data);
        return data;
    }

    public static String getCode2(String responseBody){
        //Log.e("worker",responseBody);
        int index = responseBody.indexOf("code") + 6;
        String data = responseBody.substring(index,index + 3);
        //Log.e("finaly_block", "dd" + data);
        return data;
    }

    public static Boolean compare(String response, String code){
        return getCode(response).equals(code);
    }

    public static Boolean compare2(String response, String code){
        return getCode2(response).equals(code);
    }
}
