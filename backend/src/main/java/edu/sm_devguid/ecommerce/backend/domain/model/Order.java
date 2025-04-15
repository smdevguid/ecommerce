package edu.sm_devguid.ecommerce.backend.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private LocalDateTime createdAt;
    private List<OrderProduct> orderProducts;
    private OrderState orderState;
    private Integer userId;

    public Order() {
        orderProducts = new ArrayList<>();
    }
    public BigDecimal getTotalOrderPrice(){
        return this.orderProducts.stream()
                .map(OrderProduct::getTotalItem)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
