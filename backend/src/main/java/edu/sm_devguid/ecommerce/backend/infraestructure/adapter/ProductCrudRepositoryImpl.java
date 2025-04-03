package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;

import edu.sm_devguid.ecommerce.backend.domain.model.Product;
import edu.sm_devguid.ecommerce.backend.domain.port.IProductRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductCrudRepositoryImpl implements IProductRepository {
    private IProductCrudRepository productRepository;
    private IProductMapper productMapper;



    @Override
    public Product save(Product product) {
        return productMapper
                .toProduct(
                        productRepository.save(
                                productMapper.toProductEntity(product)
                        )
                );
    }

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProductList(productRepository.findAll());
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct(productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con id:"+id+" no existe")
        ));
    }

    @Override
    public void deteleById(Integer id) {
        productRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Producto con id:"+id+" no existe")
        );
        productRepository.deleteById(id);
    }
}
