package onlineShop.controllers;

import onlineShop.Routes.Route;
import onlineShop.Utils.PasswordUtils;
import onlineShop.domain.Role;
import onlineShop.domain.User;
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
        System.out.println(user);
        //TODO: hash password
        String hashedPassword = PasswordUtils.hash(user.getHashedPassword());
        user = userService.registerUser(user.getLogin(), hashedPassword, user.getEmail(), Role.USER());
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
