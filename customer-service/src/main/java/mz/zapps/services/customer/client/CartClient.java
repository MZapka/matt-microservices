package mz.zapps.services.customer.client;

import mz.zapps.services.customer.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cart-service")
public interface CartClient {
    @GetMapping("/cart/{cartId}")
    public List<Cart> findByCartId(@PathVariable("cartId") Long cartId);
}
