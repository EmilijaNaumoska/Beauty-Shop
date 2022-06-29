package mk.ukim.finki.buycosmetics.respository;

import mk.ukim.finki.buycosmetics.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
    Optional<Korisnik> findByUsernameAndPassword(String username, String password);
    Optional<Korisnik> findByUsername(String username);
}
