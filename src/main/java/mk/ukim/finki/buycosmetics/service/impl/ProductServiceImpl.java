package mk.ukim.finki.buycosmetics.service.impl;

import mk.ukim.finki.buycosmetics.model.BeautyShop;
import mk.ukim.finki.buycosmetics.model.Product;
import mk.ukim.finki.buycosmetics.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.buycosmetics.respository.ProductRepository;
import mk.ukim.finki.buycosmetics.service.BeautyShopService;
import mk.ukim.finki.buycosmetics.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BeautyShopService beautyShopService;

    public ProductServiceImpl(ProductRepository productRepository, BeautyShopService beautyShopService) {
        this.productRepository = productRepository;
        this.beautyShopService = beautyShopService;
    }

    @Override
    public List<Product> listAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

//    @Override
    public Product save(String name, Integer price, String type, String description, String image,String rating, Long shopId) {
        Product p = new Product(name, price, type, description, image,rating, shopId);
        BeautyShop bs=this.beautyShopService.findById(shopId).orElse(null);
        p.getBeautyShops().add(bs);
        this.productRepository.save(p);
        return p;
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void update(String name, Integer price, String type, String description, String image, String rating) {

    }

    @Override
    public void update(String name, Integer price, String type, String description, String image, String rating, Long shopId) {
        Product product=this.productRepository.findById(shopId).orElseThrow(InvalidArgumentException::new);
        product.setName(name);
        product.setPrice(price);
        product.setType(type);
        product.setDescription(description);

        product.setRating(rating);


        BeautyShop beautyShop=this.beautyShopService.findById(shopId).orElseThrow(InvalidArgumentException::new);
        if(!product.getBeautyShops().contains(beautyShop))
            product.getBeautyShops().add(beautyShop);
        product.setImage(image);
        this.productRepository.save(product);


    }

    @Override
    public List<Product> listFromShop(Long id) {
        BeautyShop beautyShop=this.beautyShopService.findById(id).orElseThrow(InvalidArgumentException::new);
        return this.productRepository.findByBeautyShops(beautyShop);
    }

    @Override
    public void update(Long id, Long beautyShop, String name, Integer price, String type, String description, String rating, String image) {

    }

    @Override
    public Product save(String name, Integer price, String type, String description, Long beautyShop, String image) {
        return null;
    }


}
