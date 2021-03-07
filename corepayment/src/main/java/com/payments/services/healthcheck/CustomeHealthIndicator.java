package com.payments.services.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CustomeHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		boolean error = true;
		if(error) {
			return Health.down().withDetail("Error Key", 123).build();
		} else {
			return Health.up().build();
		}		
	}

}
