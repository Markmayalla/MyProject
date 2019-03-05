package tz.co.comptech.m_safariproduction.Adapter.Region;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import tz.co.comptech.m_safariproduction.Model.AutoCompleteRegion;
import tz.co.comptech.m_safariproduction.R;

public class AutoCompleteRegionAdapter extends ArrayAdapter<AutoCompleteRegion> {

    private Context context;
    private int resourceId;
    private ArrayList<AutoCompleteRegion> items, tempItems, suggestions;

    public AutoCompleteRegionAdapter(@NonNull Context context, int resource, @NonNull ArrayList<AutoCompleteRegion> items) {
        super(context, resource, items);
        this.context = context;
        this.resourceId = resource;
        this.items = items;
        this.tempItems = new ArrayList<>(items);
        this.suggestions = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.adapter_region_autocomplete, parent, false);
            }
            AutoCompleteRegion AutoCompleteRegion = getItem(position);
            TextView name = (TextView) view.findViewById(R.id.adapter_region_autocomplete_name);
            name.setText(AutoCompleteRegion.getName());
            //Log.e("adapter", "kk " + AutoCompleteRegion.getName() );

        return view;
    }

    @Nullable
    @Override
    public AutoCompleteRegion getItem(int position) {
        return items.get(position);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return AutoCompleteRegionFilter;
    }

    private Filter AutoCompleteRegionFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            AutoCompleteRegion AutoCompleteRegion = (AutoCompleteRegion) resultValue;
            return AutoCompleteRegion.getName();
        }
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence != null) {
                suggestions.clear();
                for (AutoCompleteRegion AutoCompleteRegion: tempItems) {
                    if (AutoCompleteRegion.getName().toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        suggestions.add(AutoCompleteRegion);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            ArrayList<AutoCompleteRegion> tempValues = (ArrayList<AutoCompleteRegion>) filterResults.values;
            if (filterResults != null && filterResults.count > 0) {
                clear();
                for (AutoCompleteRegion AutoCompleteRegionObj : tempValues) {
                    add(AutoCompleteRegionObj);
                    notifyDataSetChanged();
                }
            } else {
                clear();
                notifyDataSetChanged();
            }
        }
    };
}
