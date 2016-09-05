package onlineShop.controllers;

import onlineShop.domain.Item;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damian Bartos
 * 05.09.2016.
 */
@RestController
public class MyAuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test/test")
    public User test(@RequestBody User user){
        User newUser = new User(user.getLogin(), user.getPassword(), user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setRole(Role.USER());
        userService.create(newUser);
        System.out.println(newUser);
        return user;
    }

    @RequestMapping(value = "/test/item", method = RequestMethod.POST)
    public void test2(@RequestBody Item item){
        System.out.println(item);
    }

}
