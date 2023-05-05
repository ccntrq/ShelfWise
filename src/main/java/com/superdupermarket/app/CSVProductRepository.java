package com.superdupermarket.app;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVProductRepository implements ProductRepository {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String filePath;

    public CSVProductRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Product> fetchProducts() {
        List<Product> products = new ArrayList<>();
        LocalDate currenDate = LocalDate.now();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Skip header line

            while ((line = reader.readNext()) != null) {
                ProductType productType = ProductType.valueOf(line[0].toUpperCase());
                String label = line[1];
                int basePrice = (int) Math.floor(Double.parseDouble(line[2]) * 100);
                int quality = Integer.parseInt(line[3]);
                LocalDate expirationDate = line[4].isEmpty() ? null : LocalDate.parse(line[4], DATE_FORMATTER);
                // use existing shelfDate or the current date for new products
                LocalDate shelfDate = line[5].isEmpty() ? currenDate : LocalDate.parse(line[5], DATE_FORMATTER);

                products.add(ProductFactory.createProduct(productType, label, shelfDate, basePrice, quality,
                        expirationDate));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return products;
    }
}
