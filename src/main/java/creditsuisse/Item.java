package creditsuisse;

import java.math.BigDecimal;

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
}
