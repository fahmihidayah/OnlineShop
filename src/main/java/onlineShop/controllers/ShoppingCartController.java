package onlineShop.controllers;

import onlineShop.domain.ItemQuantity;
import onlineShop.domain.User;
import onlineShop.routes.Route;
import onlineShop.services.ShoppingCartService;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Damian Bartos
 * 09.09.2016.
 */
@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    UserService userService;

    @RequestMapping(value = Route.CART_ADD_SINGLE_ITEM)
    public void addItem(@RequestParam("id") long itemId){
        User user = userService.getCurrentLoggedUser();
        shoppingCartService.addSingleItem(user.getShoppingCart().getShoppingCartId(), itemId);
    }

    @RequestMapping(value = Route.CART_REMOVE_SINGLE_ITEM)
    public void removeItem(@RequestParam("id") long itemId){
        User user = userService.getCurrentLoggedUser();
        shoppingCartService.removeSingleItem(user.getShoppingCart().getShoppingCartId(), itemId);
    }

    @RequestMapping(value = Route.CART_ITEM_REMOVE)
    public void deleteItem(@RequestParam("id") long itemId){
        User user = userService.getCurrentLoggedUser();
        shoppingCartService.deleteItem(user.getShoppingCart().getShoppingCartId(), itemId);
    }

    @RequestMapping(value = Route.CART_READ)
    public List<ItemQuantity> getItemList(){
        User user = userService.getCurrentLoggedUser();
        return shoppingCartService.getItemList(user.getShoppingCart().getShoppingCartId());
    }
}
