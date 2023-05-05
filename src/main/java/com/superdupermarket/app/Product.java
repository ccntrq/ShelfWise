package com.superdupermarket.app;

import java.time.LocalDate;
import java.util.Optional;

abstract public class Product {
    protected String label;
    // base price in cents
    protected int basePrice;
    protected int baseQuality;
    // products that don't expire will have `empty()` here
    protected Optional<LocalDate> expiration;
    protected LocalDate shelfDate;

    protected Product(
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

    @Override
    public String toString() {
        return "Product [label=" + label + ", basePrice=" + basePrice + ", baseQuality=" + baseQuality + ", expiration="
                + expiration + "]";
    }

    public String[] showDailyReport(LocalDate checkDate) {
        String[] report = {
                this.label,
                Integer.toString(this.quality(checkDate)),
                Double.toString(this.dayPrice(checkDate) / 100.0),
                this.expiration.map(exp -> exp.toString()).orElse("---"),
                this.shouldDispose(checkDate) ? "Entsorgen" : "Ok" };
        return report;
    }

    abstract boolean shouldDispose(LocalDate checkDate);

    abstract int quality(LocalDate checkDate);
}
