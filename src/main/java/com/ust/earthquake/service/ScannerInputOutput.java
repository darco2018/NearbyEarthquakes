package com.ust.earthquake.service;

import com.ust.earthquake.domain.Earthquake;
import com.ust.earthquake.domain.Location;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ScannerInputOutput implements InputOutputInt {

    @Override
    public Location getInputLocation() {
        //TODO implement: Read two float numbers from standard input that represent the lat/lon of a city
        /*Example Input:
            ```
            40.730610
            -73.935242
            ```
         */
        double latitude = -1;
        double longitude = -1;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter latitude: ");
             latitude = scanner.nextDouble();
            System.out.println("Latitude is " + latitude);
            System.out.println("Enter longitude: ");
            longitude = scanner.nextDouble();
            System.out.println("Longitude is " + longitude);
        } catch (Exception e) {
            System.out.println("You didn't enter a double correctly. Please, restart the program!");
        }

        return new Location(new double[]{latitude, longitude});
    }

    @Override
    public void printNearestEarthquakes(List<Earthquake> earthquakes) {
        //TODO Print the 10 earthquakes with the smallest distance to the given city.
        // The output list should contain earthquake title and distance in kilometers
        // For each earthquake we want to print the content of a **title** field followed by || and **distance** in full km.

        /*
            M 1.3 - 2km SSE of Contoocook, New Hampshire || 331
            M 1.3 - 2km ENE of Belmont, Virginia || 354
            M 2.4 - 83km ESE of Nantucket, Massachusetts || 406
            M 1.3 - 13km ENE of Barre, Vermont || 410
            M 0.7 - 18km NW of Norfolk, New York || 476
            M 2.0 - 17km NW of Norfolk, New York || 476
            M 1.7 - 19km NNW of Beaupre, Canada || 758
            M 1.9 - 13km SW of La Malbaie, Canada || 814
            M 2.4 - 16km N of Lenoir, North Carolina || 840
            M 2.4 - 12km ESE of Carlisle, Kentucky || 896
          */

    }
}
