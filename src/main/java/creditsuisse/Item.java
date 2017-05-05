package creditsuisse;

import java.math.BigDecimal;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Item {

    private final String name;
    private final BigDecimal price;
    private final BigDecimal quantity;

    public Item(String name, BigDecimal price, BigDecimal quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String name, BigDecimal price) {
        this(name, price, BigDecimal.ONE);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
