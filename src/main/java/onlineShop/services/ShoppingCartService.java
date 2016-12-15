package onlineShop.services;

import onlineShop.dao.ItemQuantityRepository;
import onlineShop.dao.ShoppingCartRepository;
import onlineShop.domain.Item;
import onlineShop.domain.ItemQuantity;
import onlineShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Damian Bartos
 * 01.09.2016.
 */
@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ItemQuantityRepository itemQuantityRepository;

    @Autowired
    ItemService itemService;

    @Override
    public ShoppingCart create() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCartById(long shoppingCartId) {
        shoppingCartRepository.delete(shoppingCartId);
    }

    @Override
    public boolean exist(long shoppingCartId) {
        return shoppingCartRepository.exists(shoppingCartId);
    }

    @Override
    public void clearShoppingCartAfterOrder(long shoppingCartId) {
        ShoppingCart SC = shoppingCartRepository.findOne(shoppingCartId);
        SC.setItems(new LinkedList<>());
        shoppingCartRepository.save(SC);
    }

    @Override
    public void clearShoppingCartWithReturn(long shoppingCartId) {
        ShoppingCart SC = shoppingCartRepository.findOne(shoppingCartId);
        ListIterator<ItemQuantity> iterator = SC.getItems().listIterator();
        while (iterator.hasNext()){
            itemService.modifyQuantity(iterator.next().getItem().getItemId(), +1);
            iterator.remove();
        }
//        for(int i=0; i<SC.getItems().size(); i++){
//            Item item = SC.getItems().;
//            itemService.modifyQuantity(item.getItemId(), +1);
//        }
        shoppingCartRepository.save(SC);
    }

    @Override
    public ShoppingCart updateShoppingCartById(long shoppingCartId, ShoppingCart shoppingCartData) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        //TODO: Check if it will works
        shoppingCart.setItems(shoppingCartData.getItems());
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCartById(long shoppingCartId) {
        return shoppingCartRepository.findOne(shoppingCartId);
    }

    @Override
    public ShoppingCart addSingleItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        itemService.modifyQuantity(itemId, -1);
        Item item = itemService.getItemById(itemId);
        ItemQuantity itemQuantity;
        try {
            itemQuantity = shoppingCart.getItems().stream().filter(itemQuantity1 -> itemQuantity1.getItem().equals(item)).findFirst().get();
            itemQuantity.setQuantity(itemQuantity.getQuantity() + 1);
            itemQuantityRepository.save(itemQuantity);
        } catch (Exception e) {
            itemQuantity = new ItemQuantity();
            itemQuantity.setItem(item);
            itemQuantity.setQuantity(1);
            itemQuantity = itemQuantityRepository.save(itemQuantity);
            shoppingCart.getItems().add(itemQuantity);
        }
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeSingleItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        itemService.modifyQuantity(itemId, +1);
        ItemQuantity itemQuantity = shoppingCart.getItems().stream().filter(itemQuantityTemp -> itemQuantityTemp.getItem().getItemId() == itemId).findFirst().get();
        itemQuantity.setQuantity(itemQuantity.getQuantity() - 1);
        itemQuantityRepository.save(itemQuantity);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ItemQuantity> getItemList(long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        return shoppingCart.getItems();
    }

    @Override
    public ShoppingCart deleteItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        Item item = itemService.getItemById(itemId);
        ItemQuantity itemQuantity = shoppingCart.getItems().stream().filter(itemQuantity1 -> itemQuantity1.getItem().equals(item)).findFirst().get();
        itemService.modifyQuantity(itemId, itemQuantity.getQuantity());
        shoppingCart.getItems().remove(itemQuantity);
        itemQuantityRepository.delete(itemQuantity);
        return null;
    }
}
