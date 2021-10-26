package com.ust.earthquake.service;

import com.ust.earthquake.domain.Earthquake;
import com.ust.earthquake.domain.Location;

import java.util.List;

public interface InputOutputInt {

    public Location getInputLocation();
    public void printNearestEarthquakes(List<Earthquake> earthquakes);
}
