package onlineShop.dao;

import onlineShop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findBySubmitDate(Date submitDate);
    List<Order> findByPaidDate(Date paidDate);
    List<Order> findBySendDate(Date sendDate);
    List<Order> findBySubmitDateBetween(Date from, Date to);
}
