package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Starting from 5 days before expiry a discount of 25% is applied per day up to
// a maximum of 75% price reduction.  On the expiration date the product will be
// free.
public class DiscountedPriceStrategy extends BasePriceStrategy {
    // NOTE: these parameters could be made configurable via the class
    // constructor to make this strategy more flexible
    private static final int EXPIRY_DISCOUNT_DAYS = 5;
    private static final int MAXIMUM_DISCOUNT_PERCENTAGE = 75;
    private static final int DISOUNT_PERCENTAGE_PER_DAY = 25;

    @Override
    public int calculatePrice(Product product, LocalDate checkDate) {
        int basePrice = super.calculatePrice(product, checkDate);
        int discount = this.calculateDiscount(product, checkDate);
        return basePrice * (100 - discount) / 100;
    }

    private int calculateDiscount(Product product, LocalDate checkDate) {
        if (product.expiration.isPresent()) {
            long daysToExpiry = ChronoUnit.DAYS.between(checkDate, product.expiration.get());
            if (daysToExpiry <= 0) {
                return 100;
            }
            if (daysToExpiry <= EXPIRY_DISCOUNT_DAYS) {
                return (int) Math.min(DISOUNT_PERCENTAGE_PER_DAY * (EXPIRY_DISCOUNT_DAYS - daysToExpiry),
                        MAXIMUM_DISCOUNT_PERCENTAGE);
            }
        }
        return 0;
    }
}
