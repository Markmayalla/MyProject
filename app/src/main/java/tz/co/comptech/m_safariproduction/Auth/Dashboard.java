package tz.co.comptech.m_safariproduction.Auth;

import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import tz.co.comptech.m_safariproduction.Adapters.RegionsListAdapter;
import tz.co.comptech.m_safariproduction.DatePickerFragment;
import tz.co.comptech.m_safariproduction.Helpers.SharedPreferenceHelper;
import tz.co.comptech.m_safariproduction.Helpers.SharedValues;
import tz.co.comptech.m_safariproduction.Model.Bus;
import tz.co.comptech.m_safariproduction.Model.BusCenter;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.Room.Model.Region;
import tz.co.comptech.m_safariproduction.Room.Model.RegionPoints;
import tz.co.comptech.m_safariproduction.Room.ViewModel.RoomViewModel;
import tz.co.comptech.m_safariproduction.ViewModel.RouteViewModel;

public class Dashboard extends AppCompatActivity {

    LiveData<List<Bus>> buses;
    List<BusCenter> centers;
    RouteViewModel viewModel;

    //Views
    String dateString;
    AutoCompleteTextView from, to;
    TextView date, month, day;
    Button search;
    CardView datePicker;

    private AdapterView.OnItemClickListener onItemClickLister = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Dashboard.this, "Item Clicked: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(Dashboard.this, SharedValues.SHARED_LOGIN_DATA);

        //Instatiating the viewmodel
        viewModel = ViewModelProviders.of(this).get(RouteViewModel.class);

        viewModel.getCenters();

        from = (AutoCompleteTextView) findViewById(R.id.from);
        to = (AutoCompleteTextView) findViewById(R.id.to);
        date = findViewById(R.id.date);
        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        search = findViewById(R.id.search);
        datePicker = findViewById(R.id.cardView);

        dateString = "";

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buses = viewModel.searchRoute(from.getText().toString(), to.getText().toString(),dateString);
            }
        });

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });



        //Autosuggestions for Bus Centers
        centers = new ArrayList<>();
        RegionsListAdapter adapter = new RegionsListAdapter(this,R.layout.buslist_item,centers);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
        from.setOnItemClickListener(onItemClickLister);
        to.setOnItemClickListener(onItemClickLister);

    }

    public void logOut(View view) {
        startActivity(new Intent(Dashboard.this, SignInActivity.class));
    }

    public void showDatePickerDialog() {
        DialogFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "DatePicker");
    }
}
