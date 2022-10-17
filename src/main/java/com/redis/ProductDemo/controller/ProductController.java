package com.redis.ProductDemo.controller;

import com.redis.ProductDemo.dto.ProductDto;
import com.redis.ProductDemo.dto.request.CreateProductRequest;
import com.redis.ProductDemo.dto.request.UpdateProductRequest;
import com.redis.ProductDemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody CreateProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAll());
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestParam String name, @RequestBody UpdateProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.update(name, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String name) {
        productService.delete(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<ProductDto> getByName(@RequestParam String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getByName(name));
    }
}
