package edu.sm_devguid.ecommerce.backend.domain.port;

import edu.sm_devguid.ecommerce.backend.domain.model.Category;

public interface ICategoryRepository {
    Category save(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);
}
