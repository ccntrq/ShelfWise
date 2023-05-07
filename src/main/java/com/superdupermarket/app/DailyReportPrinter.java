package com.superdupermarket.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DailyReportPrinter {
    private final DateTimeFormatter germanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void printDailyReport(List<Product> products, LocalDate day) {
        System.out.println("Report - " + day.format(germanDateFormatter));

        ArrayList<String[]> dailyReport = new ArrayList<>(
                products.stream()
                        .map(prod -> this.generateProductReport(prod, day))
                        .collect(Collectors.toList()));
        this.printReportTable(dailyReport);
    }

    private void printReportTable(ArrayList<String[]> fullDailyReport) {
        String[] headings = { "Name", "Qualität", "Preis", "Verfallsdatum", "Produktstatus" };
        fullDailyReport.add(0, headings);
        ArrayListTable.printTable(fullDailyReport);
    }

    private String[] generateProductReport(Product product, LocalDate checkDate) {
        String[] report = {
                product.label,
                Integer.toString(product.quality(checkDate)),
                Double.toString(product.dayPrice(checkDate) / 100.0),
                product.expiration.map(exp -> exp.format(this.germanDateFormatter)).orElse("----------"),
                product.shouldDispose(checkDate) ? "Entsorgen" : "Ok" };
        return report;
    }

}
