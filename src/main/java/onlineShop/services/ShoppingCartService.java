package onlineShop.services;

import onlineShop.dao.ShoppingCartRepository;
import onlineShop.domain.Item;
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
        ListIterator<Item> iterator = SC.getItems().listIterator();
        while (iterator.hasNext()){
            itemService.modifyQuantity(iterator.next().getItemId(), +1);
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
    public ShoppingCart addItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        itemService.modifyQuantity(itemId, -1);
        Item item = itemService.getItemById(itemId);
        shoppingCart.getItems().add(item);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        itemService.modifyQuantity(itemId, +1);
        Item item = itemService.getItemById(itemId);
        shoppingCart.getItems().remove(item);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<Item> getItemList(long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        return shoppingCart.getItems();
    }
}
