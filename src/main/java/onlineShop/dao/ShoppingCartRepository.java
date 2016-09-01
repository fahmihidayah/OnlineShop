package onlineShop.dao;

import onlineShop.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 01.09.2016.
 */
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
        List<ShoppingCart> findByExpiredDate(Date expiredDate);
}