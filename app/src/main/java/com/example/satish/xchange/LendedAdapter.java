package com.example.satish.xchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SATISH on 4/8/2016.
 */
public class LendedAdapter extends ArrayAdapter<DataObject> {
    public LendedAdapter(Context context , ArrayList<DataObject> data)
    {
        super(context , 0 , data);
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent)
    {
        // Get the data item for this position
        DataObject dat = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lended_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.t4_lended);
        TextView tvItem = (TextView) convertView.findViewById(R.id.t5_lended);
        TextView tvType = (TextView) convertView.findViewById(R.id.t6_lended);
        // Populate the data into the template view using the data object
        tvName.setText(dat.name);
        tvItem.setText(dat.item);
        tvType.setText(dat.type);
        // Return the completed view to render on screen
        return convertView;
    }
}
