package edu.sm_devguid.ecommerce.backend.infraestructure.rest;

import edu.sm_devguid.ecommerce.backend.application.ProductService;
import edu.sm_devguid.ecommerce.backend.domain.model.Product;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/products")
//http://localhost:8085/api/v1/admin/products
@Slf4j
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    //http://localhost:8085/api/v1/admin/products
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        log.info("Nombre producto: {}", product.getName());
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    //http://localhost:8085/api/v1/admin/products
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    //http://localhost:8085/api/v1/admin/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }
    //http://localhost:8085/api/v1/admin/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        productService.deteleById(id);
        return ResponseEntity.ok().build();
    }

}
