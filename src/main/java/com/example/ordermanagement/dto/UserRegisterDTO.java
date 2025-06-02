package com.example.ordermanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    private String username;
    private String email;
    private String password;
}

