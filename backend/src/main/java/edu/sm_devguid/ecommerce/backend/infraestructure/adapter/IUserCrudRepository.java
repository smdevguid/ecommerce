package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;

import edu.sm_devguid.ecommerce.backend.infraestructure.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer> {
}
