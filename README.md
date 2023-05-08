# ShelfWise - Price Right, Stock Bright!

## Usage

This project uses maven for the build. The CLI can be run using the following command:

**With hardcoded products from StaticProductRepository:**

```bash
mvn compile exec:java -Dexec.mainClass="com.superdupermarket.app.App"
```

**Using CSVProductRepository to read products from a given csv file:**

```bash
mvn compile exec:java -Dexec.mainClass="com.superdupermarket.app.App" -Dexec.args="products-example.csv"
```

**Using SQLiteProductRepository to read products from a given sqlite database:**

```bash
mvn compile exec:java -Dexec.mainClass="com.superdupermarket.app.App" -Dexec.args="products-example.db"
```