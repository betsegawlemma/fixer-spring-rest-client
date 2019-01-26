package com.betsegaw.fe;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ForeignExchangeRestClient {
	
	private final String API_ACCESS_KEY = "18c3928d0dede32f6ddc0d1369bf3513";

	private RestTemplate restTemplate;

	public ForeignExchangeRestClient(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;		
	}
	
	public LatestRate latestRate() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://data.fixer.io/api/latest")
				.queryParam("access_key", API_ACCESS_KEY);		
		return restTemplate.getForObject(builder.toUriString(), LatestRate.class);
	}
	
}
