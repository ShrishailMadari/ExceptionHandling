package com.shyloostyle.consumer.service;

import com.shyloostyle.consumer.binding.Quote;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuoteService {
    private final RestTemplate restTemplate;

    public QuoteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Quote> getQuotes(){
        String url = "https://dummyjson.com/quotes/random";
        QuoteResponse response= restTemplate.getForObject(url, QuoteResponse.class);
        return response != null ? response.getQuotes(): List.of();
    }
    // Inner class to represent the API response
    private static class QuoteResponse {
        private List<Quote> quotes;

        public List<Quote> getQuotes() {
            return quotes;
        }

        public void setQuotes(List<Quote> quotes) {
            this.quotes = quotes;
        }
    }

}
