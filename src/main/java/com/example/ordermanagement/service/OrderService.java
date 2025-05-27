package com.example.ordermanagement.service;
import com.example.ordermanagement.dto.*;
import com.example.ordermanagement.entitys.*;
import com.example.ordermanagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponseDTO createOrder(OrderRequestDTO dto, User user) {
        Order order = Order.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
        orderRepository.save(order);

        return mapToDTO(order);
    }

    public OrderResponseDTO getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Замовлення не знайдено"));
        return mapToDTO(order);
    }

    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO dto, User currentUser) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Замовлення не знайдено"));

        if (!order.getUser().getId().equals(currentUser.getId()) && currentUser.getRole() != Role.ADMIN) {
            throw new RuntimeException("Немає прав для редагування");
        }

        order.setDescription(dto.getDescription());
        order.setAmount(dto.getAmount());
        orderRepository.save(order);

        return mapToDTO(order);
    }

    public void deleteOrder(Long id, User currentUser) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Замовлення не знайдено"));

        if (currentUser.getRole() != Role.ADMIN) {
            throw new RuntimeException("Тільки адміністратор може видаляти замовлення");
        }

        orderRepository.delete(order);
    }

    private OrderResponseDTO mapToDTO(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .description(order.getDescription())
                .amount(order.getAmount())
                .createdAt(order.getCreatedAt())
                .username(order.getUser().getUsername())
                .build();
    }
}