package creditsuisse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Basket {

    private final List<Item> items = new ArrayList<Item>();

    public void add(Item item) {
        items.add(item);
    }


    public void addAll(Item... items) {
        asList(items).stream().forEach(item -> add(item));
    }

    public BigDecimal calculateTotalCost(List<Promotion> promotions) {

        return BigDecimal.ZERO;
    }
}
