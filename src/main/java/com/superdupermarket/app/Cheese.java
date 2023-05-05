package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cheese extends Product {
    private static int minimumbaseQuality = 30;

    public Cheese(
            String label,
            LocalDate shelfDate,
            int basePrice,
            int baseQuality,
            LocalDate expiration) {
        super(label, shelfDate, basePrice, baseQuality, expiration);
    }

    @Override
    public String toString() {
        return "Cheese-" + super.toString();
    }

    @Override
    boolean shouldDispose(LocalDate checkDate) {
        return this.quality(checkDate) < Cheese.minimumbaseQuality
                || this.expiration.map(expiration -> !expiration.isAfter(checkDate)).orElse(false);
    }

    @Override
    int quality(LocalDate checkDate) {
        long daysBetween = ChronoUnit.DAYS.between(this.shelfDate, checkDate);
        return (int) Math.max(baseQuality - daysBetween, 0);
    }
}
