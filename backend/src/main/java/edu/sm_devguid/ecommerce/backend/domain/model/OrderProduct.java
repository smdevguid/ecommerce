package edu.sm_devguid.ecommerce.backend.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;

    //representa el producto que el usuario esta comprando
    private Integer productId;


    public BigDecimal getTotalItem(){
        return this.price.multiply(quantity);
    }
}
