package mz.zapps.services.cart.client;

import mz.zapps.services.cart.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("product/{productId}")
    Product findByProductId(@PathVariable("productId") Long productId);

    @GetMapping("/category/{categoryId}")
    public List<Product> findByCategory(@PathVariable("categoryId") Long categoryId);

    @GetMapping("/supplier/{supplierId}")
    public List<Product> findBySupplier(@PathVariable("supplierId") int supplierId);
}
