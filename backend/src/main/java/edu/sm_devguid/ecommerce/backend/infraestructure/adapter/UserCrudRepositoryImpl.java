package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;

import edu.sm_devguid.ecommerce.backend.domain.model.User;
import edu.sm_devguid.ecommerce.backend.domain.port.IUserRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.IUserMapper;

public class UserCrudRepositoryImpl implements IUserRepository {
    private final IUserCrudRepository userCrudRepository;
    private final IUserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository userCrudRepository, IUserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser( userCrudRepository.findById(id).get());
    }
}
