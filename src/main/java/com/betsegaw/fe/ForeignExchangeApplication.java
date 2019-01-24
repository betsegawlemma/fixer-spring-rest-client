package com.betsegaw.fe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ForeignExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForeignExchangeApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public CommandLineRunner latestRate(ForeignExchangeRestClient foreignExchangeRestClient) {
		return args -> {
			log.info("Latest Euro to Birr rate");
			log.info("1 Euro is: "+foreignExchangeRestClient.latestRate("ETB").getRates().get("ETB")+"Birr");
			log.info("Latest Euro to Dollar rate");
			log.info("1 Euro is: "+foreignExchangeRestClient.latestRate("USD").getRates().get("USD")+"$");
		};
	}

}

