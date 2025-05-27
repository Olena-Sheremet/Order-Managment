package com.example.ordermanagement.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String username;
}