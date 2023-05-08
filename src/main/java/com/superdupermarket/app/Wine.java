package com.superdupermarket.app;

import java.time.LocalDate;

public class Wine extends Product {
    public Wine(String label, LocalDate shelfDate, int basePrice, int baseQuality) {
        super(label, shelfDate, basePrice, baseQuality, null, new FixedQualityPriceStrategy(),
                new IncreasingQualityStrategy(), new BaseDisposalStrategy());
    }
}
