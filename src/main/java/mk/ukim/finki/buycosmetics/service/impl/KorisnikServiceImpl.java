package mk.ukim.finki.buycosmetics.service.impl;

import mk.ukim.finki.buycosmetics.model.Korisnik;
import mk.ukim.finki.buycosmetics.model.Role;
import mk.ukim.finki.buycosmetics.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.buycosmetics.respository.KorisnikRepository;
import mk.ukim.finki.buycosmetics.service.KorisnikService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class KorisnikServiceImpl implements KorisnikService {
    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;
    public KorisnikServiceImpl( KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Korisnik login(String username, String password) {

        return korisnikRepository.findByUsernameAndPassword(username,
                password).orElseThrow();

    }

    @Override
    public Korisnik register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentException();
        }
        if (!password.equals(repeatPassword))
            throw new InvalidArgumentException();
        if (this.korisnikRepository.findByUsername(username).isPresent()
                || !this.korisnikRepository.findByUsername(username).isEmpty()){
            throw new InvalidArgumentException();
        }
        Korisnik korisnik = new Korisnik(username, passwordEncoder.encode(password), name, surname, role);
        return korisnikRepository.save(korisnik);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return korisnikRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException(s));
    }
}
