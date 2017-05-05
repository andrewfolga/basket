package creditsuisse.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class ItemsScanner {

    private Map<String, BigDecimal> itemsPricing = new HashMap<>();

    public Basket scanItems(String... itemsNames) {
        Basket basket = new Basket();
        List<Item> items = asList(itemsNames).stream().
                map(name -> new Item(name, itemsPricing.get(name))).collect(Collectors.toList());
        basket.addAll(items);
        return basket;
    }

    public void addItemPrice(String name, BigDecimal price) {
        itemsPricing.put(name, price);
    }
}
