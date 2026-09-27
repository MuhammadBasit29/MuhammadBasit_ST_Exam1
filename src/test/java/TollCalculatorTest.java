import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TollCalculatorTest {

    private final TollCalculator calculator = new TollCalculator();

    // TC01 - EP / Decision Table R1

    @Test
    void TC01_invalidWeight_zero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateDiscount(0, false, false)
        );
    }

    // TC02 - BVA
    // Just below 0
    @Test
    void TC02_belowZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateDiscount(-1, false, false)
        );
    }

    // TC03 - BVA
    // Just above 0
     @Test
    void TC03_justAboveZero() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(1, false, false)
        );
    }


    // TC04 - EP / Decision Table R2
    // Tier 1: neither EV nor carpool
    @Test
    void TC04_tier1_neither() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(600, false, false)
        );
    }

    // TC05 - Decision Table R3
    // Tier 1: EV only
    @Test
    void TC05_tier1_EVOnly() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(600, true, false)
        );
    }

    // TC06 - Decision Table R4
    // Tier 1: carpool only
    @Test
    void TC06_tier1_carpoolOnly() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(600, false, true)
        );
    }

    // TC07 - Decision Table R5
    // Tier 1: EV + carpool
    @Test
    void TC07_tier1_EVAndCarpool() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(600, true, true)
        );
    }

    // TC08 - BVA
    // Just below 1200
    @Test
    void TC08_justBelow1200() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(1199, false, false)
        );
    }


    // TC09 - BVA
    // Exactly 1200
    @Test
    void TC09_weight1200() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(1200, true, true)
        );
    }

    // TC10 - BVA
    // Just above 1200
    @Test
    void TC10_justAbove1200() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(1201, false, false)
        );
    }


    // TC11 - EP / Decision Table R6
    // Tier 2: neither EV nor carpool
    @Test
    void TC11_tier2_neither() {
        assertEquals(
                0.0,
                calculator.calculateDiscount(2000, false, false)
        );
    }

    // TC12 - Decision Table R7
    // Tier 2: EV only
    @Test
    void TC12_tier2_EVOnly() {
        assertEquals(
                0.10,
                calculator.calculateDiscount(2000, true, false)
        );
    }

    // TC13 - Decision Table R8
    // Tier 2: carpool only
    @Test
    void TC13_tier2_carpoolOnly() {
        assertEquals(
                0.10,
                calculator.calculateDiscount(2000, false, true)
        );
    }

    // TC14 - EP / Decision Table R9
    // Tier 2: EV + carpool
    @Test
    void TC14_tier2_EVAndCarpool() {
        assertEquals(
                0.15,
                calculator.calculateDiscount(2000, true, true)
        );
    }

    // TC15 - BVA
    // Just below 3500
    @Test
    void TC15_justBelow3500() {
        assertEquals(
                0.15,
                calculator.calculateDiscount(3499, true, true)
        );
    }

    // TC16 - BVA
    // Exactly 3500
    @Test
    void TC16_weight3500() {
        assertEquals(
                0.15,
                calculator.calculateDiscount(3500, true, true)
        );
    }


    // TC17 - BVA
    // Just above 3500
    @Test
    void TC17_justAbove3500() {
        assertEquals(
                0.25,
                calculator.calculateDiscount(3501, true, true)
        );
    }


    // TC18 - EP / Decision Table R10
    // Tier 3: neither EV nor carpool
    @Test
    void TC18_tier3_neither() {
        assertEquals(
                0.05,
                calculator.calculateDiscount(4000, false, false)
        );
    }


    // TC19 - Decision Table R11
    // Tier 3: EV only
    @Test
    void TC19_tier3_EVOnly() {
        assertEquals(
                0.05,
                calculator.calculateDiscount(4000, true, false)
        );
    }


    // TC20 - Decision Table R12
    // Tier 3: carpool only
    @Test
    void TC20_tier3_carpoolOnly() {
        assertEquals(
                0.05,
                calculator.calculateDiscount(4000, false, true)
        );
    }

    // TC21 - EP / Decision Table R13
    // Tier 3: EV + carpool
    @Test
    void TC21_tier3_EVAndCarpool() {
        assertEquals(
                0.25,
                calculator.calculateDiscount(4000, true, true)
        );
    }
}