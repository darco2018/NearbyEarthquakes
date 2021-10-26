package com.ust.earthquake.http;

import com.ust.earthquake.domain.Earthquake;
import java.util.List;

public interface HttpClientInt {

    public List<Earthquake> fetchEarthquakes(double latitude, double longitude);
}
