package com.redis.ProductDemo.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
