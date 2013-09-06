package org.jstor.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement
public class WeatherData {
	Date date;
	BigInteger high;
	BigInteger low;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigInteger getHigh() {
		return high;
	}
	public void setHigh(BigInteger high) {
		this.high = high;
	}
	public BigInteger getLow() {
		return low;
	}
	public void setLow(BigInteger low) {
		this.low = low;
	}
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
