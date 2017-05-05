package creditsuisse;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by andrzejfolga on 05/05/2017.
 */
public class Promotion implements Function<Item, BigDecimal> {

    private String itemName;
    private Integer triggerCount;
    private Integer targerCount;

    public Promotion(String itemName, Integer triggerCount, Integer targerCount) {
        this.itemName = itemName;
        this.triggerCount = triggerCount;
        this.targerCount = targerCount;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getTriggerCount() {
        return triggerCount;
    }

    public Integer getTargerCount() {
        return targerCount;
    }

    @Override
    public BigDecimal apply(Item item) {

        return null;
    }
}
