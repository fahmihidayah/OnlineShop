package onlineShop.controllers;

import onlineShop.domain.ItemQuantity;
import onlineShop.domain.Order;
import onlineShop.domain.User;
import onlineShop.routes.Route;
import onlineShop.services.OrderService;
import onlineShop.services.ShoppingCartService;
import onlineShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 09.09.2016.
 */
@RestController
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(value = Route.ORDER_CREATE)
    public void makeOrder(){
        User user = userService.getCurrentLoggedUser();
        Order order = new Order(new Date());
        List<ItemQuantity> items = shoppingCartService.getItemList(user.getShoppingCart().getShoppingCartId());
        order.setUserId(user.getUserId());
        for (ItemQuantity item : items) {
            order.getItems().add(item);
        }
        orderService.create(order);
        shoppingCartService.clearShoppingCartAfterOrder(user.getShoppingCart().getShoppingCartId());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.ORDER_READ)
    public List<Order> allOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping(value = Route.ORDER_READ_USER)
    public List<Order> userOrders(){
        User user = userService.getCurrentLoggedUser();
        List<Order> orders = orderService.getOrdersByUserId(user.getUserId());
        System.out.println(orders);
        return orders;
    }

    @RequestMapping(value = Route.ORDER_PAID)
    public Order paidOrder(@RequestParam("id") long orderId){
        return orderService.makePaid(orderId, new Date());
    }

    @RequestMapping(value = Route.ORDER_SEND)
    public Order sendOrder(@RequestParam("id") long orderId){
        return orderService.makeSent(orderId, new Date());
    }
}
