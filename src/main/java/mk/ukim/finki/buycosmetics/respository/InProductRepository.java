package mk.ukim.finki.buycosmetics.respository;


import mk.ukim.finki.buycosmetics.bootstrap.DataHolder;
import mk.ukim.finki.buycosmetics.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InProductRepository {
    public List<Product> listAll() {
        return DataHolder.productsList;
    }

    public Optional<Product> findById(Long id) {
        return DataHolder.productsList.stream().filter(i -> i.getId().equals(id)).findFirst();
    }


    public void deleteById(Long id) {
        DataHolder.productsList.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Product> save(String name, Integer price, String type, String description, String image, String rating, Long shopId) {
        DataHolder.productsList.removeIf(i -> i.getName().equals(name));
        Product product = new Product(name, price, type, description, image,rating,shopId );
        DataHolder.productsList.add(product);
        return Optional.of(product);
    }

}
