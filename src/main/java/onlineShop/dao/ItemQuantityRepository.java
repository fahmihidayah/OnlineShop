package onlineShop.dao;

import onlineShop.domain.Item;
import onlineShop.domain.ItemQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemQuantityRepository extends JpaRepository<ItemQuantity, Long>{
    ItemQuantity findByItem(Item item);
}
