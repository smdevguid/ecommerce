package edu.sm_devguid.ecommerce.backend.infraestructure.config;

import edu.sm_devguid.ecommerce.backend.application.UserService;
import edu.sm_devguid.ecommerce.backend.domain.port.IUserRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.IUserCrudRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.adapter.UserCrudRepositoryImpl;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }
    @Bean
    public IUserRepository iUserRepository(IUserCrudRepository userCrudRepository, IUserMapper userMapper){
        return new UserCrudRepositoryImpl(userCrudRepository,userMapper);
    }
}
