package edu.sm_devguid.ecommerce.backend.application;

import edu.sm_devguid.ecommerce.backend.domain.model.User;
import edu.sm_devguid.ecommerce.backend.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return this.userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findById(Integer id){
        return  userRepository.findById(id);
    }
}
