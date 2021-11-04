package com.ust.earthquake;

import com.ust.earthquake.domain.Earthquake;
import com.ust.earthquake.domain.Location;
import com.ust.earthquake.http.HttpClientInt;
import com.ust.earthquake.http.RestTemplateHttpClient;
import com.ust.earthquake.service.ScannerInputOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

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

		 // print if earthquakes non zero /////////////////////
		if(earthquakes.size() > 0){
			String earthquakeString = "";
			for (Earthquake earthquake : earthquakes) {
				earthquakeString += earthquake.toString() + "\n";
			}
			logger.info("\n" +earthquakeString);
			logger.info("Earhquakes in the last 30 days: " + earthquakes.size());
		}
		 //////////////////////////////////////////////////////

		 logger.info("Fetching complete");

		// process data to get 10 nearest without duplicates

		// sort 10 nearest
		 Location cracow = new Location(new double[]{50.0592844, 19.9367797});
		 List<Earthquake> nearest = Earthquake.findNearestEarthquakes(1000, earthquakes, cracow);

		// 	print result



	}

}
