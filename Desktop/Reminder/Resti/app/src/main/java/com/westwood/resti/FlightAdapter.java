package com.westwood.resti;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Westwood on 9/24/16.
 */
public class FlightAdapter extends ArrayAdapter<Flight> {

    public FlightAdapter(Context context, ArrayList<Flight> flights) {
        super(context, R.layout.item_routes, flights);
    }

    private static class ViewHolder {
        TextView tvRouteName, tvCompany, tvDLabel, tvALabel, tvLay, tvSLabel;
        TextView tcDepart, tcStop, tcArrive;
        Button btnBook;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // here's access to the data from before. here's some data, match up the data and view and return the view

        // Get the data item for this position
        Flight flight = getItem(position);

        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_routes, parent, false);
            viewHolder.tcDepart = (TextView) convertView.findViewById(R.id.tcDepart);
            viewHolder.tcStop = (TextView) convertView.findViewById(R.id.tcStop);
            viewHolder.tcArrive = (TextView) convertView.findViewById(R.id.tcArrive);
            viewHolder.tvRouteName = (TextView) convertView.findViewById(R.id.tvRouteName);
            viewHolder.tvCompany = (TextView) convertView.findViewById(R.id.tvCompany);
            viewHolder.tvDLabel = (TextView) convertView.findViewById(R.id.tvDLabel);
            viewHolder.tvALabel = (TextView) convertView.findViewById(R.id.tvALabel);
            viewHolder.tvLay = (TextView) convertView.findViewById(R.id.tvLay);
            viewHolder.tvSLabel = (TextView) convertView.findViewById(R.id.tvSLabel);
            convertView.setTag(viewHolder);
        } // inflates that xml. creates a representation in memory so we can access it
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.tvRouteName.setText(flight.getRouteName());
        viewHolder.tvDLabel.setText(flight.getOrigin());
        viewHolder.tvALabel.setText(flight.getStop());
        viewHolder.tvSLabel.setText(flight.getDestination());

        // Return the completed view to render on screen
        return convertView;
    }

}
