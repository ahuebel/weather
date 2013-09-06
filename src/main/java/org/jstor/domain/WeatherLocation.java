package org.jstor.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement
public class WeatherLocation {

	String zipCode;
	List<WeatherData> weatherData;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<WeatherData> getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(List<WeatherData> weatherData) {
		this.weatherData = weatherData;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
