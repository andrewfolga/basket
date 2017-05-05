package creditsuisse;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class ScannerTest {

    Scanner scanner = new Scanner();

    @Test
    public void shouldScanStandardItems() throws Exception {

        Basket basket = new Basket();
        basket.addAll(new Item("Apples", new BigDecimal("0.35")), new Item("Bananas", new BigDecimal("0.20")));
        List<Promotion> promotions = emptyList();

        BigDecimal result = scanner.scan(basket, promotions);

        Assert.assertThat(result, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("0.55"))));
    }

    @Test
    public void shouldScanStandardAndPromoItems() throws Exception {

        Basket basket = new Basket();
        basket.addAll(
                new Item("Apples", new BigDecimal("0.35")),
                new Item("Bananas", new BigDecimal("0.20")),
                new Item("Melons", new BigDecimal("0.50")),
                new Item("Melons", new BigDecimal("0.50")),
                new Item("Melons", new BigDecimal("0.50")),
                new Item("Melons", new BigDecimal("0.50")),
                new Item("Limes", new BigDecimal("0.15")),
                new Item("Limes", new BigDecimal("0.15")),
                new Item("Limes", new BigDecimal("0.15")));
        List<Promotion> promotions = asList(
                new Promotion("Melons", 2, 1),
                new Promotion("Limes", 3, 2));

        BigDecimal result = scanner.scan(basket, promotions);

        Assert.assertThat(result, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("1.85"))));
    }


}
