package com.twuc.shopping.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Create by 木水 on 2020/10/23.
 */
@Data
public class Order {
    @NotNull
    private List<Item> items;
}
