package mz.zapps.services.cart.repository;

import mz.zapps.services.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCustomerID(Long customerID);
    List<Cart> findByCustomerIDAndProductID(Long customerID, Long productID);

}
