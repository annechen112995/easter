package com.westwood.resti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class RoutesActivity extends AppCompatActivity {

    ArrayList<Flight> flights;
    FlightAdapter flightAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        lvItems = (ListView) findViewById(R.id.lvList);
        flights = new ArrayList<>();
        flightAdapter = new FlightAdapter(this, flights);
        lvItems.setAdapter(flightAdapter);

        Flight newFlight = new Flight("ATL", "BOM", "9/30/16");
        flightAdapter.add(newFlight);

    }

    public void onSubmit(View view) {
        Intent i = new Intent(RoutesActivity.this, BookActivity.class);
        startActivity(i);
    }

    /** JSONArray flightJsonResults = null;

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());

            flightJsonResults = obj.getJSONArray("slice");

            flights.addAll(Flight.fromJSONArray(flightJsonResults));
            flightAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("flights.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    } */


}
