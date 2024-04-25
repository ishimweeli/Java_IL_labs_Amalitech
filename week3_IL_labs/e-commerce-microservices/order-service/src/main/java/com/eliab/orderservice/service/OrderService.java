package com.eliab.orderservice.service;

import com.eliab.orderservice.domain.Order;

public interface OrderService {
    public Order saveOrder(Order order);
}
