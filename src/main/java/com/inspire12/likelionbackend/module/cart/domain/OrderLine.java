package com.inspire12.likelionbackend.module.cart.domain;


import com.inspire12.likelionbackend.exception.NotFoundMenuException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Optional;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class OrderLine {

    private Long menuId;
    private int quantity;

    public OrderLine(final Long menuId) {
        this.menuId = menuId;
        this.quantity = 1;
    }

    public void add() {
        quantity++;
    }

    public void minus() {
        quantity--;
        if (quantity == 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEqualsMenu(final Long menuId) {
        return this.menuId.equals(menuId);
    }

    public Long calculateAmount(Map<Long, Menu> menus) {
        return Optional.ofNullable(menus.get(menuId))
                .map(menu -> (long) menu.price() * quantity)
                .orElseThrow(() -> new NotFoundMenuException(menuId));
    }
}
