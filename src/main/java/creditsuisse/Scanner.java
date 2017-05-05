package creditsuisse;

import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Scanner {

    public BigDecimal scan(Basket basket, List<Promotion> promotions) {
        return basket.calculateTotalCost(promotions);
    }
}
