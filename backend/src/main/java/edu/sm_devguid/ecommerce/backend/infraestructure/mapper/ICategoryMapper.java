package edu.sm_devguid.ecommerce.backend.infraestructure.mapper;

import edu.sm_devguid.ecommerce.backend.domain.model.Category;
import edu.sm_devguid.ecommerce.backend.infraestructure.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mappings({
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target="name"),
                    @Mapping(source = "createdAt", target = "createdAt"),
                    @Mapping(source = "updatedAt", target = "updatedAt")
            })
    Category toCategory(CategoryEntity categoryEntity);
    Iterable<Category> toCategoryList(Iterable<CategoryEntity> categoryEntities);

    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(Category category);
}
