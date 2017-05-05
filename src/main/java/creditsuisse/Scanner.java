package creditsuisse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Scanner {

    private final List<Promotion> promotions = new ArrayList<>();

    public BigDecimal scan(Basket basket, List<Promotion> promotions) {

        BigDecimal totalCost = basket.calculateTotalCost(promotions);

        return totalCost;
    }
}
