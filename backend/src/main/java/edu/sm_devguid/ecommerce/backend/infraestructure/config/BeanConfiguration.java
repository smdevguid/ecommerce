package edu.sm_devguid.ecommerce.backend.infraestructure.config;

import edu.sm_devguid.ecommerce.backend.application.CategoryService;
import edu.sm_devguid.ecommerce.backend.application.OrderService;
import edu.sm_devguid.ecommerce.backend.application.ProductService;
import edu.sm_devguid.ecommerce.backend.application.UserService;
import edu.sm_devguid.ecommerce.backend.domain.port.ICategoryRepository;
import edu.sm_devguid.ecommerce.backend.domain.port.IOrderRepository;
import edu.sm_devguid.ecommerce.backend.domain.port.IProductRepository;
import edu.sm_devguid.ecommerce.backend.domain.port.IUserRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.*;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.ICategoryMapper;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IProductMapper;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    //Config User
    @Bean
    public UserService userService(IUserRepository iUserRepository) {
        return new UserService(iUserRepository);
    }

   /* @Bean
   //Ya no se usa por que la clase Impl se establecio con la propiedad @Repository
    public IUserRepository iUserRepository(IUserCrudRepository userCrudRepository, IUserMapper userMapper) {
        return new UserCrudRepositoryImpl(userCrudRepository, userMapper);
    }
    */


    //Config Category
    @Bean
    public CategoryService categoryService(ICategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }
    /*@Bean
    //Ya no se usa por que la clase Impl se establecio con la propiedad @Repository
    public ICategoryRepository categoryRepository(ICategoryCrudRepository categoryCrudRepository, ICategoryMapper categoryMapper){
        return new CategoryCrudRepositoryImpl(categoryCrudRepository, categoryMapper);
    }*/

    //Config Product

    @Bean
    public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }
    /*
    @Bean
    //Ya no se usa por que la clase Impl se establecio con la propiedad @Repository
    public IProductRepository productRepository(IProductCrudRepository productCrudRepository, IProductMapper productMapper){
        return new ProductCrudRepositoryImpl(productCrudRepository, productMapper);
    }*/
    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);
    }
}

