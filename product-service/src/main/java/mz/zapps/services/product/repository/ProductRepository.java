package mz.zapps.services.product.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mz.zapps.services.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryID(Long categoryID);
    List<Product> findBySupplierID(int supplierID);
}

//public class ProductRepository {
//
//    private List<Product> products = new ArrayList<>();
//
//    public Product add(Product product){
//        product.setProductID((long) (products.size()+1));
//        products.add(product);
//        return product;
//    }
//
//    public Product findById(Long id) {
//        return products.stream()
//                .filter(a -> a.getProductID().equals(id))
//                .findFirst()
//                .orElseThrow(NullPointerException::new);
//    }
//
//    public List<Product> findAll() {
//        return products;
//    }
//
//    public List<Product> findBySupplier(int supplierId) {
//        return products.stream()
//                .filter(a -> a.getSupplierID() == supplierId)
//                .collect(Collectors.toList());
//    }
//
//    public List<Product> findByCategory(Long categoryId) {
//        return products.stream()
//                .filter(a -> a.getCategoryID().equals(categoryId))
//                .collect(Collectors.toList());
//    }
//}
