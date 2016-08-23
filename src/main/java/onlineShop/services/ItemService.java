package onlineShop.services;

import onlineShop.dao.ItemRepository;
import onlineShop.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Damian Bartos
 * 23.08.2016.
 */
@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item createItem(long itemCode, String name, BigDecimal price){
        Item item = new Item(itemCode, name, price);
        return itemRepository.save(item);
    }

    public Item getItem(int itemId){
        return itemRepository.findOne(itemId);
    }

    public Item updatePrice(int itemId, BigDecimal newPrice){
        Item item = itemRepository.findOne(itemId);
        item.setPrice(newPrice);
        return itemRepository.save(item);
    }

    public Item updateDescription(int itemId, String description){
        Item item = itemRepository.findOne(itemId);
        item.setDescription(description);
        return itemRepository.save(item);
    }

    public Item updateQuantity(int itemId, long newQuantity){
        Item item = itemRepository.findOne(itemId);
        item.setQuantity(newQuantity);
        return itemRepository.save(item);
    }
}
