package tz.co.comptech.m_safariproduction.Auth;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.R;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView login = findViewById(R.id.data_login_name);
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(Dashboard.this, SharedValues.SHARED_LOGIN_DATA);

        String first_name = sharedPreferenceHelper.getString(SharedValues.FIRST_NAME,"F");
        String middle_name = sharedPreferenceHelper.getString(SharedValues.MIDDLE_NAME,"M");
        String last_name = sharedPreferenceHelper.getString(SharedValues.LAST_NAME,"L");
        login.setText(first_name + " " + middle_name + " " + last_name);
    }

    public void logOut(View view) {
        startActivity(new Intent(Dashboard.this, RegisterActivity.class));
    }
}
