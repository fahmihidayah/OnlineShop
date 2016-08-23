package onlineShop.services;

import onlineShop.dao.OrderRepository;
import onlineShop.domain.Item;
import onlineShop.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

/**
 * Created by Damian Bartos
 * 23.08.2016.
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemService itemService;

    public Order createOrder(Date submitDate) {
        Order order = new Order(submitDate);
        return orderRepository.save(order);
    }

    public Order paidOrder(int orderId, Date paidData) {
        Order order = orderRepository.findOne(orderId);
        order.setPaidDate(paidData);
        return orderRepository.save(order);
    }

    public Order sendDate(int orderId, Date sendDate) {
        Order order = orderRepository.findOne(orderId);
        order.setSendDate(sendDate);
        return orderRepository.save(order);
    }

    public Order addItem(int orderId, int itemId, int quantity) {
        Order order = orderRepository.findOne(orderId);
        Item item = itemService.getItem(itemId);
        for (int i = 0; i < quantity; i++) {
            order.getItems().add(item);
        }
        return orderRepository.save(order);
    }

    public Order deleteItem(int orderId, int itemId) {
        Order order = orderRepository.findOne(orderId);
        Item item = itemService.getItem(itemId);
        order.getItems().removeAll(Collections.singletonList(item)
        );
        return orderRepository.save(order);
    }
}
