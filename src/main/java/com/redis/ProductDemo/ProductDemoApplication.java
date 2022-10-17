package com.redis.ProductDemo;

import com.redis.ProductDemo.model.Product;
import com.redis.ProductDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.math.BigDecimal;

@SpringBootApplication
@EnableCaching
public class ProductDemoApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

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
