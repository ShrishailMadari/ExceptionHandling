package com.shyloostyle.Rest_Consumer;

import com.shyloostyle.Rest_Consumer.model.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestConsumerApplication {

    public static void main(String[] args) {

		SpringApplication.run(RestConsumerApplication.class, args);


		String url = "https://api.restful-api.dev/objects/";
//		it is args pre-defined class present in mvc
		RestTemplate restTemplate = new RestTemplate();
//		getForEntity means consumer is sending get request to the provider url
		ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
		System.out.println(forEntity.getBody());
		System.out.println(forEntity.getStatusCode().value());

		consumerApiForRandomUrl();
	}

	private static void consumerApiForRandomUrl() {
		String url = "https://dummyjson.com/quotes/random";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
		ResponseEntity<Quote> forEntityWithQuote = restTemplate.getForEntity(url, Quote.class);
		System.out.println(forEntityWithQuote.getBody());
		System.out.println(forEntity.getBody());
		System.out.println(forEntity.getStatusCode().value());

	}

}
