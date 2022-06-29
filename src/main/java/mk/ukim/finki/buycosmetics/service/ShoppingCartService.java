package mk.ukim.finki.buycosmetics.service;

import mk.ukim.finki.buycosmetics.model.Product;
import mk.ukim.finki.buycosmetics.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<Product> listAllProducts(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);

    Optional<Product> findById(Long id, String username);


}
