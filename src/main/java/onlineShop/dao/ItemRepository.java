package onlineShop.dao;

import onlineShop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
