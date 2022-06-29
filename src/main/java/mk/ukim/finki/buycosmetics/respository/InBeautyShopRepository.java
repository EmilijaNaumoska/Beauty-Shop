package mk.ukim.finki.buycosmetics.respository;

import mk.ukim.finki.buycosmetics.bootstrap.DataHolder;
import mk.ukim.finki.buycosmetics.model.BeautyShop;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class InBeautyShopRepository {
    public List<BeautyShop> listAll() {
        return DataHolder.beautyShopsList;
    }

    public Optional<BeautyShop> findById(Long id) {
        return DataHolder.beautyShopsList.stream().filter(i -> i.getId().equals(id)).findFirst();
    }


    public void deleteById(Long id) {
        DataHolder.beautyShopsList.removeIf(i -> i.getId().equals(id));
    }

    public Optional<BeautyShop> save(String name, String city, String location ) {
        DataHolder.beautyShopsList.removeIf(i -> i.getName().equals(name));
        BeautyShop beautyShop = new BeautyShop(name,city,location);
        DataHolder.beautyShopsList.add(beautyShop);
        return Optional.of(beautyShop);
    }
}
