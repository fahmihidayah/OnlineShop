package onlineShop.controllers;

import onlineShop.domain.Item;
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

    @RequestMapping(value = Route.CART_ADD)
    public void addItem(@RequestParam("id") long itemId){
        User user = userService.getCurrentLoggedUser();
        shoppingCartService.addItem(user.getShoppingCart().getShoppingCartId(), itemId);
    }

    @RequestMapping(value = Route.CART_REMOVE)
    public void removeItem(@RequestParam("id") long itemId){
        User user = userService.getCurrentLoggedUser();
        shoppingCartService.removeItem(user.getShoppingCart().getShoppingCartId(), itemId);
    }

    @RequestMapping(value = Route.CART_READ)
    public List<Item> getItemList(){
        User user = userService.getCurrentLoggedUser();
        System.out.println(shoppingCartService.getItemList(user.getShoppingCart().getShoppingCartId()));
        return shoppingCartService.getItemList(user.getShoppingCart().getShoppingCartId());
    }
}
