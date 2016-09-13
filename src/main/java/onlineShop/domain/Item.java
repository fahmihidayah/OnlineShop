package onlineShop.domain;

import javax.persistence.*;
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

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ITEM_CODE", unique = true)
    private long itemCode;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "IMAGE")
    private byte[] image;

    @Column(name = "enabled")
    private boolean enabled;

    protected Item() {
        enabled = true;
    }

    public Item(long itemCode, String name, BigDecimal price) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.enabled = true;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
