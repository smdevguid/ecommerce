package edu.sm_devguid.ecommerce.backend.infraestructure.adapter;

import edu.sm_devguid.ecommerce.backend.domain.model.Category;
import edu.sm_devguid.ecommerce.backend.domain.port.ICategoryRepository;
import edu.sm_devguid.ecommerce.backend.infraestructure.mapper.ICategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {
    private final ICategoryCrudRepository categoryRepository;
    private final ICategoryMapper mapperCategory;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository categoryRepository, ICategoryMapper mapperCategory) {
        this.categoryRepository = categoryRepository;
        this.mapperCategory = mapperCategory;
    }


    @Override
    public Category save(Category category) {
        return mapperCategory.toCategory(
                categoryRepository.save(mapperCategory.toCategoryEntity(category))
        );
    }

    @Override
    public Iterable<Category> findAll() {
        return mapperCategory.toCategoryList(categoryRepository.findAll());
    }

    @Override
    public Category findById(Integer id) {
        return mapperCategory.toCategory( categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria con id: "+id+" no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Categoria con id: "+id+" no existe")
        );
        categoryRepository.deleteById(id);
    }
}
