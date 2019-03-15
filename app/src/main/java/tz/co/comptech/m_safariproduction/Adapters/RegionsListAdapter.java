package tz.co.comptech.m_safariproduction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import tz.co.comptech.m_safariproduction.Model.BusCenter;
import tz.co.comptech.m_safariproduction.R;
import tz.co.comptech.m_safariproduction.Room.DB.MsafariDB;
import tz.co.comptech.m_safariproduction.Room.Dao.CenterDao;

public class RegionsListAdapter extends ArrayAdapter {

    private CenterDao centerDao;

    private List<BusCenter> centers;
    private Context context;
    private int listItemLayout;

    private RegionsListAdapter.ListFilter filter = new RegionsListAdapter.ListFilter();

    public RegionsListAdapter(Context context, int listItemLayout, List<BusCenter> centers) {
        super(context, listItemLayout, centers);
        this.context = context;
        this.centers = centers;
        this.listItemLayout = listItemLayout;
    }

    @Override
    public int getCount() {
        return centers.size();
    }

    @Nullable
    @Override
    public BusCenter getItem(int position) {
        return centers.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        }

        TextView suggestion = (TextView) convertView.findViewById(R.id.suggestion);
        suggestion.setText(getItem(position).getName());

        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    public class ListFilter extends Filter {

        private Object lock = new Object();

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0) {
                synchronized (lock) {
                    results.values = new ArrayList<>();
                    results.count = 0;
                }
            } else {
                final String searchString = constraint.toString().toLowerCase();

                //Call to database Using Room to get Similar Results
                MsafariDB db = MsafariDB.getDatabase(context);
                centerDao = db.centerDao();
                List<BusCenter> matches = centerDao.getCentersBy(searchString);

                results.values = matches;
                results.count = matches.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results != null) {
                centers = (List<BusCenter>) results.values;
            } else  {
                centers = null;
            }

            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }

}
