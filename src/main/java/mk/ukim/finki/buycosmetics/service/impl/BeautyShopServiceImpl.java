package mk.ukim.finki.buycosmetics.service.impl;

import mk.ukim.finki.buycosmetics.model.BeautyShop;
import mk.ukim.finki.buycosmetics.respository.BeautyShopRepository;
import mk.ukim.finki.buycosmetics.service.BeautyShopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeautyShopServiceImpl implements BeautyShopService {
    private final BeautyShopRepository beautyShopRepository;

    public BeautyShopServiceImpl(BeautyShopRepository beautyShopRepository) {
        this.beautyShopRepository = beautyShopRepository;
    }

    @Override
    public List<BeautyShop> listAll() {
        return this.beautyShopRepository.findAll();
    }

    @Override
    public Optional<BeautyShop> findById(Long id) {
        return this.beautyShopRepository.findById(id);
    }

    @Override
    public BeautyShop save(String name, String city, String location) {
        BeautyShop bs = new BeautyShop(name, city, location);
        this.beautyShopRepository.save(bs);
        return bs;
    }

    @Override
    public void deleteById(Long id) {
        this.beautyShopRepository.deleteById(id);
    }

}
