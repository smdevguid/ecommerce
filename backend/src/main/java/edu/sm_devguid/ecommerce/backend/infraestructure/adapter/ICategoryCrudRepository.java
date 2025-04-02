package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;

import edu.sm_devguid.ecommerce.backend.infraestructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
