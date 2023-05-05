package com.superdupermarket.app;

import java.time.LocalDate;
import java.util.ArrayList;

import com.superdupermarket.app.ProductFactory.ProductType;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Product[] products = App.defaultProducts();

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

    public static Product[] defaultProducts() {
        LocalDate today = LocalDate.now();

        Product[] products = {
                ProductFactory.createProduct(ProductType.CHEESE, "Cheddar", today, 399, 50, today.plusDays(10)),
                ProductFactory.createProduct(ProductType.CHEESE, "Parmigiano", today, 475, 50, today.plusDays(55)),
                ProductFactory.createProduct(ProductType.WINE, "Riesling", today, 1099, 25, null),
        };

        return products;
    }
}
