package com.redis.ProductDemo.service;

import com.redis.ProductDemo.dto.ProductDto;
import com.redis.ProductDemo.dto.request.CreateProductRequest;
import com.redis.ProductDemo.dto.request.UpdateProductRequest;
import com.redis.ProductDemo.model.Product;
import com.redis.ProductDemo.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CachePut(value = "products", key = "#request")
    public ProductDto save(CreateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        return ProductDto.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    @Cacheable(value = "products")
    public List<ProductDto> getAll() {
         return productRepository.findAll()
                .stream()
                .map(product ->
                     ProductDto.builder()
                             .name(product.getName())
                             .description(product.getDescription())
                             .price(product.getPrice())
                             .build()
                ).collect(Collectors.toList());
    }

    @CacheEvict(value = "products", allEntries = true)
    public ProductDto update(String name, UpdateProductRequest request) {
        Product product = productRepository.findProductByName(name)
                .orElseThrow();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        productRepository.save(product);

        return ProductDto.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    @CacheEvict(value = "products", allEntries = true)
    public void delete(String name) {
        Product product = productRepository.findProductByName(name)
                .orElseThrow();
        productRepository.deleteById(product.getId());
    }

    @Cacheable(value = "products", key = "#name")
    public ProductDto getByName(String name) {
         Product product =  productRepository.findProductByName(name)
                 .orElseThrow();

         return ProductDto
                 .builder()
                 .name(product.getName())
                 .description(product.getDescription())
                 .price(product.getPrice())
                 .build();
    }

}
