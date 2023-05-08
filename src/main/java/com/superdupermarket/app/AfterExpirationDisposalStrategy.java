package com.superdupermarket.app;

import java.time.LocalDate;

// Other than the BaseDisposal Strategy this will not dispose a product **on**
// its expiration date but only **after** that.
public class AfterExpirationDisposalStrategy implements DisposalStrategy {
    @Override
    public boolean shouldDispose(Product product, LocalDate date) {
        return product.expiration.map(expiration -> date.isAfter(expiration)).orElse(false);
    }
}
