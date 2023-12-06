package com.example.gateawayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GateawayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateawayServiceApplication.class, args);
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient reactiveDiscoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties){
		return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient,discoveryLocatorProperties);
	}
}
