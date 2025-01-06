package com.shyloostyle.consumer.controller;

import com.shyloostyle.consumer.binding.Quote;
import com.shyloostyle.consumer.service.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/api")
public class QuotesController {
    private final QuoteService quoteService;

    public QuotesController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes")
    public String getQuotes(Model model){
        List<Quote> quotes = quoteService.getQuotes();
        model.addAttribute("quotes",quotes);
        return "quotes";
    }
}
