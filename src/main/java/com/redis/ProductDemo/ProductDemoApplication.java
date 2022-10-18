package com.redis.ProductDemo;

import com.redis.ProductDemo.model.Category;
import com.redis.ProductDemo.model.Product;
import com.redis.ProductDemo.repository.CategoryRepository;
import com.redis.ProductDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
public class ProductDemoApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Product product = Product.builder()
				.name("test")
				.description("test")
				.price(BigDecimal.valueOf(2000))
				.build();

		Product product2 = Product.builder()
				.name("test")
				.description("test")
				.price(BigDecimal.valueOf(2000))
				.build();

		Product product3 = Product.builder()
				.name("test")
				.description("test")
				.price(BigDecimal.valueOf(2000))
				.build();

		Product product4 = Product.builder()
				.name("test")
				.description("test")
				.price(BigDecimal.valueOf(2000))
				.build();

		Product product5 = Product.builder()
				.name("test")
				.description("test")
				.price(BigDecimal.valueOf(2000))
				.build();

		Category category = Category.builder()
				.name("test")
				.createDate(LocalDateTime.now())
				.build();

		Category category2 = Category.builder()
				.name("test")
				.createDate(LocalDateTime.now())
				.build();

		Category category3 = Category.builder()
				.name("test")
				.createDate(LocalDateTime.now())
				.build();

		Category category4 = Category.builder()
				.name("test")
				.createDate(LocalDateTime.now())
				.build();

		categoryRepository.save(category);
		categoryRepository.save(category2);
		categoryRepository.save(category3);
		categoryRepository.save(category4);
		productRepository.save(product);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		productRepository.save(product5);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductDemoApplication.class, args);
	}

}
