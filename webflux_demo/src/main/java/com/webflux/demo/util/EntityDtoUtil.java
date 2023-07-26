package com.webflux.demo.util;

import org.springframework.beans.BeanUtils;

import com.webflux.demo.dto.ProductDto;
import com.webflux.demo.entity.Product;

public class EntityDtoUtil { //mapper?
    
    public static ProductDto toDto(Product product){
        ProductDto dto = new ProductDto(); //builder?
        //dto.setDescription(product.getDescription());
        //dto.setId(product.getId());
        //dto.setPrice(product.getPrice());
        BeanUtils.copyProperties(product, dto); //i don't like it.. no check on fields.. just a copy
        return dto;
    }

    public static Product toEntity(ProductDto productDto){
        Product entity = new Product(); //builder?
        //dto.setDescription(product.getDescription());
        //dto.setId(product.getId());
        //dto.setPrice(product.getPrice());
        BeanUtils.copyProperties(productDto, entity); //i don't like it.. no check on fields.. just a copy
        return entity;
    }

}
