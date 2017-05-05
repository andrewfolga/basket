package creditsuisse;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

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


}
