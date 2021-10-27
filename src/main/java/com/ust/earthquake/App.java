package com.ust.earthquake;

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

@SpringBootApplication
public class App {

	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);

		/*logger.info("Loaded AppContext. Calling HttpClient....");
		HttpClientInt client = applicationContext.getBean(RestTemplateHttpClient.class);
		System.out.println(client.fetchEarthquakes());*/

		/*ScannerInputOutput input = new ScannerInputOutput();
		Location location = input.getInputLocation();
		logger.info("Location entered is " + location);*/

		Location cracow = new Location(new double[]{50.0592844, 19.9367797});
		Location warsaw = new Location(new double[]{52.2431744, 21.0018102});
		System.out.println(Location.getDistance(cracow,warsaw));
		System.out.println(Location.distanceTwo(cracow.getLatitude(),cracow.getLongitude(),warsaw.getLatitude(),
				warsaw.getLongitude(), "K"));
	}

}
