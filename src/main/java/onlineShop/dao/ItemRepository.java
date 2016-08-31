package onlineShop.dao;

import onlineShop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);
    List<Item> findByItemCode(long itemCode);
    List<Item> findByPrice(BigDecimal price);
    List<Item> findByPriceGreaterThan(BigDecimal price);
    List<Item> findByPriceLessThan(BigDecimal price);
    List<Item> findByPriceBetween(BigDecimal fromPrice, BigDecimal toPrice);
}
