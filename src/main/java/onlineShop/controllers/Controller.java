package onlineShop.controllers;

import onlineShop.dao.AddressRepository;
import onlineShop.dao.ItemRepository;
import onlineShop.dao.OrderRepository;
import onlineShop.dao.RoleRepository;
import onlineShop.domain.Item;
import onlineShop.domain.Role;
import onlineShop.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Bartos
 * 20.06.2016.
 */

@RestController
public class Controller {

    @Autowired
    UserServices userServices;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;
    @RequestMapping("/i")
    public String items(){
        Item i1 = new Item(1, "item1");
        Item i2 = new Item(2, "item2");
        Item i3 = new Item(3, "item3");
        Item i4 = new Item(4, "item4");
        itemRepository.save(i1);
        itemRepository.save(i2);
        itemRepository.save(i3);
        itemRepository.save(i4);
        return "item added";
    }

    @RequestMapping("/or")
    public String rO(){
        orderRepository.delete(1);
        return "deleted";
    }

    @RequestMapping("/reg")
    public String reg(){
        userServices.registerUser("damian483", "32sssd11", "damian483@wp.pl", Role.USER);
        return "ok\n";
    }
}
