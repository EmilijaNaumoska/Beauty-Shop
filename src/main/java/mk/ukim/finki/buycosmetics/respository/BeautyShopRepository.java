package mk.ukim.finki.buycosmetics.respository;


import mk.ukim.finki.buycosmetics.model.BeautyShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeautyShopRepository extends JpaRepository<BeautyShop, Long> {
}
