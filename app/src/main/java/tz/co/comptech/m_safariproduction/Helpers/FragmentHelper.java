package tz.co.comptech.m_safariproduction.Helpers;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import tz.co.comptech.m_safariproduction.Auth.ResetPassword;
import tz.co.comptech.m_safariproduction.Auth.SignIn;
import tz.co.comptech.m_safariproduction.Auth.SignUp;
import tz.co.comptech.m_safariproduction.Auth.VerifyPhone;

public class FragmentHelper {
    private static FragmentTransaction fragmentTransaction;
    public FragmentHelper(Context context){
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public void add(int id, SignUp signUp){
        fragmentTransaction.add(id, signUp);
        fragmentTransaction.commit();
    }

    public void replace(int id,SignUp signUp){
        fragmentTransaction.replace(id, signUp);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void replace(int id,SignIn signIn){
        fragmentTransaction.replace(id, signIn);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void replace(int id,VerifyPhone verifyPhone){
        fragmentTransaction.replace(id, verifyPhone);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void replace(int id,ResetPassword resetPassword){
        fragmentTransaction.replace(id, resetPassword);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
