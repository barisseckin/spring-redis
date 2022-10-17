package com.redis.ProductDemo.service;

import com.redis.ProductDemo.dto.ProductDto;
import com.redis.ProductDemo.dto.request.CreateProductRequest;
import com.redis.ProductDemo.model.Product;
import com.redis.ProductDemo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testSave_itShouldReturnProductDto() {
        CreateProductRequest request = CreateProductRequest.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        ProductDto productDto = ProductDto.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        Product product = Product.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        Product savedProduct = Product.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        when(productRepository.save(product)).thenReturn(savedProduct);

        ProductDto response = productService.save(request);

        assertEquals(response, productDto);
        verify(productRepository).save(product);
    }

    @Test
    public void testGetAll_itShouldReturnProductDtoList() {
        ProductDto productDto = ProductDto.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        ProductDto productDto2 = ProductDto.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        Product product = Product.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        Product product2 = Product.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        List<ProductDto> productDtoList = List.of(productDto, productDto2);
        List<Product> productList = List.of(product, product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<ProductDto> response = productService.getAll();

        assertEquals(response, productDtoList);
    }

    @Test
    public void testGetByName_itShouldReturnProductDto() {
        String name = "test";

        ProductDto productDto = ProductDto.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        Product product = Product.builder()
                .name("test")
                .description("test")
                .price(BigDecimal.valueOf(1000))
                .build();

        when(productRepository.findProductByName(name)).thenReturn(Optional.ofNullable(product));

        ProductDto response = productService.getByName(name);

        assertEquals(response, productDto);
    }
}