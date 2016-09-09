package onlineShop.controllers;

import onlineShop.domain.Item;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import onlineShop.services.IItemService;
import onlineShop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by Damian Bartos
 * 03.09.2016.
 */
@Controller
public class MainController {
    @Autowired
    IUserService userService;

    @Autowired
    IItemService itemService;

    @RequestMapping(value = "public/initData")
    public void initDataIfNeeded(){
        User user = new User("damian483", "Damian1", "damian483@wp.pl");
        user.setRole(Role.USER());
        user.setFirstName("Damian");
        user.setLastName("Bartos");
        userService.create(user);
        User admin = new User("admin", "Admin", "admin@wp.pl");
        admin.setRole(Role.ADMIN());
        admin.setFirstName("Admin");
        admin.setLastName("Nimda");
        userService.create(admin);

        Item item = new Item(9328, "Testowy Przedmiot", new BigDecimal(123.22));
        item.setQuantity(12);
        item.setDescription("JAKIS TAM OPIS");
        itemService.create(item);
    }

    //TODO: add exclude paths to other than api/*
    public void exclude(){
    }

}
