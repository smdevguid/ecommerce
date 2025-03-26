package edu.sm_devguid.ecommerce.backend.infraestructure.mapper;


import edu.sm_devguid.ecommerce.backend.domain.model.User;
import edu.sm_devguid.ecommerce.backend.infraestructure.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "cellPhone", target = "cellPhone"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "userType", target = "userType"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt")
    })
    User toUser(UserEntity userEntity);
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

}
