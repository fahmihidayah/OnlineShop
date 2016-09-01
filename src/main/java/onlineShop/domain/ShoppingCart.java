package onlineShop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Damian Bartos
 * 01.09.2016.
 */
@Entity
@Table(name = "SHOPPING_CARTS")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOPPING_CART_ID")
    private long shoppingCartId;

    @NotNull
    @Column(name = "EXPIRED_DATE")
    private Date expiredDate;

    @ManyToMany
    @JoinColumn(name = "ITEM_ID")
    private List<Item> items;

    protected ShoppingCart(){
        items = new LinkedList<>();
    }

    public ShoppingCart(Date expiredDate) {
        this();
        this.expiredDate = expiredDate;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
