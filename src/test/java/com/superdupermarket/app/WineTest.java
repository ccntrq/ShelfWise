package com.superdupermarket.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;

import org.junit.Test;

public class WineTest {

    @Test
    public void testShouldDispose() {
        LocalDate today = LocalDate.now();
        Wine wine = new Wine("Riesling", today, 1099, 50);
        assertFalse(wine.shouldDispose(today));

        assertFalse(wine.shouldDispose(today.plusDays(50)));
    }

    @Test
    public void testQuality() {
        LocalDate today = LocalDate.now();
        Wine wine = new Wine("Riesling", today, 1099, 10);
        assertEquals(11, wine.quality(today.plusDays(10)));
        assertEquals(50, wine.quality(today.plusDays(2000)));
    }

    @Test
    public void testDailyPrice() {
        LocalDate today = LocalDate.now();
        Wine wine = new Wine("Riesling", today, 1099, 50);
        assertEquals(1599, wine.dayPrice(today.plusDays(5)) );
    }

    @Test
    public void testPriceDoesNotChangeOverTime() {
        LocalDate today = LocalDate.now();
        Wine wine = new Wine("Riesling", today, 1099, 50);
        assertEquals(wine.dayPrice(today), wine.dayPrice(today.plusDays(50)));
    }
}
