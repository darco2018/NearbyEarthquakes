package com.ust.earthquake.domain;

import com.ust.earthquake.service.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/*https://gps-coordinates.org/coordinate-converter.php
 * https://gps-coordinates.org/distance-between-cities.php
 * https://www.geodatasource.com/developers/java
 * https://www.latlong.net/*/
class LocationTest {

    private Location cracow = new Location(new double[]{50.0592844, 19.9367797});
    private Location warsaw = new Location(new double[]{52.2431744, 21.0018102});
    private final int cracowWarsawDistanceInKilometers = 253;

    @Test
    void getDistanceWithLocations() {
        int actual = Utils.getDistance(cracow, warsaw);
        assertEquals(cracowWarsawDistanceInKilometers,actual);
    }


    @Test
    void getDistanceWithCoordinates() {
        int actual = Utils.getDistance(cracow.getLatitude(),cracow.getLongitude(),warsaw.getLatitude(),
                warsaw.getLongitude(), "K");
        assertEquals(cracowWarsawDistanceInKilometers,actual);
    }
}