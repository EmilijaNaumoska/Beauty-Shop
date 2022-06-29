package mk.ukim.finki.buycosmetics.respository;

import mk.ukim.finki.buycosmetics.bootstrap.DataHolder;
import mk.ukim.finki.buycosmetics.model.ShoppingCart;
import mk.ukim.finki.buycosmetics.model.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InShoppingCartRepository {
    public Optional<ShoppingCart> findById(Long id) {
        return DataHolder.shoppingCarts.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Optional<ShoppingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status) {
        return DataHolder.shoppingCarts.stream()
                .filter(i -> i.getKorisnik().getUsername().equals(username) && i.getStatus().equals(status))
                .findFirst();
    }


    public ShoppingCart save(ShoppingCart shoppingCart) {
        DataHolder.shoppingCarts
                .removeIf(i -> i.getKorisnik().getUsername().equals(shoppingCart.getKorisnik().getUsername()));

        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }
}
