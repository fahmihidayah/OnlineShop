package onlineShop.controllers;

import onlineShop.dao.*;
import onlineShop.domain.*;
import onlineShop.utility.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 20.06.2016.
 */

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

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

    @RequestMapping("/o")
    public String order(){
        User u = userRepository.findOne(1);
        Order or = new Order(new Date());

        or.getItems().add(itemRepository.findOne(0));
        or.getItems().add(itemRepository.findOne(1));
        or.getItems().add(itemRepository.findOne(2));
        or.getItems().add(itemRepository.findOne(3));
        or.setUserId(u.getUserId());
        orderRepository.save(or);
        return "order added";
    }

    @RequestMapping("/r")
    public String rem(){
        userRepository.delete(4);
        return "removed";
    }

    @RequestMapping("/b")
    @ResponseBody
    public String bb(){
        List<User> bartos = userRepository.findByLastName("bartos");
        String out = "";
        for (User barto : bartos) {
            System.out.println(barto.getFirstName() + " " + barto.getLastName());
            out += barto.getFirstName() + ";";
        }

        return out;
    }

    @RequestMapping("/a")
    @ResponseBody
    public String aa(){
        List<User> bartos = userRepository.findAll();
        Address a1 = new Address("kasz", "23", "alk", "93-233");
        bartos.get(0).getAddresses().add(a1);
        addressRepository.save(a1);
        userRepository.save(bartos.get(0));
        return "done";
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        List<User> bartos = userRepository.findAll();
        String out = "";
        for (User barto : bartos) {
            System.out.println(barto.getFirstName() + " " + barto.getLastName());
            out += barto.getFirstName() + ";";
        }

        return out;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        User u = new User("login", "pass", "mail");
        u.setLastName("bartos");
        u.setFirstName("damian");
        Address a = new Address("kasztanowa", "4", "95-041", "95-041");
        u.getAddresses().add(a);
        Role role = new Role(RoleName.ADMIN);
        u.setRole(role);
        userRepository.save(u);
        return "done";
    }

}
