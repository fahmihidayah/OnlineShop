package onlineShop.controllers;

import onlineShop.domain.User;
import onlineShop.routes.Route;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = Route.REGISTER, method = RequestMethod.POST)
    public String registerUser(@RequestBody User user) {
        return "ok";
    }

    @RequestMapping(value = Route.LOGIN, method = RequestMethod.POST)
    public String loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return "OK";
    }

    @RequestMapping(value = Route.LOGOUT, method = RequestMethod.GET)
    public String logout() {
        return "OK";
    }
}
