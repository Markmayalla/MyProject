package tz.co.comptech.m_safariproduction.Helpers;

import androidx.annotation.NonNull;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class FormHelper {
    @NonNull
    static public RequestBody createPartFormString(String description){
        return RequestBody.create(MultipartBody.FORM,description);
    }
}
