package hole1;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakeHomeCalculatorTest {

    @Test
    public void canCalculateTax() {
        Integer first = new TakeHomeCalculator(10).netAmount(new TakeHomeCalculator.Pair<>(40, "GBP"), new TakeHomeCalculator.Pair<>(50, "GBP"), new TakeHomeCalculator.Pair<>(60, "GBP")).first;
        assertEquals(135, first.intValue());
    }

    @Test
    public void cannotSumDifferentCurrencies() {
        assertThatThrownBy(() -> {
            new TakeHomeCalculator(10).netAmount(new TakeHomeCalculator.Pair<>(4, "GBP"), new TakeHomeCalculator.Pair<>(5, "USD"));
        }).isInstanceOf(Incalculable.class);
    }
}

