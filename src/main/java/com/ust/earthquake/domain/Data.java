package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class Data {

    // type
    // metadata
    Earthquake[] earthquakes;

    @JsonCreator
    public Data(@JsonProperty("features") Earthquake[] earthquakes) {
        this.earthquakes = earthquakes;
    }

    public Earthquake[] getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(Earthquake[] earthquakes) {
        this.earthquakes = earthquakes;
    }

    @Override
    public String toString() {
        String result = "";

        /*List list = Arrays.asList(earthquakes);
        list.forEach(e -> result + e.toString() + "\n";*/
        // TODO figure out how to print it with lambdas

        for (Earthquake earthquake : earthquakes) {
            result+= earthquake.toString() + "\n";
        }

        return result + "Fetched " + earthquakes.length + " earthquakes";
    }
}
