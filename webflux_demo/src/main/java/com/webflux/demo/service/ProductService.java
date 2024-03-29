package com.webflux.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webflux.demo.dto.ProductDto;
import com.webflux.demo.repository.ProductRepository;
import com.webflux.demo.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public Flux<ProductDto> getAll(){
        return repository.findAll().map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> getById(String id){
        return repository.findById(id).map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono){
        return productDtoMono
            .map(EntityDtoUtil::toEntity)
            .flatMap(repository::insert)
            .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono){
        return repository.findById(id)
                    .flatMap(p -> productDtoMono
                                    .map(EntityDtoUtil::toEntity)
                                    .doOnNext(e -> e.setId(id)))
                    .flatMap(repository::save)
                    .map(EntityDtoUtil::toDto);
    }

    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }


}
