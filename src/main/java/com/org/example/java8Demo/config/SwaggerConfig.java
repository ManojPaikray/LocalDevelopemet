package com.org.example.java8Demo.config;

import org.springframework.beans.factory.annotation.Value;

public class SwaggerConfig {
	@Value("${apidetails.title}")
	private String title;
	
	@Value("${apidetails.description}")
	private String description;
	
	@Value("${apidetails.email}")
	private String email;
	
	@Value("${apidetails.url}")
	private String url;
	
	@Value("${apidetails.license}")
	private String license;
	
	@Value("${apidetails.licenseUrl}")
	private String licenseUrl;
	
	@Value("${apidetails.name}")
	private String name;
	
	@Value("${apidetails.terms-of-service}")
	private String termsOfService;
	
	@Value("${apidetails.version}")
	private String version;
}
