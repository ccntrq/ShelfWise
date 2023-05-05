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
        List<Product> products = new StaticProductRepository().fetchProducts();

        LocalDate checkDate = LocalDate.now();
        boolean done;
        do {
            done = true;
            ArrayList<String[]> fullDailyReport = new ArrayList<>();
            System.out.println("Date: " + checkDate);

            for (Product prod : products) {
                fullDailyReport.add(prod.showDailyReport(checkDate));
                if (!prod.shouldDispose(checkDate)) {
                    done = false;
                }
            }

            App.printReport(fullDailyReport);
            System.out.println();

            checkDate = checkDate.plusDays(1);
        } while (!done && checkDate.isBefore(LocalDate.now().plusYears(1)));

    }

    public static void printReport(ArrayList<String[]> fullDailyReport) {
        String[] headings = { "Name", "Qualität", "Preis", "Verfallsdatum", "Produktstatus" };
        fullDailyReport.add(0, headings);
        ArrayListTable.printTable(fullDailyReport);
    }

}
