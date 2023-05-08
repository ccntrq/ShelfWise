package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// A quality strategy for product with increasing quality over time.  Increases
// the quality by one point for every 10 days up to a maximum of 50 quality
// points
// NOTE: could be made more flexible by making the quality increase, interval
// and maximum quality configurable via the ctor.
public class IncreasingQualityStrategy extends BaseQualityStrategy {
    public static final int MAXIMUM_QUALITY = 50;

    @Override
    public int calculateQuality(Product product, LocalDate date) {
        if (date.isAfter(product.shelfDate)) {
            long daysBetween = ChronoUnit.DAYS.between(product.shelfDate, date);
            return (int) Math.min(product.baseQuality + daysBetween / 10, MAXIMUM_QUALITY);
        }

        return product.baseQuality;
    }
}