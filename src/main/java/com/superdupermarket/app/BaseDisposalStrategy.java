package com.superdupermarket.app;

import java.time.LocalDate;

// BaseDisposal strategy disposes of products on and after their expiration date.
public class BaseDisposalStrategy implements DisposalStrategy {
    @Override
    public boolean shouldDispose(Product product, LocalDate date) {
        return product.expiration.map(expiration -> !expiration.isAfter(date)).orElse(false);
    }
}
