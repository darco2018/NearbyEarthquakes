package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Earthquake {

    private Location location;
    private Properties properties;

    @JsonCreator
    public Earthquake(@JsonProperty("geometry") Location location,
                      @JsonProperty("properties") Properties properties) {
        this.location = location;
        this.properties = properties;
    }

    public List<Earthquake> findNearestEarthquakes(int count, List<Earthquake> earthquakes, Location location){
        //TODO find 10 earthquakes with the smallest distance to the given city,
        //  order from the closest to the furthest.

        return new ArrayList<>();
    }


}
