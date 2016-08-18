package onlineShop.controllers;

import onlineShop.dao.UserRepository;
import onlineShop.domain.User;
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

    @RequestMapping("/b")
    @ResponseBody
    public String bb(){
        List<User> bartos = userRepository.findByLastName("bartos");
        String out = "";
        for (User barto : bartos) {
            out += barto.getFirstName() + ";";
        }

        return out;
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        List<User> bartos = userRepository.findAll();
        String out = "";
        for (User barto : bartos) {
            out += barto.getFirstName() + ";";
        }

        return out;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        User u1 = new User("damian", "bartos");
//        User u2 = new User("maciej", "bartos");
        userRepository.save(u1);
//        userRepository.save(u2);
        return "done";
    }

}
