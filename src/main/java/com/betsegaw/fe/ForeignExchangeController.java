package com.betsegaw.fe;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ForeignExchangeController {
	
	ForeignExchangeRestClient foreignExchangeRestClient;
	
	public ForeignExchangeController(ForeignExchangeRestClient foreignExchangeRestClient){
		this.foreignExchangeRestClient = foreignExchangeRestClient;
	}
	
	@ModelAttribute("rates")
	public Map<String, BigDecimal> rates(){
		return foreignExchangeRestClient.latestRate().getRates();
	}
	
	@GetMapping(path="/")
	public String home() {
		log.info(foreignExchangeRestClient.latestRate().toString());
		return "home";
	}

}
