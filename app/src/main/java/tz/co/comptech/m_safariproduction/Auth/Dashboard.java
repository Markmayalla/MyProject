package tz.co.comptech.m_safariproduction.Auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tz.co.comptech.m_safariproduction.R;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void logOut(View view) {
        startActivity(new Intent(Dashboard.this, RegisterActivity.class));
    }
}
