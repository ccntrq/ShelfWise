package com.superdupermarket.app;

import java.time.LocalDate;
import java.util.Optional;

abstract public class Product {
    public final String label;
    // base price in cents
    public final int basePrice;
    public final int baseQuality;
    // products that don't expire will have `empty()` here
    public final Optional<LocalDate> expiration;
    public final LocalDate shelfDate;

    public Product(
            String label,
            LocalDate shelfDate,
            int basePrice,
            int baseQuality,
            LocalDate expiration) {
        this.label = label;
        this.shelfDate = shelfDate;
        this.basePrice = basePrice;
        this.baseQuality = baseQuality;
        this.expiration = Optional.ofNullable(expiration);
    }

    public int dayPrice(LocalDate checkDate) {
        // The day price is the basePrice plus an additional 10 cents for each
        // point of quality
        return this.basePrice + this.quality(checkDate) * 10;
    }

    public abstract boolean shouldDispose(LocalDate checkDate);

    public abstract int quality(LocalDate checkDate);
}
