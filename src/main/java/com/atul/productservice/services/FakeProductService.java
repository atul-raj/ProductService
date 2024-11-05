package com.atul.productservice.services;

import com.atul.productservice.dtos.FakeProductServiceDTO;
import com.atul.productservice.models.Category;
import com.atul.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class FakeProductService implements ProductService {
    RestTemplate restTemplate ;

    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductByID(Long id) {

FakeProductServiceDTO fakeProductServiceDTO = restTemplate.getForObject("https://fakestoreapi.com/products/1" +id, FakeProductServiceDTO.class);
        assert fakeProductServiceDTO != null;
        return convertFakeProductSeriveDTOToProduct(fakeProductServiceDTO) ;
    }

    private Product convertFakeProductSeriveDTOToProduct(FakeProductServiceDTO fakeProductServiceDTO) {
        Product product = new Product();
        product.setId(fakeProductServiceDTO.getId());
        product.setName(fakeProductServiceDTO.getTitle());
        product.setPrice(fakeProductServiceDTO.getPrice());
        product.setDescription(fakeProductServiceDTO.getDescription());

        Category category = new Category();
        category.setId(new Random().nextLong());
        category.setName(fakeProductServiceDTO.getCategory());
        product.setCategory(category);


        return product;
    }
}
