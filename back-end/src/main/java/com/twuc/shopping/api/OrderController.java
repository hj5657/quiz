package com.twuc.shopping.api;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by 木水 on 2020/10/23.
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity createOrder(@RequestBody Order order){
        orderService.create(order);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/orders")
    public ResponseEntity getOrders(){
        List<OrderPO> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }
}
