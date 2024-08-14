package com.example.product.demoprojectproduct.Service;


import com.example.product.demoprojectproduct.Model.Cart;
import com.example.product.demoprojectproduct.Model.CartItem;
import com.example.product.demoprojectproduct.Model.Product;
import com.example.product.demoprojectproduct.Repository.CartRepository;
import com.example.product.demoprojectproduct.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCartByUserId(String userId) {
        return cartRepository.findByuserId(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            newCart.setCreatedAt(new Date());
            newCart.setStatus("Active");
            return cartRepository.save(newCart);
        });
    }

    public Cart addItemToCart(String userId, String productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        Optional<Product> productOpt = productRepository.findById(productId);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setPrice(product.getPrice());
            cartItem.setTotalPrice(product.getPrice() * quantity);

            cart.getItems().add(cartItem);
            cart.setCartTotal(cart.getCartTotal() + cartItem.getTotalPrice());
            cart.setUpdatedAt(new Date());

            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    // Other methods for updating and removing items from the cart
}
