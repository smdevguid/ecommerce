package edu.sm_devguid.ecommerce.backend.application;

import edu.sm_devguid.ecommerce.backend.domain.model.Category;
import edu.sm_devguid.ecommerce.backend.domain.port.ICategoryRepository;

public class CategoryService {
    private final ICategoryRepository categoryRepository;
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category save(Category category){
        return this.categoryRepository.save(category);
    }
    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category findById(Integer id){
        return categoryRepository.findById(id);
    }
    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }

}
