package onlineShop.services;

import onlineShop.dao.ShoppingCartRepository;
import onlineShop.domain.Item;
import onlineShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public ShoppingCart create(Date expiredDate) {
        ShoppingCart shoppingCart = new ShoppingCart(expiredDate);
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
    public ShoppingCart updateShoppingCartById(long shoppingCartId, ShoppingCart shoppingCartData) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        //TODO: Check if it will works
        shoppingCart.setItems(shoppingCartData.getItems());
        shoppingCart.setExpiredDate(shoppingCartData.getExpiredDate());
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCartById(long shoppingCartId) {
        return shoppingCartRepository.findOne(shoppingCartId);
    }

    @Override
    public List<ShoppingCart> getShoppingCartsThatExpiredAt(Date expiredDate) {
        return shoppingCartRepository.findByExpiredDate(expiredDate);
    }

    @Override
    public ShoppingCart addItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
        Item item = itemService.getItemById(itemId);
        shoppingCart.getItems().add(item);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeItem(long shoppingCartId, long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findOne(shoppingCartId);
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
