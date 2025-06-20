package edu.sm_devguid.ecommerce.backend.infraestructure.rest;

import edu.sm_devguid.ecommerce.backend.application.CategoryService;
import edu.sm_devguid.ecommerce.backend.domain.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/categories")
//http://localhost:8085/api/v1/admin/categories
@Slf4j
@CrossOrigin("http://localhost:4200")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    //http://localhost:8085/api/v1/admin/categories
    public ResponseEntity<Category> save(@RequestBody Category category){
        if (category.getId() == 0){
            category.setId(null);
        }
        return new ResponseEntity<>(
                categoryService.save(category),
                HttpStatus.CREATED);
    }
    @GetMapping
    //http://localhost:8085/api/v1/admin/categories
    public ResponseEntity<Iterable<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @GetMapping("/{id}")
    //http://localhost:8085/api/v1/admin/categories/1
    public ResponseEntity< Category> findById(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    //http://localhost:8085/api/v1/admin/categories/1
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
