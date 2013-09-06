package org.jstor.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jstor.domain.WeatherReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import org.jstor.service.ServiceImpl;

@RunWith( SpringJUnit4ClassRunner.class )  
@ContextConfiguration( "classpath:test-context.xml" )  
public class TestServiceImpl {
	
	@Test
	public void testGetWeatherForNextSevenDays() {
		List<String>zips= new ArrayList<String>();
		zips.add("48843");
		zips.add("48108");
		ServiceImpl s = new ServiceImpl();
		WeatherReport wr = s.getWeatherForNextSevenDays(zips);
		assertNotNull(wr);  
	}

}
