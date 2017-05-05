package creditsuisse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Basket {

    private final List<Item> items = new ArrayList<Item>();

    public void add(Item item) {
        items.add(item);
    }

    public void addAll(Item... itemsToAdd) {
        items.addAll(asList(itemsToAdd));
    }

    public BigDecimal calculateTotalCost(List<Promotion> promotions) {

        BigDecimal totalPrice = items.stream().
                map(item -> item.getPrice()).
                reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Item> itemTypeToItem = combineSameItems();

        BigDecimal savings = promotions.stream().
                map(promo -> applyPromo(itemTypeToItem, promo)).
                reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPrice.add(savings);
    }

    private Map<String, Item> combineSameItems() {
        return items.stream().
                collect(toMap(Item::getName,
                        Function.identity(),
                        (item1, item2) -> new Item(
                                                item1.getName(),
                                                item1.getPrice(),
                                                addQuantities(item1, item2))));
    }

    private BigDecimal applyPromo(Map<String, Item> itemTypeToItem, Promotion promo) {
        return promo.apply(itemTypeToItem.get(promo.getItemName()));
    }

    private Integer addQuantities(Item item1, Item item2) {
        return item1.getQuantity() + item2.getQuantity();
    }
}
