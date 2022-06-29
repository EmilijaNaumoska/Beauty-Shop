package mk.ukim.finki.buycosmetics.service;

import mk.ukim.finki.buycosmetics.model.Korisnik;
import mk.ukim.finki.buycosmetics.model.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface KorisnikService  extends UserDetailsService {

    Korisnik login(String username, String password);

    Korisnik register(String username, String password, String repeatPassword, String name, String surname, Role role);

}
