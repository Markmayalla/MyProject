package tz.co.comptech.m_safariproduction.Search;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import okhttp3.RequestBody;
import tz.co.comptech.m_safariproduction.Adapter.Region.AutoCompleteRegionAdapter;
import tz.co.comptech.m_safariproduction.Api.SearchApi;
import tz.co.comptech.m_safariproduction.Auth.SignInActivity;
import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.Helpers.StringHelper;
import tz.co.comptech.m_safariproduction.Model.AutoCompleteRegion;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.ResponseModel.search.fromto.ScheduleBusModel;
import tz.co.comptech.m_safariproduction.ResponseModel.search.fromto.ScheduledBus;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.ViewModel.RoomViewModel;
import tz.co.comptech.m_safariproduction.ViewModel.ApplicationViewModel;

public class Dashboard extends AppCompatActivity {

    TextView textView;
    ApplicationViewModel applicationViewModel;
    RoomViewModel roomViewModel;
    LiveData<List<RegionPoints>> points;
    LiveData<List<Region>> regions;
    AutoCompleteTextView fromEditText, toEditText;
    DatePicker datePicker;

    AutoCompleteRegionAdapter regionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(Dashboard.this, SharedValues.SHARED_LOGIN_DATA);

        textView = findViewById(R.id.buses);
        applicationViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        points = roomViewModel.getRegion_points();
        regions = roomViewModel.getRegions();

        regions.observe(Dashboard.this, regions1 -> {
            ArrayList<AutoCompleteRegion> regions2 = new ArrayList<>();
            for (Region region : regions1){
                regions2.add(new AutoCompleteRegion(
                        region.getRegion_id(),
                        region.get_id(),
                        region.getName(),
                        region.get__v()
                ));
               // Log.e("finaly_block", "sms " + region.getName());
            }

//            regionAdapter = new AutoCompleteRegionAdapter(getApplicationContext(), R.layout.adapter_region_autocomplete, regions2);
//            fromEditText = findViewById(R.id.activity_dashboard_from);
//            toEditText = findViewById(R.id.activity_dashboard_to);
//            fromEditText.setAdapter(regionAdapter);
//            toEditText.setAdapter(regionAdapter);
//
//            fromEditText.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    String getData = parent.getItemAtPosition(position).toString();
//
//                    Log.e("finaly_block", "data :" + getData);
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) {
//
//                }
//            });
        });


        points = roomViewModel.getRegion_points();
        String first_name = sharedPreferenceHelper.getString(SharedValues.FIRST_NAME,"F");
        String middle_name = sharedPreferenceHelper.getString(SharedValues.MIDDLE_NAME,"M");
        String last_name = sharedPreferenceHelper.getString(SharedValues.LAST_NAME,"L");

        Map<String, RequestBody> formdata = new HashMap<>();
        String url = SearchApi.GET_SCHEDULLED_BUSES + "/" + "2019-01-01/5bf13b670b16fd3d303c1922/5bf13b5c0b16fd3d303c1921";
        applicationViewModel.getDataFromServer(url).observe(this, buses -> {
            Gson gson = new Gson();

            if(StringHelper.compare2(buses,"200")){
                ScheduleBusModel scheduledBus = gson.fromJson(buses,ScheduleBusModel.class);
                textView.setText(scheduledBus.getScheduledBuses().get(0).getCancellation_policy());
                Log.e("finaly_block", "Mshan " + scheduledBus.getScheduledBuses().get(0).getCancellation_policy());
            }else{
                Log.e("finaly_block", "Mshan " + StringHelper.getCode2(buses));
            }
        });

    }

    private  ArrayList<String> getRegions(){
        final ArrayList<String> strings = null;

        regions.observe(Dashboard.this, regions1 -> {
            for (Region region : regions1){
                assert strings != null;
                strings.add(region.getName());
            }
        });
        return strings;
    }


    public void logOut(View view) {
        startActivity(new Intent(Dashboard.this, SignInActivity.class));
    }
}
