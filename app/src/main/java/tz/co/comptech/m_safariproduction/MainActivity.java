package tz.co.comptech.m_safariproduction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tz.co.comptech.m_safariproduction.Api.Bus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view) {
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }
}
