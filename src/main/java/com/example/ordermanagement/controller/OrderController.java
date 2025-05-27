package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.*;
import com.example.ordermanagement.entitys.*;
import com.example.ordermanagement.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO dto,
                                                        Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        return ResponseEntity.ok(orderService.createOrder(dto, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id,
                                                        @RequestBody OrderRequestDTO dto,
                                                        Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        return ResponseEntity.ok(orderService.updateOrder(id, dto, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id,
                                            Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        orderService.deleteOrder(id, user);
        return ResponseEntity.noContent().build();
    }
}