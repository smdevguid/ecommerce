package edu.sm_devguid.ecommerce.backend.infraestructure.config;

import edu.sm_devguid.ecommerce.backend.application.CategoryService;
import edu.sm_devguid.ecommerce.backend.application.UserService;
import edu.sm_devguid.ecommerce.backend.domain.port.ICategoryRepository;
import edu.sm_devguid.ecommerce.backend.domain.port.IUserRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.CategoryCrudRepositoryImpl;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.ICategoryCrudRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.IUserCrudRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.UserCrudRepositoryImpl;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.ICategoryMapper;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository iUserRepository) {
        return new UserService(iUserRepository);
    }

    @Bean
    public IUserRepository iUserRepository(IUserCrudRepository userCrudRepository, IUserMapper userMapper) {
        return new UserCrudRepositoryImpl(userCrudRepository, userMapper);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }
    @Bean
    public ICategoryRepository categoryRepository(ICategoryCrudRepository categoryCrudRepository, ICategoryMapper categoryMapper){
        return new CategoryCrudRepositoryImpl(categoryCrudRepository, categoryMapper);
    }
}

