package creditsuisse;

import java.math.BigDecimal;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Item {

    private final String name;
    private final BigDecimal bigDecimal;

    public Item(String name, BigDecimal bigDecimal) {
        this.name = name;
        this.bigDecimal = bigDecimal;
    }
}
