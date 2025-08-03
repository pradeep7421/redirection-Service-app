package com.ps.redirection.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class RedirectionServiceController {
	 private RestTemplate restTemplate;
	 private String tinyUrlServiceBaseUrl;
	 
		public RedirectionServiceController(RestTemplate restTemplate,
				@Value("${tiny.url.service.url}") String tinyUrlServiceBaseUrl) {
			this.restTemplate = restTemplate;
			this.tinyUrlServiceBaseUrl = tinyUrlServiceBaseUrl;
		}
	 
	@GetMapping("{shortKey}")
	public ResponseEntity<String> getShortURL(@PathVariable("shortKey") String shortKey) {
		String originalUrl = restTemplate.getForObject(tinyUrlServiceBaseUrl + shortKey, String.class);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(originalUrl));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
	}
}
