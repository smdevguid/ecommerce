package edu.sm_devguid.ecommerce.backend.application;

import edu.sm_devguid.ecommerce.backend.domain.model.Order;
import edu.sm_devguid.ecommerce.backend.domain.port.IOrderRepository;

public class OrderService {
    private final IOrderRepository orderRepository;
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }
    public Order findById(Integer id){
        return orderRepository.findById(id);
    }
    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }
    public Iterable<Order> findByUserId(Integer userId){
        return orderRepository.findByUserId(userId);
    }
    public void updateStateById(Integer id, String state){
        orderRepository.updateStateById(id, state);
    }
}
