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
    public Item create(Item itemData) {
        //TODO: add validation
        System.out.println("CREATE ITEM");
        System.out.println(itemData);
        Item newItem = new Item(itemData.getItemCode(), itemData.getName(), itemData.getPrice());
        newItem.setDescription(itemData.getDescription());
        newItem.setQuantity(itemData.getQuantity());
        newItem.setPrice(itemData.getPrice());
        newItem.setImage(itemData.getImage());
        System.out.println(newItem);
        return itemRepository.save(newItem);
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
    public List<Item> getAllItems() {
        return itemRepository.findAll();
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
        System.out.println(itemData);
        Item item = itemRepository.findOne(itemId);
        System.out.println(item);
        item.setPrice(itemData.getPrice());
        item.setQuantity(itemData.getQuantity());
        item.setDescription(itemData.getDescription());
        item.setItemCode(itemData.getItemCode());
        item.setName(itemData.getName());
        item.setImage(itemData.getImage());
        System.out.println(item);
        return itemRepository.save(item);
    }

    @Override
    public Item updateQuantity(long itemId, long newQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setQuantity(newQuantity);
        return itemRepository.save(item);
    }

    @Override
    public Item modifyQuantity(long itemId, long value) {
        Item item = itemRepository.findOne(itemId);
        if(item.getQuantity()==0){
            throw null;
        }else{
            item.setQuantity(item.getQuantity()+value);
            return itemRepository.save(item);
        }
    }
}
