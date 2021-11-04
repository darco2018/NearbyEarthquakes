package com.ust.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


/*https://gps-coordinates.org/coordinate-converter.php
 * https://gps-coordinates.org/distance-between-cities.php
 * https://www.geodatasource.com/developers/java
 * https://www.latlong.net/*/

public class Location {
    private double[] coordinates;

    @JsonCreator
    public Location(@JsonProperty("coordinates") double[] coordinates) {
        this.coordinates = coordinates;
    }

    // This code is contributed by Prasad Kshirsagar
    // https://www.geeksforgeeks.org/program-distance-two-points-earth/
    public static int getDistance(Location loc1, Location loc2){
        //TODO implement distance between 2 locations
        // We would like each distance to be rounded to full kilometers
        double lat1 = loc1.getLatitude();
        double lon1 = loc1.getLongitude();
        double lat2 = loc2.getLatitude();
        double lon2 = loc2.getLongitude();

            // The math module contains a function
            // named toRadians which converts from
            // degrees to radians.
            lon1 = Math.toRadians(lon1);
            lon2 = Math.toRadians(lon2);
            lat1 = Math.toRadians(lat1);
            lat2 = Math.toRadians(lat2);

            // Haversine formula
            double dlon = lon2 - lon1;
            double dlat = lat2 - lat1;
            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(lat1) * Math.cos(lat2)
                    * Math.pow(Math.sin(dlon / 2),2);

            double c = 2 * Math.asin(Math.sqrt(a));

            // Radius of earth in kilometers. Use 3956
            // for miles
            double r = 6371;

            // calculate the result
            return (int) (c * r);

    }


        public static int getDistance(double lat1, double lon1, double lat2, double lon2, String unit) { //"K" for km
            if ((lat1 == lat2) && (lon1 == lon2)) {
                return 0;
            }
            else {
                double theta = lon1 - lon2;
                double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
                dist = Math.acos(dist);
                dist = Math.toDegrees(dist);
                dist = dist * 60 * 1.1515;
                if (unit.equals("K")) {
                    dist = dist * 1.609344;
                } else if (unit.equals("N")) {
                    dist = dist * 0.8684;
                }
                return (int) dist;
            }

    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getLatitude() {
        return this.coordinates[0];
    }

     public double getLongitude() {
        return this.coordinates[1];
    }

    @Override
    public String toString() {
        return Arrays.toString(coordinates);
    }
}
