package mk.ukim.finki.buycosmetics.bootstrap;


import lombok.Getter;
import mk.ukim.finki.buycosmetics.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<User> usersList = new ArrayList<>();
    public static List<Product> productsList = new ArrayList<>();
    public static List<BeautyShop> beautyShopsList = new ArrayList<>();
    public static List<Korisnik> korisnici = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();


}
