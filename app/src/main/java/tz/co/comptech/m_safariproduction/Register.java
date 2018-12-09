package tz.co.comptech.m_safariproduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);
    }

    public void register(View view) {
        Intent intent = new Intent(Register.this,LoginActivity.class);
        startActivity(intent);
    }
}
