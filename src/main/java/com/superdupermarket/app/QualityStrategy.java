package com.superdupermarket.app;

import java.time.LocalDate;

public interface QualityStrategy {
    int calculateQuality(Product product, LocalDate date);
}