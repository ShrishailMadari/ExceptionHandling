package com.shyloostyle.resapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
// produces="text/plain" : in which format provider sending the data
    @GetMapping(value = "/wellcome",produces = "text/plain"/*it means this method is returning plain text to the consume*/) //this makes this method as distributed method
    public String getWellcome(){
//        using this method we are letting the controller to handle the response to framework
//        status code in framed/handled by framework
        return "wellcome";
    }
    @GetMapping(value = "/greets",produces = "text/plain")
    public ResponseEntity<String> getGreetMessage(){
//        ResponseEntity using this cause constructing the response packet
//        status code is handled by the programmer
        String responseBody = "Good Morning rest.........";
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
