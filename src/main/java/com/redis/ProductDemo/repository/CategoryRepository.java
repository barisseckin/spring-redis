package com.redis.ProductDemo.repository;

import com.redis.ProductDemo.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findCategoryByName(String name);
}
