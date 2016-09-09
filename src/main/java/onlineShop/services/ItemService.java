package onlineShop.services;

import onlineShop.dao.ItemRepository;
import onlineShop.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Bartos
 * 23.08.2016.
 */
@Service
public class ItemService implements IItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item create(Item item) {
        //TODO: add validation
        return itemRepository.save(item);
    }

    @Override
    public void deleteItemById(long itemId) {
        Item item = itemRepository.findOne(itemId);
        itemRepository.delete(item);
    }

    @Override
    public boolean exist(long itemId) {
        return itemRepository.exists(itemId);
    }

    @Override
    public Page<Item> getAllItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @Override
    public long maxItems() {
        return itemRepository.count();
    }

    @Override
    public Item getItemById(long itemId) {
        return itemRepository.findOne(itemId);
    }

    @Override
    public List<Item> getItemsByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public Item updateItemById(long itemId, Item itemData) {
        Item item = itemRepository.findOne(itemId);
        item.setPrice(itemData.getPrice());
        item.setQuantity(itemData.getQuantity());
        item.setDescription(itemData.getDescription());
        item.setItemCode(itemData.getItemCode());
        item.setName(itemData.getName());
        return itemRepository.save(item);
    }

    @Override
    public Item updateQuantity(long itemId, long newQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setQuantity(newQuantity);
        return itemRepository.save(item);
    }
}
