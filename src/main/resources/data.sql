INSERT INTO roles (id, name)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

INSERT INTO users (username, password, role)
VALUES ('admin', '{noop}admin123', 'ADMIN'),
       ('user', '{noop}user123', 'USER');

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 2), -- admin -> ROLE_ADMIN
       (1, 1), -- admin -> ROLE_USER
       (2, 1);

INSERT INTO category (id, name, description)
VALUES (1, 'Электроника', 'Смартфоны, ноутбуки, планшеты'),
       (2, 'Одежда', 'Мужская и женская одежда'),
       (3, 'Бытовая техника', 'Техника для дома и кухни');


INSERT INTO product (id, name, description, price, image_url, category_id, created_at, status)
VALUES (1, 'iPhone 14 Pro', 'Флагманский смартфон Apple', 1200.00, 'iphone14.jpg', 1, NOW(), true),
       (2, 'Samsung Galaxy S23', 'Флагманский смартфон Samsung', 1100.00, 's23.jpg', 1, NOW(), true),
       (3, 'Футболка Nike', 'Белая хлопковая футболка', 30.00, 'nike_tshirt.jpg', 2, NOW(), true),
       (4, 'Холодильник LG', 'Двухкамерный холодильник LG', 700.00, 'lg_fridge.jpg', 3, NOW(), true),
       (5, 'Ноутбук Lenovo ThinkPad', 'Ноутбук для работы', 900.00, 'thinkpad.jpg', 1, NOW(), false);
