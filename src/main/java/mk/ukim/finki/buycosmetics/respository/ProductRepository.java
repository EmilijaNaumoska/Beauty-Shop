package mk.ukim.finki.buycosmetics.respository;


import mk.ukim.finki.buycosmetics.model.BeautyShop;
import mk.ukim.finki.buycosmetics.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {
    public Optional<Product> findById(Long id);
    public List<Product> findByBeautyShops(BeautyShop beautyShop);

    List<Product> findAll();

    void deleteById(Long id);


     Product update(String name, Integer price, String type, String description, String image,String rating, Long shopId);

    void save(Product p);




}

