package tz.co.comptech.m_safariproduction.Search;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tz.co.comptech.m_safariproduction.Adapter.Search.SeatAdapter;
import tz.co.comptech.m_safariproduction.Adapter.Search.SeatRecyclerAdapter;
import tz.co.comptech.m_safariproduction.Api.PhotoLink;
import tz.co.comptech.m_safariproduction.Api.SearchApi;
import tz.co.comptech.m_safariproduction.Helpers.StringHelper;
import tz.co.comptech.m_safariproduction.Model.Blank_seats_obj_array;
import tz.co.comptech.m_safariproduction.Model.Bus;
import tz.co.comptech.m_safariproduction.Model.BusSeatConfig;
import tz.co.comptech.m_safariproduction.Model.Seat;
import tz.co.comptech.m_safariproduction.Model.SeatDrawingObject;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.ResponseModel.search.fromto.ScheduleBusModel;
import tz.co.comptech.m_safariproduction.ViewModel.ApplicationViewModel;

public class SeatActivity extends AppCompatActivity {

    /**
     * The {@link androidx.viewpager.widget.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * androidx.fragment.app.FragmentStatePagerAdapter.
     */
    int SECTION_TOTAL_NUM = 0;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    Type listBuses;
    String stringBuses = "data";
    ArrayList<Bus> scheduledBus;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    ApplicationViewModel applicationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        applicationViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        String url = SearchApi.BUSES; // + "/" + "2019-01-01/5bf13b670b16fd3d303c1922/5bf13b5c0b16fd3d303c1921";
        applicationViewModel.getDataFromServer(url).observe(this, buses -> {
            Gson gson = new Gson();
            stringBuses = buses;
            listBuses = new  TypeToken<List<Bus>>(){}.getType();
            scheduledBus = gson.fromJson(buses,  listBuses);
            SECTION_TOTAL_NUM = scheduledBus.size();
            // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);
            Log.e("finaly_block", "Mshan " + SECTION_TOTAL_NUM);
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_SECTION_DATA = "section_data";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String stringBuses) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_SECTION_DATA, stringBuses);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_seat, container, false);
            Type listBuses = new  TypeToken<List<Bus>>(){}.getType();
            ArrayList<Bus> scheduleBusModel;
            TextView busName = (TextView) rootView.findViewById(R.id.fragment_seat_bus_name);
            TextView busModel = (TextView) rootView.findViewById(R.id.fragment_seat_model);
            TextView busPhone = (TextView) rootView.findViewById(R.id.fragment_seat_phone);
            TextView busSeatType = (TextView) rootView.findViewById(R.id.fragment_seat_type);
            TextView message = (TextView) rootView.findViewById(R.id.fragment_seat_sms);
            ImageView profileImage = rootView.findViewById(R.id.fragment_seat_profile_image);

            RecyclerView recyclerView = rootView.findViewById(R.id.fragment_seat_layout);


            String dataBuses = getArguments().getString(ARG_SECTION_DATA);
            Bus currentBus;
            ArrayList<Bus> bu = new ArrayList<>();

            Gson gson = new Gson();
            scheduleBusModel =  gson.fromJson(dataBuses,  listBuses);
            currentBus = scheduleBusModel.get(getArguments().getInt(ARG_SECTION_NUMBER) - 1);

            busName.setText(currentBus.getBus_name());
            busModel.setText(currentBus.getModel());
            busPhone.setText(currentBus.getPhone());
            busSeatType.setText(currentBus.getSeat_type());
            Picasso.get().load(PhotoLink.bus_profile + currentBus.getProfile()).fit().placeholder(R.mipmap.msafari_icon).into(profileImage);

            if(currentBus.getSeat_configObject().size() > 0){
                message.setVisibility(View.VISIBLE);
                message.setText("Has seat Configuration");
                recyclerView.setVisibility(View.VISIBLE);
                ArrayList<SeatDrawingObject>  drawingObjects = new ArrayList<>();
                BusSeatConfig busSeatConfig = currentBus.getSeat_configObject().get(0);

                int seat_pos = 0;
                int blank_pos = 0;
                for (int i = 0; i < currentBus.getSeat_configObject().get(0).getTotal_seats_per_flow(); i++){
                    int index = (busSeatConfig.getBlank_seats_obj_array().get(0).getRow() * currentBus.getSeat_configObject().get(0).getNo_cols()) + busSeatConfig.getBlank_seats_obj_array().get(0).getCol();
                    if(busSeatConfig.getSeats().get(seat_pos).getIndex() == i){
                        drawingObjects.add(i, new SeatDrawingObject(
                                busSeatConfig.getSeats().get(seat_pos).getRow(),
                                busSeatConfig.getSeats().get(seat_pos).getCol(),
                                busSeatConfig.getSeats().get(seat_pos).getLevel(),
                                busSeatConfig.getSeats().get(seat_pos).getIndex(),
                                busSeatConfig.getSeats().get(seat_pos).get_id(),
                                true,
                                currentBus.getBus_name(),
                                currentBus.getCompany_id(),
                                currentBus.get_id()
                        ));
                        seat_pos++;
                    }else if(index == i){
                        drawingObjects.add(index, new SeatDrawingObject(
                                busSeatConfig.getBlank_seats_obj_array().get(blank_pos).getRow(),
                                busSeatConfig.getBlank_seats_obj_array().get(blank_pos).getCol(),
                                0,
                                index,
                                "___id" + index,
                                false,
                                currentBus.getBus_name(),
                                currentBus.getCompany_id(),
                                currentBus.get_id()
                        ));
                        blank_pos++;
                    }else{
                        drawingObjects.add(index, new SeatDrawingObject(
                                0,
                                0,
                                0,
                                i,
                                "___id" + i,
                                false,
                                currentBus.getBus_name(),
                                currentBus.getCompany_id(),
                                currentBus.get_id()
                        ));
                    }
                }

                Collections.sort(drawingObjects, new Comparator<SeatDrawingObject>() {
                    @Override
                    public int compare(SeatDrawingObject o1, SeatDrawingObject o2) {
                        return Integer.compare(o1.getIndex(), o2.getIndex());
                    }
                });

                if(currentBus.getSeat_configObject().get(0).getNo_cols() > 0) {
                    SeatRecyclerAdapter seatAdapter = new SeatRecyclerAdapter(getContext(), drawingObjects);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), currentBus.getSeat_configObject().get(0).getNo_cols()));
                    recyclerView.setAdapter(seatAdapter);
                }else{
                    message.setVisibility(View.VISIBLE);
                    message.setText("Span count should be at least 1");
                }
            }else{
                message.setVisibility(View.VISIBLE);
                message.setText("Has No seat Configuration");
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1, getData());
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return SECTION_TOTAL_NUM;
        }

        public String getData(){
            return stringBuses;
        }
    }
}
