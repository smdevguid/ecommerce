package edu.sm_devguid.ecommerce.backend.infraestructure.mapper;

import edu.sm_devguid.ecommerce.backend.domain.model.Order;
import edu.sm_devguid.ecommerce.backend.infraestructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IOrderProductMapper.class})
public interface IOrderMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "orderProducts", target = "orderProducts"),
            @Mapping(source = "orderState", target = "orderState"),
            @Mapping(source = "userEntity.id", target = "userId")
    })

    Order toOrder (OrderEntity orderEntity);
    Iterable<Order> toOrderList(Iterable<OrderEntity> orderEntityIterable);
    @InheritInverseConfiguration
    OrderEntity toOrderEntity (Order order);
}
