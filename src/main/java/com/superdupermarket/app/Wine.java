package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wine extends Product {
    public Wine(String label, LocalDate shelfDate, int basePrice, int baseQuality) {
        super(label, shelfDate, basePrice, baseQuality, null);
    }

    @Override
    public String toString() {
        return "Wine-" + super.toString();
    }

    @Override
    public int dayPrice(LocalDate checkDate) {
        // The price for Wine is based on the baseQuality not the actual quality. This
        // differs from other products
        return this.basePrice + this.baseQuality * 10;
    }

    @Override
    boolean shouldDispose(LocalDate date) {
        return this.baseQuality < 0;
    }

    @Override
    int quality(LocalDate checkDate) {
        if (checkDate.isAfter(this.shelfDate)) {
            long daysBetween = ChronoUnit.DAYS.between(this.shelfDate, checkDate);
            return (int) Math.min(baseQuality + daysBetween / 10, 50);
        }

        return baseQuality;
    }
}
