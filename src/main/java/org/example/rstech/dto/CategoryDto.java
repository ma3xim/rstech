package org.example.rstech.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class CategoryDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateRequest {
        @NotBlank
        @Schema(description = "Наименование")
        private String name;

        @Schema(description = "Описание")
        private String description;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateRequest {
        @Schema(description = "Наименование")
        private String name;

        @Schema(description = "Описание")
        private String description;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;

        @Schema(description = "Наименование")
        private String name;

        @Schema(description = "Описание")
        private String description;
    }
}

