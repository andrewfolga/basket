package creditsuisse.domain;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.when;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TillTest {

    @Mock
    private ItemsScanner itemsScanner;
    @InjectMocks
    private Till till = new Till();

    @Test
    public void shouldGiveTotalNoPromo() throws Exception {
        Basket basket = new Basket();
        basket.addAll(
                new Item("Apples", new BigDecimal("0.35")),
                new Item("Bananas", new BigDecimal("0.20")));
        String[] items = new String[] {"Apples", "Bananas"};
        when(itemsScanner.scanItems(items)).thenReturn(basket);
        List<Promotion> promotions = emptyList();

        BigDecimal result = till.scan(items, promotions);

        Assert.assertThat(result, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("0.55"))));
    }

    @Test
    public void shouldGiveNoTotalIfBasketEmptyNoPromo() throws Exception {
        Basket basket = new Basket();
        List<Promotion> promotions = asList(
                new Promotion("Melons", 2, 1),
                new Promotion("Limes", 3, 2));
        String[] items = new String[] {"Apples", "Bananas"};
        when(itemsScanner.scanItems(items)).thenReturn(basket);

        BigDecimal result = till.scan(items, promotions);

        Assert.assertThat(result, CoreMatchers.is(CoreMatchers.equalTo(BigDecimal.ZERO)));
    }

    @Test
    public void shouldGiveTotalWithPromo() throws Exception {

        Basket basket = new Basket();
        basket.addAll(
                new Item("Apples", new BigDecimal("0.35")),
                new Item("Apples", new BigDecimal("0.35")),
                new Item("Apples", new BigDecimal("0.35")),
                new Item("Bananas", new BigDecimal("0.20")),
                new Item("Bananas", new BigDecimal("0.20")),
                new Item("Melons", new BigDecimal("0.50")),
                new Item("Melons", new BigDecimal("0.50")),
                new Item("Limes", new BigDecimal("0.15")),
                new Item("Limes", new BigDecimal("0.15")),
                new Item("Limes", new BigDecimal("0.15")));
        String[] items = new String[] {"Apples", "Apples", "Apples", "Bananas", "Bananas", "Melons", "Melons", "Limes", "Limes", "Limes"};
        when(itemsScanner.scanItems(items)).thenReturn(basket);
        List<Promotion> promotions = asList(
                new Promotion("Melons", 2, 1),
                new Promotion("Limes", 3, 2));

        BigDecimal result = till.scan(items, promotions);

        Assert.assertThat(result, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("2.25"))));
    }


}
