package com.testvagrant.weather_report.weatherLocation;

import java.util.Comparator;

import lombok.Setter;

@Setter
public class Celsius implements Comparator<WeatherLocation> {
	private int range;

	public int compare(WeatherLocation uiWeather, WeatherLocation apiWeather) {
		if (uiWeather.getCelsius() == apiWeather.getCelsius())
			return 0;
		else if (((uiWeather.getCelsius() + range) == apiWeather.getCelsius())
				|| ((uiWeather.getCelsius() - range) == apiWeather.getCelsius()))
			return 1;
		else
			return -1;

	}	

}
