package onlineShop.controllers;

import onlineShop.dao.AddressRepository;
import onlineShop.dao.RoleRepository;
import onlineShop.dao.UserRepository;
import onlineShop.domain.Address;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import onlineShop.utility.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
