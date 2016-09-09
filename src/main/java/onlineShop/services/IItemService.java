package onlineShop.services;

import onlineShop.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Damian Bartos
 * 31.08.2016.
 */
public interface IItemService {
    Item create(Item item);

    void deleteItemById(long itemId);

    boolean exist(long itemId);

    Page<Item> getAllItems(Pageable pageable);

    List<Item> getAllItems();

    long maxItems();

    Item getItemById(long itemId);

    List<Item> getItemsByName(String name);

    Item updateItemById(long itemId, Item itemData);

    Item updateQuantity(long itemId, long newQuantity);

}
