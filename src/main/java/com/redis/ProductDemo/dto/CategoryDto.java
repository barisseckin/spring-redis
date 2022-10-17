package com.redis.ProductDemo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryDto {
    private String name;
    private LocalDateTime createDate;
}
