package com.superdupermarket.app;

import java.time.LocalDate;

public class Cheese extends Product {
    private static final int MINIMUM_QUALITY = 30;

    public Cheese(
            String label,
            LocalDate shelfDate,
            int basePrice,
            int baseQuality,
            LocalDate expiration) {
        super(
                label,
                shelfDate,
                basePrice,
                baseQuality,
                expiration,
                new BasePriceStrategy(),
                new DeterioratingQualityStrategy(),
                new MinimumQualityDisposalStrategy(Cheese.MINIMUM_QUALITY));
    }
}
