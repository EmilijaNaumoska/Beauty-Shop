package mk.ukim.finki.buycosmetics.service;

import mk.ukim.finki.buycosmetics.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    List<User> listAll();

    Optional<User> findById(Long id);

    User save(String name, String surname, String email);

    void deleteById(Long id);
}