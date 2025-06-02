package com.example.ordermanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
    private String email;
    private String password;
}
