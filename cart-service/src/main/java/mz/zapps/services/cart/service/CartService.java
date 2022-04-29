package mz.zapps.services.cart.service;

import mz.zapps.services.cart.model.Cart;
import mz.zapps.services.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService() {
    }

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartRepository getCartRepository() {
        return cartRepository;
    }

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart add(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }

    public Cart findByCart(Long cartID){
        return cartRepository.findById(cartID).get();
    }

    public List<Cart> findByCustomerID(Long customerID){
        return cartRepository.findByCustomerID(customerID);
    }

    public List<Cart> findByCustomerIDAndProductID(Long customerID, Long productID){
        return cartRepository.findByCustomerIDAndProductID(customerID, productID);
    }

}
