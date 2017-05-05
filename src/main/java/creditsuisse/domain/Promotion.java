package creditsuisse.domain;

import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Promotion implements Function<Item, BigDecimal> {

    private String itemName;
    private Integer triggerQuantity;
    private Integer targetQuantity;

    public Promotion(String itemName, Integer triggerQuantity, Integer targetQuantity) {
        Validate.notNull(triggerQuantity, "Trigger quantity must be provided");
        Validate.notNull(targetQuantity, "Target quantity must be provided");
        this.itemName = itemName;
        this.triggerQuantity = triggerQuantity;
        this.targetQuantity = targetQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getTriggerQuantity() {
        return triggerQuantity;
    }

    public Integer getTargetQuantity() {
        return targetQuantity;
    }

    @Override
    public BigDecimal apply(Item item) {

        BigDecimal savings = BigDecimal.ZERO;
        String name = item.getName();
        Integer quantity = item.getQuantity();

        if (name.equals(itemName) && quantity >= triggerQuantity) {
            BigDecimal price = item.getPrice();
            Integer applyTimes = quantity / triggerQuantity;
            Integer reminderQuantity = quantity % triggerQuantity;

            BigDecimal reminderPrice = new BigDecimal(reminderQuantity).multiply(price);
            BigDecimal promoPrice = calculatePromoPrice(price, applyTimes, reminderPrice);
            BigDecimal totalPrice = price.multiply(new BigDecimal(quantity));

            savings = promoPrice.subtract(totalPrice);
        }

        return savings;
    }

    private BigDecimal calculatePromoPrice(BigDecimal price, Integer applyTimes, BigDecimal reminderPrice) {
        return price.
                multiply(new BigDecimal(targetQuantity)).
                multiply(new BigDecimal(applyTimes)).
                add(reminderPrice);
    }
}
