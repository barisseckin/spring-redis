package com.redis.ProductDemo.controller;

import com.redis.ProductDemo.dto.CategoryDto;
import com.redis.ProductDemo.dto.request.CreateCategoryRequest;
import com.redis.ProductDemo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CreateCategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String name) {
        categoryService.delete(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
