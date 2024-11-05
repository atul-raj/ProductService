package com.atul.productservice.dtos;

import lombok.Data;

@Data
public class FakeProductServiceDTO {


    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;

}
