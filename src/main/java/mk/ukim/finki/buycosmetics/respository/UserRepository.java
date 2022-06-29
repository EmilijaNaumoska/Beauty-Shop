package mk.ukim.finki.buycosmetics.respository;

import mk.ukim.finki.buycosmetics.bootstrap.DataHolder;
import mk.ukim.finki.buycosmetics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
