package edu.sm_devguid.ecommerce.backend.application;

import edu.sm_devguid.ecommerce.backend.domain.model.Product;
import edu.sm_devguid.ecommerce.backend.domain.port.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class ProductService {
    private final IProductRepository productRepository;
    private final UploadFileService uploadFileService;

    public ProductService(IProductRepository productRepository, UploadFileService uploadFileService) {
        this.productRepository = productRepository;
        this.uploadFileService = uploadFileService;
    }
    public Product save(Product product, MultipartFile file) throws IOException {
        saveImageDirectory(product, file);
        return productRepository.save(product);
    }
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Integer id){
        return productRepository.findById(id);
    }
    public void deteleById(Integer id){
        Product productDB = findById(id);
        deleteImage(productDB.getUrlImage());
        productRepository.deteleById(id);
    }

    private void saveImageDirectory(Product p, MultipartFile file) throws IOException {
        boolean isProductModified = p.getId() != null;
        if(isProductModified){
            if(file == null){ // No se cargo la imagen
                p.setUrlImage(p.getUrlImage());
            }else{ // Se cargo otra imagen
                // Eliminar imagen anterior
                deleteImage(p.getUrlImage());
                p.setUrlImage(uploadFileService.upload(file));
            }
        }else { // producto nuevo
            p.setUrlImage(uploadFileService.upload(file));
        }
    }
    private void deleteImage(String url){
        String path = null;
        String DEFAULT_IMAGE = "";
        try {
            path = new URI(url).getPath();
            String fileName = path.substring(path.lastIndexOf('/') + 1);
            log.info("Este es el nombre de la imagen: {}",fileName);
            if(!fileName.equals(DEFAULT_IMAGE)){
                uploadFileService.delete(fileName);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
