package org.jstor.api;

import org.jstor.model.ComplexType;
import org.jstor.service.Services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import org.jstor.api.NotFoundException;
import org.jstor.domain.WeatherReport;


/**
 * the generated API
 */
@Component
public class GeneratedApiWorker {

	@Autowired
	Services weatherService;

  public GeneratedApiWorker(){
    
  }

  /**
   * run a GET with an integer in the path
   *
   * 
   * 
   * @return ComplexType response
   */
  
  public ComplexType path(
    Integer pathinput
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return null;
  }

  /**
   * run a GET with ?queryinput=string
   *
   * 
   * 
   * @return ComplexType response
   */
  
  public ComplexType param(
    Integer queryinput
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return null;
  }

	public ComplexType param(String zip, String type,
			HttpServletRequest request, HttpServletResponse response)
			throws NotFoundException {

		WeatherReport wr = new WeatherReport();
		ModelAndView mav = new ModelAndView("ShowWeather");
		String[] zips = zip.split(",");
		List<String> strs = new ArrayList<String>();

		for (int i = 0; i < zips.length; i++) {
			strs.add(zips[i]);
		}

		wr = weatherService.getWeatherForNextSevenDays(strs);

		if (type != null) {
			if (type.compareTo("XML") == 0) {
				mav.addObject("weatherReport",
						wr.toXml(wr, WeatherReport.class));
			}
			if (type.compareTo("JSON") == 0) {
				mav.addObject("weatherReport", wr.toString());
			}

		} else
			mav.addObject("weatherReport", wr.toString());
		
		ComplexType ct = new ComplexType();
		
		// return mav;

		return null;
	}
  
  /**
   * POSTing will use the body as an input object
   *
   * 
   * 
   * @return Boolean response
   */
  
  public Boolean body(
    ComplexType body
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return null;
  }

  }

