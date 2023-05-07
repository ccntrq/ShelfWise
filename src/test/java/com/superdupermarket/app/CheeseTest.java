package com.superdupermarket.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class CheeseTest {

    @Test
    public void testShouldDispose() {
        LocalDate today = LocalDate.now();
        Cheese cheese = new Cheese("Cheddar", today, 399, 50, today.plusDays(10));
        assertFalse(cheese.shouldDispose(today.plusDays(5)));

        cheese = new Cheese("Cheddar", today, 399, 25, today.plusDays(10));
        assertTrue(cheese.shouldDispose(today.plusDays(5)));
    }

    @Test
    public void testQuality() {
        LocalDate today = LocalDate.now();
        Cheese cheese = new Cheese("Cheddar", today, 399, 50, today.plusDays(10));
        assertEquals(45, cheese.quality(today.plusDays(5)));
    }

    @Test
    public void testDailyPrice() {
        LocalDate today = LocalDate.now();
        Cheese cheese = new Cheese("Cheddar", today, 399, 50, today.plusDays(10));
        assertEquals(899, cheese.dayPrice(today), 0.01);
    }

    @Test
    public void testPriceChangeOverTime() {
        LocalDate today = LocalDate.now();
        Cheese cheese = new Cheese("Cheddar", today, 399, 50, today.plusDays(10));
        assertEquals(849, cheese.dayPrice(today.plusDays(5)));
    }
}
