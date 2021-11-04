package com.ust.earthquake.domain;

public class EarthquakeDistance implements Comparable<EarthquakeDistance> {
    public Earthquake getEarthquake() {
        return earthquake;
    }

    private Earthquake earthquake;
    private int distance;

       public EarthquakeDistance(Earthquake earthquake, int distance) {
        this.earthquake = earthquake;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return earthquake + ", dist: " + distance;
    }

    @Override
    public int compareTo(EarthquakeDistance o) {
        return this.distance - o.distance;
    }
}
