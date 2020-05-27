package com.eurekaClientEx2.eurekaClientEx2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HystrixCircuitControl1 {

	@Autowired
	public RestTemplate restTemplate;
	
	@HystrixCommand( 	fallbackMethod = "getFallbackCall1",
						commandProperties = {
							@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")	,
							@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5") ,
							@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "4000") ,
							@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
						})
	public String getCall1(Integer m) {
		String responseEntity = restTemplate.getForObject("http://myfirstapp/getSample?min="+m.intValue(), String.class);
		System.out.println(responseEntity);
		return responseEntity;
	}
	
	public String getFallbackCall1(Integer m) {
		return "from fallback";
	}
	
}
