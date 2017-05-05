package creditsuisse.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Item {

    public static final int QUANTITY_ONE = 1;
    private final String name;
    private final BigDecimal price;
    private final Integer quantity;

    public Item(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String name, BigDecimal price) {
        this(name, price, QUANTITY_ONE);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(price, item.price) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
