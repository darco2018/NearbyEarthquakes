package com.ust.earthquake.http;

import com.ust.earthquake.domain.Data;
import com.ust.earthquake.domain.Earthquake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*Web services for fetching Earthquakes are located here: https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php
We are interested in all earthquakes that happened during last 30 days: https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson
*/
@Service
public class RestTemplateHttpClient implements HttpClientInt {

    Logger logger = LoggerFactory.getLogger(RestTemplateHttpClient.class);

    private final RestTemplate restTemplate;
    private final String REQUEST_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";

    public RestTemplateHttpClient(RestTemplateBuilder restTemplateBuilder) {
        logger.info("Created RestTemplateHttpClient...");
        this.restTemplate = restTemplateBuilder.build();
    }

        @Override
    public List<Earthquake> fetchEarthquakes() {
            //TODO Fetch a list of earthquakes that happened during last 30 days
            // If two earthquakes happened in exactly the same location (they have the same lat/lon)
            // we only want one of them to be printed
            Data data = null;
            try {
                 data = this.restTemplate.getForObject(REQUEST_URL, Data.class);
            } catch (Exception e){
                logger.error("Failed to fetch data from " + REQUEST_URL );
                 e.getStackTrace();
            }

        return  Objects.isNull(data) ?
               new ArrayList<>() : Arrays.asList(data.getEarthquakes());
    }
}
