package onlineShop.services;

import onlineShop.domain.ItemQuantity;
import onlineShop.domain.Order;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 31.08.2016.
 */
public interface IOrderService {
    Order create(Order order);

    void deleteOrderById(long orderId);

    boolean exist(long orderId);

    List<Order> getAllOrders(Pageable pageable);

    List<Order> getAllOrders();

    Order getOrderById(long orderId);

    List<Order> getOrdersByUserId(long userId);

    List<Order> getOrdersBySubmitDate(Date submitDate);

    List<Order> getOrdersByPaidDate(Date paidDate);

    List<ItemQuantity> getItemsByOrderId(long orderId);

//    Order addItemToOrder(long orderId, long itemId, long quantity);
//    Order deleteItemFromOrder(long orderId, long itemId);

    void addItem(long orderId, long itemId);

    Order makePaid(long orderId, Date paidDate);

    Order makeSent(long orderId, Date sentDate);
}
