package mz.zapps.services.product.controller;
import mz.zapps.services.product.ProductServiceApplication;
import mz.zapps.services.product.model.Product;
import mz.zapps.services.product.repository.ProductRepository;
import mz.zapps.services.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Product add(@RequestBody Product product) {
        LOGGER.info("Product add: {}", product);
        return service.add(product);
    }

    @GetMapping("/")
    public List<Product> findAll() {
        LOGGER.info("Product find");
        return service.findAll();
    }
    @GetMapping("/{productID}")
    public Product findByID(@PathVariable("productID") Long productID) {
        LOGGER.info("Product find: productID={}", productID);
        return service.findByID(productID);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findByCategory(@PathVariable("categoryId") Long categoryId) {
        LOGGER.info("Product find: categoryId={}", categoryId);
        return service.findByCategoryID(categoryId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<Product> findBySupplier(@PathVariable("supplierId") int supplierId) {
        LOGGER.info("Product find: supplierId={}", supplierId);
        return service.findBySupplierID(supplierId);
    }

}
