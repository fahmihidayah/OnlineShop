package onlineShop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private long itemId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "ITEM_CODE", unique = true)
    private long itemCode;

    @NotNull
    @Column(name = "QUANTITY")
    private long quantity;

    @NotNull
    @Column(name = "RESERVED_QUANTITY")
    private long reservedQuantity;

    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

    protected Item() {
    }

    public Item(long itemCode, String name, BigDecimal price) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.reservedQuantity = 0;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(long reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getItemCode() {
        return itemCode;
    }

    public void setItemCode(long itemCode) {
        this.itemCode = itemCode;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", itemCode=" + itemCode +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
