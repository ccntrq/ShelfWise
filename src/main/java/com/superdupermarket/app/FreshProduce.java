package com.superdupermarket.app;

import java.time.LocalDate;

public class FreshProduce extends Product {
    public FreshProduce(String label, LocalDate shelfDate, int basePrice, int baseQuality, LocalDate expiration) {
        super(label, shelfDate, basePrice, baseQuality, expiration, new DiscountedPriceStrategy(),
                new BaseQualityStrategy(), new AfterExpirationDisposalStrategy());
    }
}
