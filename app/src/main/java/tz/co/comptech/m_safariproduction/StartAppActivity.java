package tz.co.comptech.m_safariproduction;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import tz.co.comptech.m_safariproduction.Api.SearchApi;
import tz.co.comptech.m_safariproduction.Auth.RegisterActivity;
import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.Helpers.StringHelper;
import tz.co.comptech.m_safariproduction.ResponseModel.auth.ErrorDataModel;
import tz.co.comptech.m_safariproduction.ResponseModel.search.CenterData;
import tz.co.comptech.m_safariproduction.ResponseModel.search.CenterDataModel;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.ViewModel.RoomViewModel;
import tz.co.comptech.m_safariproduction.Search.Dashboard;
import tz.co.comptech.m_safariproduction.ViewModel.ApplicationViewModel;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class StartAppActivity extends AppCompatActivity {

    ApplicationViewModel appViewModel;
    RoomViewModel roomViewModel;
    ProgressBar progressBar;
    private Map<String, String> formData;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        formData = new HashMap<>();
        progressBar = findViewById(R.id.activity_start_app_welcome_loader);
        progressBar.setVisibility(View.VISIBLE);
        appViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        try {
            appViewModel.getDataFromServer(SearchApi.BUS_CENTERS).observe(this, busesCenter -> {
                Gson gson = new Gson();
                if(StringHelper.getCode2(busesCenter).equals("401")){
                    ErrorDataModel errorDataModel = gson.fromJson(busesCenter,ErrorDataModel.class);
                }
                if(StringHelper.getCode2(busesCenter).equals("200")){
                    CenterData regions = gson.fromJson(busesCenter, CenterData.class);
                    List<CenterDataModel> centerDataModels = regions.getDataModels();
                    for (int i = 0; i < centerDataModels.size(); i++) {
                        //Log.e("finaly_block", "data " + centerDataModels.get(i).getRegionName());
                        CenterDataModel centerDataModel = centerDataModels.get(i);
                        roomViewModel.insert(new Region(
                                centerDataModel.getRegion_id(),
                                centerDataModel.getId(),
                                centerDataModel.getRegionName(),
                                centerDataModel.get__v()
                        ));

                        ArrayList points = centerDataModel.getPoints();
                        for (int j = 0; j < points.size(); j++) {
                            roomViewModel.insert(new RegionPoints(
                                    1,
                                    points.get(j).toString(),
                                    centerDataModel.getRegion_id()
                            ));
                            //Log.e("finaly_block", "data " + centerDataModels.get(i).getRegionName() + " points " + points.get(j).toString());
                        }
                    }
                }
                //Log.e("finaly_block", "Reached");
            });

        }catch (IllegalArgumentException  e) {
            Log.e("HemediError", "Hemedi " + e.getMessage());
        } finally{
            SharedPreferenceHelper helper = new SharedPreferenceHelper(getApplicationContext(), SharedValues.SHARED_LOGIN_DATA);
            String token = helper.getString(SharedValues.TOKEN, "");
            progressBar.setVisibility(View.GONE);
            Log.e("finaly_block","Finally " + token);
            if(token.equals("")){
                startActivity(new Intent(StartAppActivity.this, RegisterActivity.class));
            }else{
                startActivity(new Intent(StartAppActivity.this, Dashboard.class));
            }
        }

    }
}
