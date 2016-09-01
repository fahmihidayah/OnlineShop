package onlineShop.services;

import onlineShop.domain.Item;
import onlineShop.domain.ShoppingCart;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 01.09.2016.
 */
public interface IShoppingCartService {
    ShoppingCart create(Date expiredDate);

    void deleteShoppingCartById(long shoppingCartId);

    boolean exist(long shoppingCartId);

    ShoppingCart updateShoppingCartById(long shoppingCartId, ShoppingCart shoppingCartData);

    ShoppingCart getShoppingCartById(long shoppingCartId);

    List<ShoppingCart> getShoppingCartsThatExpiredAt(Date expiredDate);

    ShoppingCart addItem(long shoppingCartId, long itemId);

    ShoppingCart removeItem(long shoppingCartId, long itemId);

    List<Item> getItemList(long shoppingCartId);
}
