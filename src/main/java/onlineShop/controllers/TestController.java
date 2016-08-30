package onlineShop.controllers;

import onlineShop.dao.AddressRepository;
import onlineShop.dao.OrderRepository;
import onlineShop.dao.RoleRepository;
import onlineShop.domain.Address;
import onlineShop.services.ItemService;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Bartos
 * 20.06.2016.
 */

@RestController
public class TestController {

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

    @RequestMapping("/a")
    public void addA(){
        userService.addAddress(1, new Address("test", "23", "galkow", "321-32"));
    }
    @RequestMapping("/test")
    public void test(){
        addressRepository.delete(1);
    }

}
