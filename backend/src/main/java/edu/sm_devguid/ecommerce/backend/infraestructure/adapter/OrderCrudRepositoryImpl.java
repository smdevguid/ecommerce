package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;

import edu.sm_devguid.ecommerce.backend.domain.model.Order;
import edu.sm_devguid.ecommerce.backend.domain.model.OrderState;
import edu.sm_devguid.ecommerce.backend.domain.port.IOrderRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.entity.OrderEntity;
import edu.sm_devguid.ecommerce.backend.infraestructure.entity.UserEntity;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IOrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderCrudRepositoryImpl implements IOrderRepository {
    private final IOrderCrudRepository orderCrudRepository;
    private final IOrderMapper orderMapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        orderEntity.getOrderProducts().forEach(
                orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)
        );
        return orderMapper.toOrder(orderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.toOrder(orderCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Order con id: "+id+" no encontrado")
        ));
    }

    @Override
    public Iterable<Order> findAll() {
        return orderMapper.toOrderList(orderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);

        return orderMapper.toOrderList(orderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateById(Integer id, String state) {
        OrderState orderState = state.equals(OrderState.CANCELLED.name()) ? OrderState.CANCELLED: OrderState.CONFIRMED;
        orderCrudRepository.updateStateById(id, orderState);
    }
}
