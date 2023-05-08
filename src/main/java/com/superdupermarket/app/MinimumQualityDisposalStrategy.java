package com.superdupermarket.app;

import java.time.LocalDate;

public class MinimumQualityDisposalStrategy extends BaseDisposalStrategy {
    private final int minimumQuality;

    MinimumQualityDisposalStrategy(int minimumQuality) {
        this.minimumQuality = minimumQuality;
    }

    @Override
    public boolean shouldDispose(Product product, LocalDate date) {
        return super.shouldDispose(product, date) || product.quality(date) < this.minimumQuality;
    }
}
