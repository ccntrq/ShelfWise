package com.superdupermarket.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ProductRepository repo = args.length == 0
                ? new StaticProductRepository()
                : new CSVProductRepository(args[0]);

        DailyReportPrinter reportPrinter = new DailyReportPrinter();
        List<Product> products = repo.fetchProducts();

        LocalDate checkDate = LocalDate.now();
        boolean done = false;
        do {
            LocalDate finalLocalDate = checkDate; // Create final local copy to allow use in lambda
            if (products.stream().allMatch(prod -> prod.shouldDispose(finalLocalDate))) {
                done = true;
            }

            reportPrinter.printDailyReport(products, checkDate);

            // proceed to next day
            System.out.println();
            checkDate = checkDate.plusDays(1);
        } while (!done && checkDate.isBefore(LocalDate.now().plusYears(1)));

    }
}
