package tz.co.comptech.m_safariproduction.Adapter.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import tz.co.comptech.m_safariproduction.Api.Bus;
import tz.co.comptech.m_safariproduction.Model.SeatDrawingObject;
import tz.co.comptech.m_safariproduction.R;

public class SeatAdapter extends ArrayAdapter<SeatDrawingObject> {
    private Context context;
    private int resource;
    private ArrayList<SeatDrawingObject> buses;
    public SeatAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SeatDrawingObject> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.buses = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.adapter_seat_view, parent, false);
        }
        SeatDrawingObject currentBus = getItem(position);

        return convertView;
    }

    public SeatDrawingObject getItem(int position) {
        return buses.get(position);
    }


    @Override
    public int getCount() {
        return buses.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
