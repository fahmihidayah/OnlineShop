package onlineShop.controllers;

import onlineShop.domain.Item;
import onlineShop.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damian Bartos
 * 05.09.2016.
 */
@RestController
public class MyAuthController {

    @RequestMapping(value = "/test/test")
    public User test(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/test/item", method = RequestMethod.POST)
    public void test2(@RequestBody Item item){
        System.out.println(item);
    }

}
