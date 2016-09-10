package onlineShop.controllers;

import onlineShop.domain.Role;
import onlineShop.domain.ShoppingCart;
import onlineShop.domain.User;
import onlineShop.routes.Route;
import onlineShop.services.ShoppingCartService;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Damian Bartos
 * 05.09.2016.
 */
@RestController
public class MyAuthController {

    @Autowired
    UserService userService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/user")
    public Principal user(Principal user){
        return user;
    }

    @RequestMapping(value = Route.REGISTER, method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        User newUser = new User(user.getUserName(), user.getPassword(), user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setRole(Role.USER());
        ShoppingCart sc = shoppingCartService.create();
        newUser.setShoppingCart(sc);
        userService.create(newUser);
        return user;
    }
}
