package creditsuisse.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Till {

    private ItemsScanner itemsScanner;

    public BigDecimal scan(String[] items, List<Promotion> promotions) {
        Basket basket = itemsScanner.scanItems(items);
        return basket.calculateTotalCost(promotions);
    }
}
