package com.betsegaw.fe;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ForeignExchangeRestClient {
	
	private final String API_ACCESS_KEY = "4f2f2232957061cd29e84bb11e2ff5f9";

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
