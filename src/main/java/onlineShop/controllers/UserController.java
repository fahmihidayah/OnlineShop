package onlineShop.controllers;

import onlineShop.domain.User;
import onlineShop.routes.Route;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @RequestMapping(value = Route.USER_LIST)
//    public List<User> getAllUser(Pageable pageable){
//        return userService.getAllUsers(pageable);
//    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.USER_LIST)
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.USER_READ)
    public User getUserById(@RequestParam("id") long userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value = Route.USER_UPDATE)
    public User updateUser(@RequestBody User user){
        long userId = userService.getCurrentLoggedUser().getUserId();
        return userService.updateUserById(userId, user);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.USER_DELETE)
    public void deleteUser(@RequestParam("id") long userId){
        userService.deleteUserById(userId);
    }
}
