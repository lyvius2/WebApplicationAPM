package com.walter.front.config;

import feign.Feign;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.exemplars.tracer.otel_agent.OpenTelemetryAgentSpanContextSupplier;
import org.springframework.cloud.openfeign.FeignCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusConfiguration {
	@Bean
	public OpenTelemetryAgentSpanContextSupplier openTelemetryAgentSpanContextSupplier() {
		return new OpenTelemetryAgentSpanContextSupplier();
	}

	@Bean
	public Feign.Builder feignBuilder(MeterRegistry meterRegistry) {
		return FeignCircuitBreaker.builder().addCapability(new MicrometerCapability(meterRegistry));
	}
}
