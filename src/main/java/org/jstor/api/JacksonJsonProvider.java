package org.jstor.api;

import com.wordnik.swagger.core.util.JsonUtil;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.databind.*;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
	private static ObjectMapper commonMapper = null;

	public JacksonJsonProvider() {
		if(commonMapper == null){
		    ObjectMapper mapper = new ObjectMapper();

		    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		    mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
		    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		    
		    commonMapper = mapper;
		}
		super.setMapper(commonMapper);
	}
	
	
}
