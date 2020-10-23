package com.twuc.shopping.repostory;

import com.twuc.shopping.po.OrderPO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Create by 木水 on 2020/10/23.
 */
public interface OrderRepository extends PagingAndSortingRepository<OrderPO, Long> {
    @Override
    List<OrderPO> findAll();
}
