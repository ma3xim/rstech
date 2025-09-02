package org.example.rstech.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class AuthDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        @NotBlank
        private String username;
        @NotBlank
        private String password;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class TokenResponse {
        private String token;
    }
}
