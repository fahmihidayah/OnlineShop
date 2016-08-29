package onlineShop.controllers;

import onlineShop.Utils.CurrentlyLoggedUser;
import onlineShop.dao.AddressRepository;
import onlineShop.dao.OrderRepository;
import onlineShop.dao.RoleRepository;
import onlineShop.domain.Item;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import onlineShop.services.ItemService;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by Damian Bartos
 * 20.06.2016.
 */

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ItemService itemService;
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/item")
    public Item items() {
        return itemService.createItem(3213, "item 1", new BigDecimal(12.33));
    }

    @RequestMapping("/or")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String rO(@CurrentlyLoggedUser User user) {
//        orderRepository.delete(1);
        userService.deleteUser(user);
        return "deleted";
    }

    @RequestMapping("test")
    public String test(){
        return "tes32t";
    }

    @RequestMapping("/reg")
    public User reg() {
        return userService.registerUser("damian483", "32sssd11", "damian483@wp.pl", Role.USER());
    }
}
