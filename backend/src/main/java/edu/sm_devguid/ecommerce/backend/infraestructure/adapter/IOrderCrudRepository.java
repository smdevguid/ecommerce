package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;


import edu.sm_devguid.ecommerce.backend.domain.model.OrderState;
import edu.sm_devguid.ecommerce.backend.infraestructure.entity.OrderEntity;
import edu.sm_devguid.ecommerce.backend.infraestructure.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state WHERE o.id = :id")
    void updateStateById(Integer id, OrderState state);

    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);

}
