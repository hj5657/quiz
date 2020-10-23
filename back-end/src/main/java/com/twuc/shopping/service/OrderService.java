package com.twuc.shopping.service;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repostory.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by 木水 on 2020/10/23.
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderPO> findAll() {
        List<OrderPO> orders = orderRepository.findAll();
        return orders;
    }

    public void create(Order order) {
        OrderPO orderPO = OrderPO.builder().items(order.getItems()).totalPrice(0).build();
        orderRepository.save(orderPO);
    }
}
