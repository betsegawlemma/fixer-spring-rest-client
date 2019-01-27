package com.betsegaw.fe;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ForeignExchangeRestClient {
	
	private final String API_ACCESS_KEY = "c78d1728a68ff4e023217d10f6a3dd3e";

	private RestTemplate restTemplate;

	public ForeignExchangeRestClient(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;		
	}
	
	
	public LatestRate latestRate(String symbols) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://data.fixer.io/api/latest")
				.queryParam("access_key", API_ACCESS_KEY)
				.queryParam("symbols", symbols);
		
		return restTemplate.getForObject(builder.toUriString(), LatestRate.class);
	}
	
}
