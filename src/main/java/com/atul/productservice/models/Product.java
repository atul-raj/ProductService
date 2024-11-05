package com.atul.productservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    Long id;
    String name;
    String description;
    Double price;
    Category category;

}
