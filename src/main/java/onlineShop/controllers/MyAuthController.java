package onlineShop.controllers;

import onlineShop.domain.Role;
import onlineShop.domain.User;
import onlineShop.routes.Route;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Bartos
 * 05.09.2016.
 */
@RestController
public class MyAuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = Route.REGISTER, method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        User newUser = new User(user.getUserName(), user.getPassword(), user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setRole(Role.USER());
        System.out.println(newUser);
        userService.create(newUser);
        return user;
    }
}
