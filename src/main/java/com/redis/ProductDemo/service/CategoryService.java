package com.redis.ProductDemo.service;

import com.redis.ProductDemo.dto.CategoryDto;
import com.redis.ProductDemo.dto.request.CreateCategoryRequest;
import com.redis.ProductDemo.model.Category;
import com.redis.ProductDemo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto save(CreateCategoryRequest request) {
        Category category = Category.builder()
                .name(request.getName())
                .createDate(LocalDateTime.now())
                .build();

        categoryRepository.save(category);

        return CategoryDto.builder()
                .name(request.getName())
                .createDate(category.getCreateDate())
                .build();
    }

    public void delete(String name) {
        Category category = categoryRepository.findCategoryByName(name)
                .orElseThrow();
        categoryRepository.delete(category);
    }
}
