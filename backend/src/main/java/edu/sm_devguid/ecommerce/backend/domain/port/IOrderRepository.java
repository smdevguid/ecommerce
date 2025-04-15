package edu.sm_devguid.ecommerce.backend.domain.port;

import edu.sm_devguid.ecommerce.backend.domain.model.Order;

public interface IOrderRepository {
    Order save(Order order);
    Order findById(Integer id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Integer userId);
    void updateStateById(Integer id, String state);
}
