package onlineShop.services;

import onlineShop.domain.ItemQuantity;
import onlineShop.domain.ShoppingCart;

import java.util.List;

/**
 * Created by Damian Bartos
 * 01.09.2016.
 */
public interface IShoppingCartService {
    ShoppingCart create();

    void deleteShoppingCartById(long shoppingCartId);

    boolean exist(long shoppingCartId);

    void clearShoppingCartAfterOrder(long shoppingCartId);

    void clearShoppingCartWithReturn(long shoppingCartId);

    ShoppingCart updateShoppingCartById(long shoppingCartId, ShoppingCart shoppingCartData);

    ShoppingCart getShoppingCartById(long shoppingCartId);

    ShoppingCart addSingleItem(long shoppingCartId, long itemId);

    ShoppingCart removeSingleItem(long shoppingCartId, long itemId);

    List<ItemQuantity> getItemList(long shoppingCartId);

    ShoppingCart deleteItem(long shoppingCartId, long itemId);
}
