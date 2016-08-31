package onlineShop.services;

import onlineShop.dao.OrderRepository;
import onlineShop.domain.Item;
import onlineShop.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 23.08.2016.
 */
@Service
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemService itemService;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderRepository.delete(orderId);
    }

    @Override
    public boolean exist(long orderId) {
        return orderRepository.exists(orderId);
    }

    @Override
    public List<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).getContent();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public List<Order> getOrdersBySubmitDate(Date submitDate) {
        return orderRepository.findBySubmitDate(submitDate);
    }

    @Override
    public List<Order> getOrdersByPaidDate(Date paidDate) {
        return orderRepository.findByPaidDate(paidDate);
    }

    @Override
    public List<Item> getItemsByOrderId(long orderId) {
        return orderRepository.findOne(orderId).getItems();
    }

    @Override
    public Order makePaid(long orderId, Date paidDate) {
        Order order = orderRepository.findOne(orderId);
        order.setPaidDate(paidDate);
        return orderRepository.save(order);
    }

    @Override
    public Order makeSent(long orderId, Date sentDate) {
        Order order = orderRepository.findOne(orderId);
        order.setSentDate(sentDate);
        return orderRepository.save(order);
    }

//    public Order deleteItem(int orderId, int itemId) {
//        Order order = orderRepository.findOne(orderId);
//        Item item = itemService.getItem(itemId);
//        order.getItems().removeAll(Collections.singletonList(item)
//        );
//        return orderRepository.save(order);
//    }
}
