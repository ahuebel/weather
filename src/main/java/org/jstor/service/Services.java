package org.jstor.service;

import java.util.List;

import org.jstor.domain.WeatherReport;

public interface Services {
	WeatherReport getWeatherForNextSevenDays(List<String> zips);
}
