package edu.sm_devguid.ecommerce.backend.domain.port;

import edu.sm_devguid.ecommerce.backend.domain.model.User;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findById(Integer id);
}
