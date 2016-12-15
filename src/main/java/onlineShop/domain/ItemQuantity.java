package onlineShop.domain;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_QUANTITY")
public class ItemQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_QUANTITY_ID")
    private long id;

    @OneToOne
    @CollectionTable(name = "ITEM")
    private Item item;

    @Column(name = "QUANTITY")
    private long quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
