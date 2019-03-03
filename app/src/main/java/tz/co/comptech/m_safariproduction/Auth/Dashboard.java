package tz.co.comptech.m_safariproduction.Auth;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.ViewModel.RoomViewModel;

public class Dashboard extends AppCompatActivity {

    RoomViewModel roomViewModel;
    LiveData<List<RegionPoints>> points;
    LiveData<List<Region>> regions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(Dashboard.this, SharedValues.SHARED_LOGIN_DATA);

        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        points = roomViewModel.getRegion_points();
        regions = roomViewModel.getRegions();

        regions.observe(Dashboard.this, regions1 -> {
            for (Region region : regions1){
                Log.e("Database", "Database " + region.getName());
            }
        });
        points = roomViewModel.getRegion_points();
        String first_name = sharedPreferenceHelper.getString(SharedValues.FIRST_NAME,"F");
        String middle_name = sharedPreferenceHelper.getString(SharedValues.MIDDLE_NAME,"M");
        String last_name = sharedPreferenceHelper.getString(SharedValues.LAST_NAME,"L");
    }

    public void logOut(View view) {
        startActivity(new Intent(Dashboard.this, SignInActivity.class));
    }
}
