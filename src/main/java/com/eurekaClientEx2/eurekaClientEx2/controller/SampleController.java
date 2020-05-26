package com.eurekaClientEx2.eurekaClientEx2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {
	
	@Autowired
	public RestTemplate restTemplate;

	@GetMapping("/getSample")
	public String getSample() {
		System.out.println("Comes here 2");
		
		String responseEntity = restTemplate.getForObject("http://myfirstapp/getSample/", String.class);
		System.out.println(responseEntity);
		
		return "Comes here 2"+ responseEntity;
	}
	
}
