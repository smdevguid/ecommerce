package edu.sm_devguid.ecommerce.backend.domain.port;

import edu.sm_devguid.ecommerce.backend.domain.model.Product;

public interface IProductRepository {
    Product save(Product product);
    Iterable<Product> findAll();
    Product findById(Integer id);
    void deteleById(Integer id);
}
