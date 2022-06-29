package mk.ukim.finki.buycosmetics.respository;

import mk.ukim.finki.buycosmetics.bootstrap.DataHolder;
import mk.ukim.finki.buycosmetics.model.Korisnik;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InKorisnikRepository {
    public Optional<Korisnik> findByUsername(String username) {
        return DataHolder.korisnici.stream().filter(r -> r.getUsername().equals(username)).findFirst();
    }

    public Optional<Korisnik> findByUsernameAndPassword(String username, String password) {
        return DataHolder.korisnici.stream().filter(r -> r.getUsername().equals(username) && r.getPassword().equals(password)).findFirst();
    }

    public Korisnik saveOrUpdate(Korisnik korisnik) {
        DataHolder.korisnici.removeIf(r -> r.getUsername().equals(korisnik.getUsername()));
        DataHolder.korisnici.add(korisnik);
        return korisnik;
    }

    public void delete(String username) {
        DataHolder.korisnici.removeIf(r -> r.getUsername().equals(username));
    }


}
