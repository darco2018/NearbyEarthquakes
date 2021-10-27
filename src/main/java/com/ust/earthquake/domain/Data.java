package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
