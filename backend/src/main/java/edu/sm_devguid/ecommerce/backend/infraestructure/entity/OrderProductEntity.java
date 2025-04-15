package edu.sm_devguid.ecommerce.backend.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_products")
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    //representa el producto que el usuario esta comprando
    private Integer productId;

    @ManyToOne
    private OrderEntity orderEntity;

}
