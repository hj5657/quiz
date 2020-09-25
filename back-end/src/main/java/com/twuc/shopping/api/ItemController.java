package com.twuc.shopping.api;

import com.twuc.shopping.domain.Item;
import com.twuc.shopping.po.ItemPO;
import com.twuc.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Create by 木水 on 2020/9/25.
 */
@RestController
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping("/item")
    public ResponseEntity addItem(@RequestBody @Valid Item item){
        boolean isSave=itemService.save(item);
        if (isSave){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/items")
    public ResponseEntity getItemList(){
        List<ItemPO> itemPOS = itemService.findAll();
        return ResponseEntity.ok(itemPOS);
    }
}
