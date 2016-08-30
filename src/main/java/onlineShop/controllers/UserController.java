package onlineShop.controllers;

import onlineShop.Routes.Route;
import onlineShop.domain.User;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = Route.REGISTER, method = RequestMethod.POST)
    public String registerUser(User user) {
        System.out.println(user);
        return "ok";
    }

    @RequestMapping(value = Route.LOGIN, method = RequestMethod.POST)
    public String loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password){
        System.out.println(userName);
        System.out.println(password);
        return "OK";
    }

    @RequestMapping(value = Route.LOGOUT, method = RequestMethod.GET)
    public String logout(){
        return "OK";
    }
}
