package mk.ukim.finki.buycosmetics.service;

import mk.ukim.finki.buycosmetics.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAll();

    Optional<Product> findById(Long id);


    void deleteById(Long id);

    void update(String name, Integer price, String type, String description, String image, String rating);

    void update(String name, Integer price, String type, String description, String image, String rating, Long shopId);

    List<Product> listFromShop(Long id);

    void update(Long id, Long beautyShop, String name, Integer price, String type, String description, String rating, String image);

    Product save(String name, Integer price, String type, String description, Long beautyShop, String image);
}
