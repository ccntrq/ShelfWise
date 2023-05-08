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
    protected final PriceStrategy priceStrategy;
    protected final QualityStrategy qualityStrategy;
    protected final DisposalStrategy disposalStrategy;

    public Product(
            String label,
            LocalDate shelfDate,
            int basePrice,
            int baseQuality,
            LocalDate expiration,
            PriceStrategy priceStrategy,
            QualityStrategy qualityStrategy,
            DisposalStrategy disposalStrategy) {
        this.label = label;
        this.shelfDate = shelfDate;
        this.basePrice = basePrice;
        this.baseQuality = baseQuality;
        this.expiration = Optional.ofNullable(expiration);
        this.priceStrategy = priceStrategy;
        this.qualityStrategy = qualityStrategy;
        this.disposalStrategy = disposalStrategy;
    }

    public int dayPrice(LocalDate checkDate) {
        return this.priceStrategy.calculatePrice(this, checkDate);
    }

    public boolean shouldDispose(LocalDate checkDate) {
        return this.disposalStrategy.shouldDispose(this, checkDate);
    }

    public int quality(LocalDate checkDate) {
        return this.qualityStrategy.calculateQuality(this, checkDate);
    }
}
