package com.superdupermarket.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class FreshProduceTest {

    @Test
    public void testQualityDoesntChange() {
        LocalDate today = LocalDate.now();
        FreshProduce freshProduce = new FreshProduce("Apple", today, 100, 50, today.plusDays(10));
        assertEquals(freshProduce.quality(today), freshProduce.quality(today.plusDays(1)));
        assertEquals(freshProduce.quality(today), freshProduce.quality(today.plusDays(10)));
        assertEquals(freshProduce.quality(today), freshProduce.quality(today.plusDays(100)));
    }

    @Test
    public void testPriceReduction() {
        LocalDate today = LocalDate.now();
        FreshProduce freshProduce = new FreshProduce("Apple", today, 100, 0, today.plusDays(10));
        LocalDate checkDate = LocalDate.now().plusDays(6);
        assertEquals(75, freshProduce.dayPrice(checkDate));
        checkDate = LocalDate.now().plusDays(9);
        assertEquals(25, freshProduce.dayPrice(checkDate));
        checkDate = LocalDate.now().plusDays(10);
        assertEquals(0, freshProduce.dayPrice(checkDate));
    }

    @Test
    public void testShouldDispose() {
        LocalDate today = LocalDate.now();
        FreshProduce freshProduce = new FreshProduce("Apple", today, 100, 50, today.plusDays(10));
        LocalDate checkDate = today.plusDays(11);
        assertTrue(freshProduce.shouldDispose(checkDate));
    }

    @Test
    public void testNotShouldDispose() {
        LocalDate today = LocalDate.now();
        FreshProduce freshProduce = new FreshProduce("Apple", today, 100, 50, today.plusDays(10));
        LocalDate checkDate = today.plusDays(3);
        assertFalse(freshProduce.shouldDispose(checkDate));
        checkDate = today.plusDays(10);
        assertFalse(freshProduce.shouldDispose(checkDate));
    }
}
