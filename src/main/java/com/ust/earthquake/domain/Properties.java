package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

    private final String title;
    // other properties are ignored

    @JsonCreator
    public Properties(@JsonProperty("title") String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
