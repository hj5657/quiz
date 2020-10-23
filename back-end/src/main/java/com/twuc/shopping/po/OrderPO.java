package com.twuc.shopping.po;

import com.twuc.shopping.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Create by 木水 on 2020/10/23.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class OrderPO {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy ="order")
    private List<Item> items;
    private double totalPrice;
}
