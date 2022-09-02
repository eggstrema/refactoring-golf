package hole6;

import org.junit.jupiter.api.Test;

import static hole6.Money.money;
import static hole6.TaxRate.taxRate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TakeHomeCalculatorTest {

    @Test
    public void canCalculateTax() throws Exception {
        Integer first = new TakeHomeCalculator(taxRate(10)).netAmount(money(40, "GBP"), money(50, "GBP"), money(60, "GBP")).value;
        assertEquals(135, first.intValue());
    }

    @Test
    public void cannotSumDifferentCurrencies() throws Exception {
        assertThatThrownBy(() -> {
            new TakeHomeCalculator(taxRate(10)).netAmount(money(4, "GBP"), money(5, "USD"));
        }).isInstanceOf(Incalculable.class);
    }
}