# 🛒 ShelfWise - Price Right, Stock Bright!

SuperDuperMarket ShelfWise revolutionizes you shelf managment today.

With data driven pricing, daily product overviews and special rules for cheese,
wine and fresh produce you ensure optimal quality for the customers, while
staying competitive and maximizing your revenue.

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

## Example Output

```
Report - 09.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 50       | 8.99  | 19.05.2023    | Ok           
Parmigiano | 50       | 9.75  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.99  | 19.05.2023    | Ok           
Banana     | -10      | 0.99  | 19.05.2023    | Ok           

Report - 10.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 49       | 8.89  | 19.05.2023    | Ok           
Parmigiano | 49       | 9.65  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.99  | 19.05.2023    | Ok           
Banana     | -10      | 0.99  | 19.05.2023    | Ok           

Report - 11.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 48       | 8.79  | 19.05.2023    | Ok           
Parmigiano | 48       | 9.55  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.99  | 19.05.2023    | Ok           
Banana     | -10      | 0.99  | 19.05.2023    | Ok           

Report - 12.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 47       | 8.69  | 19.05.2023    | Ok           
Parmigiano | 47       | 9.45  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.99  | 19.05.2023    | Ok           
Banana     | -10      | 0.99  | 19.05.2023    | Ok           

Report - 13.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 46       | 8.59  | 19.05.2023    | Ok           
Parmigiano | 46       | 9.35  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.99  | 19.05.2023    | Ok           
Banana     | -10      | 0.99  | 19.05.2023    | Ok           

Report - 14.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 45       | 8.49  | 19.05.2023    | Ok           
Parmigiano | 45       | 9.25  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.99  | 19.05.2023    | Ok           
Banana     | -10      | 0.99  | 19.05.2023    | Ok           

Report - 15.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 44       | 8.39  | 19.05.2023    | Ok           
Parmigiano | 44       | 9.15  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 2.24  | 19.05.2023    | Ok           
Banana     | -10      | 0.74  | 19.05.2023    | Ok           

Report - 16.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 43       | 8.29  | 19.05.2023    | Ok           
Parmigiano | 43       | 9.05  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 1.49  | 19.05.2023    | Ok           
Banana     | -10      | 0.49  | 19.05.2023    | Ok           

Report - 17.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 42       | 8.19  | 19.05.2023    | Ok           
Parmigiano | 42       | 8.95  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 0.74  | 19.05.2023    | Ok           
Banana     | -10      | 0.24  | 19.05.2023    | Ok           

Report - 18.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 41       | 8.09  | 19.05.2023    | Ok           
Parmigiano | 41       | 8.85  | 03.07.2023    | Ok           
Riesling   | 25       | 13.49 | ----------    | Ok           
Onion      | 10       | 0.74  | 19.05.2023    | Ok           
Banana     | -10      | 0.24  | 19.05.2023    | Ok           

Report - 19.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 40       | 7.99  | 19.05.2023    | Entsorgen    
Parmigiano | 40       | 8.75  | 03.07.2023    | Ok           
Riesling   | 26       | 13.49 | ----------    | Ok           
Onion      | 10       | 0.0   | 19.05.2023    | Ok           
Banana     | -10      | 0.0   | 19.05.2023    | Ok           

Report - 20.05.2023
Name       | Qualität | Preis | Verfallsdatum | Produktstatus
-----------+----------+-------+---------------+--------------
Cheddar    | 39       | 7.89  | 19.05.2023    | Entsorgen    
Parmigiano | 39       | 8.65  | 03.07.2023    | Ok           
Riesling   | 26       | 13.49 | ----------    | Ok           
Onion      | 10       | 0.0   | 19.05.2023    | Entsorgen    
Banana     | -10      | 0.0   | 19.05.2023    | Entsorgen    
```