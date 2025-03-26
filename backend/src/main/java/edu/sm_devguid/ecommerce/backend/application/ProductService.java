package edu.sm_devguid.ecommerce.backend.application;

import edu.sm_devguid.ecommerce.backend.domain.model.Product;
import edu.sm_devguid.ecommerce.backend.domain.port.IProductRepository;

public class ProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Integer id){
        return productRepository.findById(id);
    }
    public void deteleById(Integer id){
        productRepository.deteleById(id);
    }
}
