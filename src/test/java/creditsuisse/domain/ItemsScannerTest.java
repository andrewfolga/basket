package creditsuisse.domain;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class ItemsScannerTest {

    private ItemsScanner itemsScanner = new ItemsScanner();

    @Test
    public void shouldScanItems() throws Exception {

        itemsScanner.addItemPrice("Apples", new BigDecimal("0.35"));
        itemsScanner.addItemPrice("Bananas", new BigDecimal("0.20"));

        Basket basket = itemsScanner.scanItems("Apples", "Apples", "Bananas");

        assertTrue(basket.hasItems(items -> {
            return items.containsAll(Arrays.asList(
                    new Item("Apples", new BigDecimal("0.35")),
                    new Item("Apples", new BigDecimal("0.35")),
                    new Item("Bananas", new BigDecimal("0.20"))));
        }));
    }

    @Test
    public void shouldNotScanEmptyItems() throws Exception {

        itemsScanner.addItemPrice("Apples", new BigDecimal("0.35"));
        itemsScanner.addItemPrice("Bananas", new BigDecimal("0.20"));

        Basket basket = itemsScanner.scanItems();

        assertTrue(basket.hasItems( items -> {
            return items.isEmpty();
        }));
    }
}