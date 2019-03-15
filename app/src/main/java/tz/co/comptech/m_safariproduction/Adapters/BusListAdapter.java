package tz.co.comptech.m_safariproduction.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PublicKey;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView bus_name, category, plate, departure, route, price;
        public ImageView bus_picture;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
