package com.twuc.shopping.repostory;

import com.twuc.shopping.po.ItemPO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Create by 木水 on 2020/9/25.
 */
public interface ItemRepository extends CrudRepository<ItemPO,Integer> {
    @Override
    List<ItemPO> findAll();

    @Query(value = "select * from item where name = :name",nativeQuery = true)
    List<ItemPO> findByName(String name);
}
