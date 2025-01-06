package com.shyloostyle.Consumer;

import com.shyloostyle.Consumer.model.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class RestConsumerWebClientApplication {




    public static void main(String[] args) {

		SpringApplication.run(RestConsumerWebClientApplication.class, args);
		getRandomquoteObj();
		getRandomQuote();
		getRandomquoteObjSubscribe();
		System.out.println("taking time");

	}
	private static void getRandomQuote(){
		String url = "https://dummyjson.com/quotes/random";

		WebClient webClient = WebClient.create(); /* it is used to create the webclient interface implementation obj*/
//        sending get request with synch approach
		Mono<String> response = webClient.get()/*used to send the get request*/
				.uri(url) /*to which url you want to send the get request*/
				.retrieve() /*whatever the response coming from the api we retrieve response packet*/
				.bodyToMono(String.class);/*map tht response body to some type of variable, it is going to return single object*/

//        to get the single response in one short then go for mono
//        to get response continuously with time delay go for monoFlux
//        make synch call
//
		String result = response.block();
		System.out.println(result);
	}
	private static void getRandomquoteObj() {
		WebClient webClient = WebClient.create();
		String url = "https://dummyjson.com/quotes/random";
		Mono<Quote> objectMono = webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(Quote.class);
		Quote block = objectMono.block();
		System.out.println(block);
	}

	private static void getRandomquoteObjSubscribe() {
		/*this is async process*/
		WebClient webClient = WebClient.create();
		String url = "https://dummyjson.com/quotes/random";
		Mono<Quote> objectMono = webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(Quote.class);
		objectMono.subscribe(System.out::println); /*whenever the response comes we are storing that into
		subscriber and then using it*/
	}


}
