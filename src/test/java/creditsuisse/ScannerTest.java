package creditsuisse;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class ScannerTest {

    Scanner scanner = new Scanner();

    @Test
    public void shouldScanStandardItems() throws Exception {

        Basket basket = new Basket(new Item("Apples", new BigDecimal("0.35")), new Item("Bananas", new BigDecimal("0.20")));

        BigDecimal result = scanner.scan(basket);

        Assert.assertThat(result, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("0.55"))));
    }
}
