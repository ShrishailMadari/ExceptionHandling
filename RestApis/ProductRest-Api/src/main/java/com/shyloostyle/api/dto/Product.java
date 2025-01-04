package com.shyloostyle.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Product {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double price;
}
