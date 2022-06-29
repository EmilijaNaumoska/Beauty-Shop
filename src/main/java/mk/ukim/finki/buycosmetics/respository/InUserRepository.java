package mk.ukim.finki.buycosmetics.respository;

import mk.ukim.finki.buycosmetics.bootstrap.DataHolder;
import mk.ukim.finki.buycosmetics.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class InUserRepository {
    public List<User> listAll() {
        return DataHolder.usersList;
    }

    public Optional<User> findById(Long id) {
        return DataHolder.usersList.stream().filter(i -> i.getId().equals(id)).findFirst();
    }


    public void deleteById(Long id) {
        DataHolder.usersList.removeIf(i -> i.getId().equals(id));
    }

    public Optional<User> save(String name, String surname, String email
    ) {
        DataHolder.usersList.removeIf(i -> i.getName().equals(name));
        User user = new User(name, surname, email);
        DataHolder.usersList.add(user);
        return Optional.of(user);
    }

}
