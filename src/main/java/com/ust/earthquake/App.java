package com.ust.earthquake;

import com.ust.earthquake.domain.Earthquake;
import com.ust.earthquake.domain.EarthquakeDistance;
import com.ust.earthquake.domain.Location;
import com.ust.earthquake.http.HttpClientInt;
import com.ust.earthquake.http.RestTemplateHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(App.class, args);

        // get input
		/*ScannerInputOutput input = new ScannerInputOutput();
		Location location = input.getInputLocation();
		logger.info("You have entered these coordinates: " + location);*/

        // get data by http & unmarshall it
        logger.info("Create HttpClient....");
        HttpClientInt client = applicationContext.getBean(RestTemplateHttpClient.class);
        //TODO test if httpclient is working string.size() > 0?

        logger.info("Fetching all earthquakes. Can take some time...");
        List<Earthquake> earthquakes = client.fetchEarthquakes();
        logger.info("Fetching complete");

        earthquakes = removeDuplicateEarthquakes(earthquakes);

        if (earthquakes.size() > 0) {
            printEarthquakes(earthquakes);
            logger.info("Earthquakes in the last 30 days: " + earthquakes.size());
        }

        Location cracow = new Location(new double[]{50.0592844, 19.9367797});
        List<EarthquakeDistance> nearest = Earthquake.findNearestEarthquakes(10, earthquakes, cracow);

        printEarthquakesWithDistance(nearest);
    }

    private static void printEarthquakes(List<Earthquake> earthquakes) {
        String earthquakeString = "";
        for (Earthquake earthquake : earthquakes) {
            earthquakeString += earthquake.toString() + "\n";
        }
        logger.info("\n" + earthquakeString);
    }

    private static void printEarthquakesWithDistance(List<EarthquakeDistance> earthquakes) {
        String earthquakeString = "\n\n" + "Nearest earthquaqes:\n";
        for (EarthquakeDistance edist : earthquakes) {
            earthquakeString += edist.toString() + "\n";
        }
        logger.info("\n" + earthquakeString);
    }

    private static List<Earthquake> removeDuplicateEarthquakes(List<Earthquake> earthquakes) {
        Set<Earthquake> noDuplicates = new HashSet<>(earthquakes);
        System.out.println(">>>>>>>>>> noDuplicates: " + noDuplicates.size());
        //SortedSet<Earthquake> noDuplicates2 = new TreeSet<>(earthquakes);

        return new ArrayList<>(noDuplicates);
    }

}
