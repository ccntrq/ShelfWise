package com.superdupermarket.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SQLiteProductRepository implements ProductRepository {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String databaseUrl;

    public SQLiteProductRepository(String databaseFile) {
        this.databaseUrl = "jdbc:sqlite:" + databaseFile;
    }

    @Override
    public List<Product> fetchProducts() {
        List<Product> products = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        try (Connection connection = DriverManager.getConnection(databaseUrl);
                Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                ProductType productType = ProductType.valueOf(resultSet.getString("product_type").toUpperCase());
                String label = resultSet.getString("label");
                int basePrice = (int) Math.floor(resultSet.getDouble("base_price") * 100);
                int quality = resultSet.getInt("quality");
                LocalDate expirationDate = resultSet.getString("expiration_date") == null
                        || resultSet.getString("expiration_date").isEmpty() ? null
                                : LocalDate.parse(resultSet.getString("expiration_date"), DATE_FORMATTER);
                LocalDate shelfDate = resultSet.getString("shelf_date") == null
                        || resultSet.getString("shelf_date").isEmpty() ? currentDate
                                : LocalDate.parse(resultSet.getString("shelf_date"), DATE_FORMATTER);

                products.add(ProductFactory.createProduct(productType, label, shelfDate, basePrice, quality,
                        expirationDate));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
