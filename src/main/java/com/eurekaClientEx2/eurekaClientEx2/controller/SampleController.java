package com.eurekaClientEx2.eurekaClientEx2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {
	
	@Autowired
	public HystrixCircuitControl1 hystrixCircuitControl1;

	@GetMapping("/getSample")
	public String getSample(@RequestParam(required = false, name = "min",  value = "min") Integer m) {
		System.out.println("Comes here 2");
		
		String responseEntity = hystrixCircuitControl1.getCall1(m);
		System.out.println(responseEntity);
		
		return "Comes here 2"+ responseEntity;
	}
	
}
