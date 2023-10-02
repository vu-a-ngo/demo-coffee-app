-- db/changelog/db.changelog-master.sql

-- changeset author:1
CREATE TABLE IF NOT EXISTS shop_user (
    id SERIAL PRIMARY KEY,
    shoprole VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    passwd VARCHAR(255),
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    telephone VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS shop (
    id SERIAL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    address VARCHAR,
    contact VARCHAR(255),
    is_actve boolean
);

CREATE TABLE IF NOT EXISTS user_to_shop (
    user_id INTEGER REFERENCES shop_user(id) ON DELETE CASCADE NOT NULL,
    shop_id INTEGER REFERENCES shop(id) ON DELETE CASCADE NOT NULL,
    PRIMARY KEY (user_id, shop_id)
);

CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    passwd VARCHAR(255),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    telephone VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS menu (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS shop_to_menu (
    shop_id INTEGER REFERENCES shop(id) ON DELETE CASCADE NOT NULL,
    menu_id INTEGER REFERENCES menu(id) ON DELETE CASCADE NOT NULL,
    PRIMARY KEY (shop_id, menu_id)
);

CREATE TABLE IF NOT EXISTS menu_item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    currency VARCHAR(3)
);

CREATE TABLE IF NOT EXISTS menu_to_item (
    menu_id INTEGER REFERENCES menu(id) ON DELETE CASCADE NOT NULL,
    item_id INTEGER REFERENCES menu_item(id) ON DELETE CASCADE NOT NULL,
    PRIMARY KEY (menu_id, item_id)
);

CREATE TYPE promotion_type AS ENUM ('GLOBAL', 'SHOP', 'AMOUNT', 'COMBO', 'GIFTCARD', 'ONEOFF');
CREATE TYPE discount_method AS ENUM ('POINTS', 'DISCOUNT_AMOUNT', 'DISCOUNT_PERCENTAGE', 'EXTRA_ITEM');

CREATE TABLE IF NOT EXISTS promotion (
    id SERIAL PRIMARY KEY,
    type promotion_type NOT NULL DEFAULT 'GLOBAL'::promotion_type,
    method discount_method NOT NULL DEFAULT 'POINTS'::discount_method,
    shop_id INTEGER REFERENCES shop(id),
    start_date DATE,
    end_date DATE,
    item_id INTEGER REFERENCES menu_item(id) ON DELETE SET NULL,
    discount_amount FLOAT
);

CREATE TYPE order_status AS ENUM ('PAID', 'COMPLETED', 'CANCELLED');

CREATE TABLE IF NOT EXISTS order (
    id SERIAL PRIMARY KEY,
    status order_status NOT NULL DEFAULT 'COMPLETED'::order_status,
    total_amount FLOAT NOT NULL,
    currency VARCHAR(3),
    shop_id INTEGER REFERENCES shop(id),
    customer_id INTEGER REFERENCES customer(id),
    items INTEGER[],
    applied_promotions INTEGER[]
);



