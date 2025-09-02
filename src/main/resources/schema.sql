DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;

CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

CREATE TABLE user_roles (
                            user_id INT NOT NULL,
                            role_id INT NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                            CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE TABLE category (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT
);

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(150) NOT NULL,
                         description TEXT,
                         price DECIMAL(10,2) NOT NULL,
                         image_url VARCHAR(255),
                         category_id INT,
                         created_at TIMESTAMP DEFAULT NOW(),
                         status VARCHAR(50) NOT NULL,
                         CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL
);

ALTER SEQUENCE category_id_seq RESTART WITH 4;
ALTER SEQUENCE product_id_seq RESTART WITH 6;