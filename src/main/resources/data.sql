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
       (3, 'Бытовая техника', 'Техника для дома и кухни'),
       (4, 'Книги', 'Художественная литература и учебники'),
       (5, 'Спорт', 'Спортивные товары и экипировка');


INSERT INTO product (id, name, description, price, image_url, category_id, created_at, status)
VALUES (1, 'iPhone 14 Pro', 'Флагманский смартфон Apple', 1200.00, 'iphone14.jpg', 1, NOW(), true),
       (2, 'Samsung Galaxy S23', 'Флагманский смартфон Samsung', 1100.00, 's23.jpg', 1, NOW(), true),
       (3, 'Футболка Nike', 'Белая хлопковая футболка', 30.00, 'nike_tshirt.jpg', 2, NOW(), true),
       (4, 'Холодильник LG', 'Двухкамерный холодильник LG', 700.00, 'lg_fridge.jpg', 3, NOW(), true),
       (5, 'Ноутбук Lenovo ThinkPad', 'Ноутбук для работы', 900.00, 'thinkpad.jpg', 1, NOW(), false),
       (6, 'MacBook Air', 'Ультратонкий ноутбук Apple', 1300.00, 'macbook_air.jpg', 1, NOW(), true),
       (7, 'AirPods Pro', 'Беспроводные наушники Apple', 250.00, 'airpods_pro.jpg', 1, NOW(), true),
       (8, 'Джинсы Levis', 'Классические синие джинсы', 60.00, 'levis_jeans.jpg', 2, NOW(), true),
       (9, 'Микроволновка Samsung', 'Микроволновая печь 25л', 120.00, 'samsung_mw.jpg', 3, NOW(), false),
       (10, 'Книга "Война и мир"', 'Роман Льва Толстого', 15.00, 'war_and_peace.jpg', 4, NOW(), true),
       (11, 'Книга "Гарри Поттер"', 'Фэнтези Дж. К. Роулинг', 20.00, 'harry_potter.jpg', 4, NOW(), true),
       (12, 'Беговые кроссовки Adidas', 'Кроссовки для бега', 80.00, 'adidas_run.jpg', 5, NOW(), true),
       (13, 'Фитнес-резинка', 'Эспандер для тренировок', 10.00, 'fitness_band.jpg', 5, NOW(), true),
       (14, 'Теннисная ракетка', 'Ракетка для тенниса', 120.00, 'tennis_racket.jpg', 5, NOW(), false),
       (15, 'Планшет Samsung Galaxy Tab', 'Планшет для работы и развлечений', 400.00, 'galaxy_tab.jpg', 1, NOW(), true),
       (16, 'Свитер Uniqlo', 'Тёплый свитер из шерсти', 45.00, 'uniqlo_sweater.jpg', 2, NOW(), true),
       (17, 'Пылесос Bosch', 'Вертикальный пылесос для дома', 200.00, 'bosch_vacuum.jpg', 3, NOW(), true);
