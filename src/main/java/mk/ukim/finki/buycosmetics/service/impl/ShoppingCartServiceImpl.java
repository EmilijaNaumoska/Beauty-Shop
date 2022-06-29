package mk.ukim.finki.buycosmetics.service.impl;


import mk.ukim.finki.buycosmetics.model.Korisnik;
import mk.ukim.finki.buycosmetics.model.Product;
import mk.ukim.finki.buycosmetics.model.ShoppingCart;
import mk.ukim.finki.buycosmetics.model.ShoppingCartStatus;
import mk.ukim.finki.buycosmetics.respository.InShoppingCartRepository;
import mk.ukim.finki.buycosmetics.respository.KorisnikRepository;
import mk.ukim.finki.buycosmetics.service.ProductService;
import mk.ukim.finki.buycosmetics.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final InShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;
    private final KorisnikRepository korisnikRepository;

    public ShoppingCartServiceImpl(InShoppingCartRepository shoppingCartRepository, ProductService productService, KorisnikRepository korisnikRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public List<Product> listAllProducts(Long cartId) {
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.shoppingCartRepository
                .findByUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    Korisnik korisnik = this.korisnikRepository.findByUsername(username)
                            .orElseThrow();
                    ShoppingCart shoppingCart = new ShoppingCart(korisnik);
                    return this.shoppingCartRepository.save(shoppingCart);
                });

    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow();
        List<Product> products=shoppingCart.getProducts();
        if(!products.contains(product))
            products.add(product);
        return this.shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public Optional<Product> findById(Long id, String username) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        return shoppingCart.getProducts().stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
