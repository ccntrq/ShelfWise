CREATE TABLE IF NOT EXISTS products (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    product_type TEXT NOT NULL,
    label TEXT NOT NULL,
    base_price REAL NOT NULL,
    quality INTEGER NOT NULL,
    expiration_date TEXT,
    shelf_date TEXT
);

INSERT INTO products (product_type, label, base_price, quality, expiration_date, shelf_date)
VALUES ('CHEESE', 'Cheddar', 3.99, 50, '2023-05-18', '2023-05-08');

INSERT INTO products (product_type, label, base_price, quality, expiration_date, shelf_date)
VALUES ('CHEESE', 'Parmigiano', 4.75, 50, '2023-07-03', '2023-05-08');

INSERT INTO products (product_type, label, base_price, quality, expiration_date, shelf_date)
VALUES ('WINE', 'Riesling', 10.99, 25, NULL, NULL);

INSERT INTO products (product_type, label, base_price, quality, expiration_date, shelf_date)
VALUES ('FRESH_PRODUCE', 'Onion', 1.99, 10, '2023-05-18', '2023-05-08');

INSERT INTO products (product_type, label, base_price, quality, expiration_date, shelf_date)
VALUES ('FRESH_PRODUCE', 'Banana', 1.99, -10, '2023-05-18', '2023-05-08');
