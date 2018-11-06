package tz.co.comptech.m_safariproduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tz.co.comptech.m_safariproduction.Api.Bus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.hellowWorld);
        textView.setText(Bus.busApi);
    }
}
