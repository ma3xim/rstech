package org.example.rstech.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

public class ProductDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateRequest {
        @NotBlank
        private String name;
        private String description;
        @NotNull
        @Positive
        private BigDecimal price;
        private String imageUrl;
        @NotNull
        private Long categoryId;
        private Boolean status;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateRequest {
        private String name;
        private String description;
        @Positive
        private BigDecimal price;
        private String imageUrl;
        private Long categoryId;
        private Boolean status;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private String imageUrl;
        private Long categoryId;
        private String categoryName;
        private String createdAt;
        private boolean status;
    }
}

