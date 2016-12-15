package onlineShop.domain;

import javax.persistence.*;
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

    @ManyToMany
    @JoinColumn(name = "ITEM_ID")
    private List<ItemQuantity> items;

    public ShoppingCart() {
        items = new LinkedList<>();
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public List<ItemQuantity> getItems() {
        return items;
    }

    public void setItems(List<ItemQuantity> items) {
        this.items = items;
    }
}
