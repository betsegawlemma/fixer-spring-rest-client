package com.betsegaw.fe;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatestRate {
	
	private boolean success;
	private Long timestamp;
	private String base;
	private Date date;
	private Map<String, BigDecimal> rates;	
}
