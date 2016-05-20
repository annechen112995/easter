package com.westwood.resti;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Westwood on 9/24/16.
 */
public class Flight {
    public String origin = "ATL";
    public String destination = "BOM";
    public String date = "2-16-2017";

    public Flight(String origin, String destination, String date) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    public String getRouteName() {
        return origin + " - AMS - " + destination;
    }

    public String getDate() {
        return date;
    }

    public String getOrigin() {
        return "Departs " + origin;
    }

    public String getStop() {
        return "Stopover at Amsterdam";
    }

    public String getDestination() {
        return "Arrives at " + destination;
    }

    /* public Flight(JSONObject jsonObject)throws JSONException { // ctrl-N to autocreate
        this.origin = jsonObject.getString("origin");
        this.destination = jsonObject.getString("destination");
        this.date = jsonObject.getString("date");
    }

    public String getRouteName() {
        return origin + " - AMS - " + destination;
    }

    public String getDate() {
        return date;
    }

    public String getOrigin() {
        return "Departs " + origin;
    }

    public String getStop() {
        return "Stopover at Amsterdam";
    }

    public String getDestination() {
        return "Arrives at " + destination;
    }

    public static ArrayList<Flight> fromJSONArray(JSONArray array){
        ArrayList<Flight> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++){
            try {
                results.add(new Flight(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    } */
}
