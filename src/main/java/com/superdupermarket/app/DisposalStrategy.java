package com.superdupermarket.app;

import java.time.LocalDate;

public interface DisposalStrategy {
    boolean shouldDispose(Product product, LocalDate date);
}