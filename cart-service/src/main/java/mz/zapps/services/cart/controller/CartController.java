package mz.zapps.services.cart.controller;

import feign.FeignException;
import mz.zapps.services.cart.client.ProductClient;
import mz.zapps.services.cart.model.Cart;
import mz.zapps.services.cart.model.Product;
import mz.zapps.services.cart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductClient productClient;

    public CartController() {
    }
    public CartController(CartService cartService, ProductClient productClient) {
        this.cartService = cartService;
        this.productClient = productClient;
    }
    public CartService getCartService() {
        return cartService;
    }
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }
    public ProductClient getProductClient() {
        return productClient;
    }
    public void setProductClient(ProductClient productClient) {
        this.productClient = productClient;
    }


    /** Adds a product to a cart, or updates the cart with the quantity provided
     * if it already exists
     *
     * @param customerID ID of specific customer
     * @param productID ID of specific product
     * @param quantity Quantity of a product to be added to cart
     * @return The product added or updated, or NULL if product does not exist
     */
    @PostMapping("/addToCart/{customerID}/{productID}/{quantity}")
    public Product addToCart(@PathVariable("customerID") Long customerID,
                             @PathVariable("productID") Long productID,
                             @PathVariable("quantity") int quantity)
    {
        try{
            Product product = productClient.findByProductId(productID);
            Cart cart;
            List<Cart> items = cartService.findByCustomerIDAndProductID(customerID, productID);
            if(items.size() > 0){
                cart = items.get(0);
                cart.setQuantity(cart.getQuantity() + quantity);
                cartService.add(cart);
                LOGGER.info("Product quantity updated: {}", cart);
            } else{
                cart = new Cart(customerID, productID, quantity);
                LOGGER.info("Product added to cart: {}", product.toString());
            }
            return product;
        } catch(IndexOutOfBoundsException | NullPointerException | FeignException ex){
            LOGGER.info("Product ID {} Does not exist", productID);
            return null;
        }
    }

    /** Obtains the total cost of the contents of a customer's cart
     *
     * @param customerID customerID of desired customer
     * @return cost of cart as a double, or 0 if user does not exist
     */
    @GetMapping("/getCost")
    public double getCost(@RequestParam Long customerID){
        double cost = 0;
        try{
            List<Cart> carts = cartService.findByCustomerID(customerID);
            LOGGER.info("customer {} cart:", customerID);
            for(Cart item : carts){
                Product product = productClient.findByProductId(item.getProductID());
                double unitCost = item.getQuantity() * product.getUnitPrice();
                LOGGER.info("Product ID: {} Quantity: {} Cost: ${}", item.getProductID(), item.getQuantity(), unitCost);
                cost = cost + unitCost;
            }
        } catch(Exception ex) {
            ex.getStackTrace();
        }
        LOGGER.info("Customer {} Total Cost: ${}", customerID, cost);
        return cost;
    }

    @GetMapping("/all")
    public List<Cart> getAll(){
        List<Cart> items = cartService.findAll();
        LOGGER.info("Cart List: {}", items.toString());
        return items;
    }

    @GetMapping("/{cartId}")
    public Cart findByCartId(@PathVariable("cartId") Long id) {
        Cart cart = cartService.findByCart(id);
        LOGGER.info("Cart find: {}", cart);
        return cart;
    }

    @GetMapping("/findByCustomer/{customerID}")
    public List<Cart> findByCustomer(@PathVariable("customerID") Long customerID){
        List<Cart> customerCart = cartService.findByCustomerID(customerID);
        LOGGER.info("Customer cart: {}", customerCart.toString());
        return customerCart;
    }
}
