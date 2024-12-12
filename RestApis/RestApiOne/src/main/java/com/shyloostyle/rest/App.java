package com.shyloostyle.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.convertJavaObjToJson();
        app.convertJsonToJavaObject();
    }

    private void convertJsonToJavaObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(new File("customer.json"), Customer.class);
        System.out.println(customer);
    }

    public void convertJavaObjToJson() throws Exception{
        Customer customer = new Customer();
        customer.setcId(100);
        customer.setName("Ashok");
        customer.setPhoneNo(12345L);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("customer.json"),customer);

        System.out.println("message completed...");
    }
}
