package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * 
 */
public class FreshProduce extends Product {
    private static final int EXPIRY_DISCOUNT_DAYS = 5;
    private static final int MAXIMUM_DISCOUNT_PERCENTAGE = 75;

    public FreshProduce(String label, LocalDate shelfDate, int basePrice, int baseQuality, LocalDate expiration) {
        super(label, shelfDate, basePrice, baseQuality, expiration);
    }

    @Override
    public int dayPrice(LocalDate checkDate) {
        int price = basePrice + this.quality(checkDate) * 10;
        int discount = this.calculateDiscount(checkDate);
        return price * (100 - discount) / 100;
    }

    @Override
    public boolean shouldDispose(LocalDate checkDate) {
        // Disposal is only dependent on the expiration date for fresh produce
        return this.expiration.isPresent() && checkDate.isAfter(this.expiration.get());
    }

    @Override
    public int quality(LocalDate checkDate) {
        // FreshProduce does not change its quality over time. The quality is
        // based on the size and looks of the product when it is shelved. There
        // can even be negative qualities for damaged or bruised fruit.
        return this.baseQuality;
    }

    private int calculateDiscount(LocalDate checkDate) {
        // Starting from 5 days before expiry a discount of 25% is applied per
        // day up to a maximum of 75% price reduction.
        // On the expiration date the product will be free.
        if (expiration.isPresent()) {
            long daysToExpiry = ChronoUnit.DAYS.between(checkDate, this.expiration.get());
            if (daysToExpiry <= 0) {
                return 100;
            }
            if (daysToExpiry <= EXPIRY_DISCOUNT_DAYS) {
                return (int) Math.min(25 * (EXPIRY_DISCOUNT_DAYS - daysToExpiry), MAXIMUM_DISCOUNT_PERCENTAGE);
            }
        }
        return 0;
    }
}
