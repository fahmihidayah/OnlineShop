package onlineShop.controllers;

import onlineShop.dao.AddressRepository;
import onlineShop.dao.OrderRepository;
import onlineShop.dao.RoleRepository;
import onlineShop.domain.Item;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import onlineShop.services.ItemService;
import onlineShop.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserServices userService;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ItemService itemService;
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/item")
    public Item items(){
        return itemService.createItem(3213, "item 1", new BigDecimal(12.33));
    }

    @RequestMapping("/or")
    public String rO(){
        orderRepository.delete(1);
        return "deleted";
    }

    @RequestMapping("/reg")
    public User reg(){
        return userService.registerUser("damian483", "32sssd11", "damian483@wp.pl", Role.USER());
    }
}
