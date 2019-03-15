package tz.co.comptech.m_safariproduction.Adapter.Search;

import android.content.Context;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import tz.co.comptech.m_safariproduction.Model.SeatDrawingObject;
import tz.co.comptech.m_safariproduction.R;

public class SeatRecyclerAdapter extends RecyclerView.Adapter<SeatRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private ArrayList<SeatDrawingObject> seatDrawingObjects;
    public SeatRecyclerAdapter(Context context, ArrayList<SeatDrawingObject> seatDrawingObjects) {
      this.seatDrawingObjects = seatDrawingObjects;
      this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_seat_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SeatDrawingObject current = getItem(position);

        holder.seatNo.setText("A" + current.getIndex());
        Picasso.get().load(R.drawable.common_google_signin_btn_icon_dark).placeholder(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imageView);
        if(!current.getIs_seat_empty()){
            holder.seatNo.setVisibility(View.INVISIBLE);
            holder.imageView.setVisibility(View.INVISIBLE);
        }else {
            holder.seatNo.setId(position);
            holder.imageView.setId(position);
            holder.seatNo.setOnClickListener(this);
            holder.imageView.setOnClickListener(this);
        }

    }

    @Override
    public int getItemCount() {
        return seatDrawingObjects.size();
    }

    protected SeatDrawingObject getItem(int position){
        return seatDrawingObjects.get(position);
    }

    @Override
    public void onClick(View v) {
        SeatDrawingObject selected = getItem(v.getId());

        String view =     "Bus name : " + selected.getBus_name() + "\n"
                        + "Company ID : " + selected.getCompany_id() +"\n"
                        + "Bus ID :" + selected.get_id() + "\n"
                        + "Seat ID :" + v.getId();
        Toast.makeText(context, view, Toast.LENGTH_LONG).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView seatNo;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            seatNo = itemView.findViewById(R.id.adapter_seat_view_text);
            imageView = itemView.findViewById(R.id.adapter_seat_view_image);
        }
    }
}
