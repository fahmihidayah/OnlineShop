package onlineShop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "USER_ID")
    private long userId;

    @NotNull
    @Column(name = "SUBMIT_DATE")
    private Date submitDate;

    @Column(name = "PAID_DATE")
    private Date paidDate;

    @Column(name = "SEND_DATE")
    private Date sendDate;

    @ManyToMany
    @JoinColumn(name = "ITEM_ID")
    private List<ItemQuantity> items;

    protected Order() {
        items = new LinkedList<>();
    }

    public Order(Date submitDate) {
        this.submitDate = submitDate;
        items = new LinkedList<>();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sentDate) {
        this.sendDate = sentDate;
    }

    public List<ItemQuantity> getItems() {
        return items;
    }

    public void setItems(List<ItemQuantity> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", submitDate=" + submitDate +
                ", paidDate=" + paidDate +
                ", sendDate=" + sendDate +
                ", items=" + items +
                '}';
    }
}
