package mz.zapps.services.product.service;

import mz.zapps.services.product.model.Product;
import mz.zapps.services.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product add(Product product){
        return productRepository.save(product);
    }

    public Product findByID(Long productID){
        return productRepository.findById(productID).get();
    }

    public List<Product> findByCategoryID(Long categoryID){
        return productRepository.findByCategoryID(categoryID);
    }

    public List<Product> findBySupplierID(int supplierID){
        return productRepository.findBySupplierID(supplierID);
    }
}
