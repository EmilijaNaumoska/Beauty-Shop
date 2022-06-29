package mk.ukim.finki.buycosmetics.service;

import mk.ukim.finki.buycosmetics.model.BeautyShop;

import java.util.List;
import java.util.Optional;

public interface BeautyShopService {
    List<BeautyShop> listAll();

    Optional<BeautyShop> findById(Long id);

    BeautyShop save(String name, String city, String location);

    void deleteById(Long id);
}
