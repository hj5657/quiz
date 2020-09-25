package com.twuc.shopping.service;

import com.twuc.shopping.domain.Item;
import com.twuc.shopping.po.ItemPO;
import com.twuc.shopping.repostory.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by 木水 on 2020/9/25.
 */
@Service
public class ItemService {
    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        ItemPO itemPO = ItemPO.builder().name(item.getName()).num(item.getNum()).price(item.getPrice())
                .url(item.getUrl()).build();
        itemRepository.save(itemPO);
    }

    public List<ItemPO> findAll() {
        return itemRepository.findAll();
    }
}
