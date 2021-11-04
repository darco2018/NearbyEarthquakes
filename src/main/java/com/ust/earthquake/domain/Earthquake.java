package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Earthquake {

    private Location location;
    private Properties properties;

    public Location getLocation() {
        return location;
    }

    public Properties getProperties() {
        return properties;
    }

    @JsonCreator
    public Earthquake(@JsonProperty("geometry") Location location,
                      @JsonProperty("properties") Properties properties) {
        this.location = location;
        this.properties = properties;
    }

    public static List<EarthquakeDistance> findNearestEarthquakes(int limit, List<Earthquake> earthquakes, Location location){
        //TODO find 10 earthquakes with the smallest distance to the given city,
        //  order from the closest to the furthest.
        List<EarthquakeDistance> earthquakeDistance = new ArrayList<>();




        for (int i = 0; i < earthquakes.size(); i++){
            int dist = -1;
            Earthquake e = earthquakes.get(i);
            Location loc = e.getLocation();
            dist = Location.getDistance(loc, location);
            assert (dist >= 0);

            earthquakeDistance.add(new EarthquakeDistance(e, dist));
        }
        System.out.println(earthquakeDistance.get(0));
        System.out.println(earthquakeDistance.get(1));
        System.out.println(earthquakeDistance.get(2));
        System.out.println("earthquakeDistance size is " + earthquakeDistance.size());

        //Todo check this
        //earthquakeDistance.sort();

        Collections.sort(earthquakeDistance); // uses Comparator in EarthquakeDistance
        System.out.println(earthquakeDistance.get(1));
        System.out.println(earthquakeDistance.get(1500));
        System.out.println(earthquakeDistance.get(5000));

        return earthquakeDistance.subList(0,10);
    }


    @Override
    public String toString() {
        return location +      ", " + properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earthquake that = (Earthquake) o;
        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
