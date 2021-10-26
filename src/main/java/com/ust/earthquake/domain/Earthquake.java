package com.ust.earthquake.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Earthquake {

    private Location location;
    private String title;

    public Earthquake(Location location, String info) {
        this.location = location;
        this.title = info;
    }

    public List<Earthquake> findNearestEarthquakes(int count, List<Earthquake> earthquakes, Location location){
        //TODO find 10 earthquakes with the smallest distance to the given city,
        //  order from the closest to the furthest.

        return new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
