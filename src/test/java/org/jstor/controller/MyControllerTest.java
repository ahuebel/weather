package org.jstor.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-context.xml"})
public class MyControllerTest {
	private MockRestServiceServer mockServer;

	private RestTemplate restTemplate;

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
//	@Autowired
//	private MyController myController;
//	public void setMyController(MyController c){
//		this.myController = c;
//	}

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		this.restTemplate = new RestTemplate();
		this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
		
	}
	
	@Test
	public void testMyController() {
//		assertNotNull(myController.simpleExample(1));
//		assertNotNull(myController.viewExample(2));
//		assertNotNull(myController.asyncExample(3));
	}

}
