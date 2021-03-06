package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarthquakeJSONData {

    // type
    // metadata
    Earthquake[] earthquakes;

    @JsonCreator
    public EarthquakeJSONData(@JsonProperty("features") Earthquake[] earthquakes) {
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

        /*List list = Arrays.asList(earthquakes);
        list.forEach(e -> result + e.toString() + "\n";*/
        // TODO figure out how to print it with lambdas

        StringBuilder result = new StringBuilder();
        for (Earthquake earthquake : earthquakes) {
            result.append(earthquake.toString()).append("\n");
        }

        return result + "Fetched " + earthquakes.length + " earthquakes";
    }
}
