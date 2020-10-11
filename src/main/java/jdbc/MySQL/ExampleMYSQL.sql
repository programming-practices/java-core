USE sakila;
-- ------------------------------------------------- CREATE ------------------------------------------------------------
--utf8_bin user != User  -- ychitevaetsa register
--utf8_general_ci user == User  -- ne ychitevaetsa register
CREATE DATABASE nameDataBase2 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE Lesson_SQL;
CREATE TABLE people (id INT, fname VARCHAR(30), lname VARCHAR(30), email VARCHAR(30))
CREATE TABLE movies (name VARCHAR(50), duration INT, likes INT, disLikes INT, dropPer INT)
CREATE TABLE products2 (id INT AUTO_INCREMENT, name VARCHAR(30), price INT, PRIMARY KEY (id))
CREATE TABLE clients (id INT AUTO_INCREMENT PRIMARY KEY NOT NULL , firstName VARCHAR(30) NOT NULL , lastName VARCHAR(30), email VARCHAR(30) NOT NULL )
CREATE TABLE users (name VARCHAR(30))
CREATE TABLE users2 (id INT AUTO_INCREMENT PRIMARY KEY, names_list VARCHAR(20), firstName VARCHAR(20), lastName VARCHAR(20))
CREATE TABLE sales (id INT AUTO_INCREMENT PRIMARY KEY , firstName_list VARCHAR(20) NOT NULL, lastName_list VARCHAR(20) NOT NULL, s_product VARCHAR(15) NOT NULL, price INT NOT NULL
CREATE TABLE user3 (id int AUTO_INCREMENT PRIMARY KEY , firstName VARCHAR(20) NOT NULL , lastName VARCHAR(20), email VARCHAR(30) NOT NULL )
CREATE TABLE Order2 (order_id INT AUTO_INCREMENT PRIMARY KEY , name_order VARCHAR(20) NOT NULL)
CREATE TABLE Item (item_id INT AUTO_INCREMENT PRIMARY KEY , name_item VARCHAR(30) NOT NULL )
CREATE TABLE ItemOrder (item_id INT NOT NULL , order_id INT NOT NULL ,
   FOREIGN KEY (item_id) REFERENCES Item (item_id), FOREIGN KEY (order_id) REFERENCES Order2 (order_id))
CREATE DATABASE Lesson_SQL_3
CREATE DATABASE Lesson_SQL2
CREATE TABLE customer (id INT AUTO_INCREMENT PRIMARY KEY , firstName VARCHAR(20) NOT NULL , lastName VARCHAR(20) NOT NULL ,
   adderss_id INT NOT NULL,FOREIGN KEY (adderss_id) REFERENCES address(adres_id))
CREATE TABLE address (adres_id INT AUTO_INCREMENT PRIMARY KEY , direccion VARCHAR(40) NOT NULL )
CREATE TABLE IF NOT EXISTS " +
 "Books (id MEDIUMINT NOT NULL AUTO_INCREMNT PRIMARY KEY , name CHAR (20) NOT NULL

-- -------------------------------------------------- DROP -------------------------------------------------------------
#DROP DATABASE new_schema_pruba
#DROP TABLE people
#DROP TABLE customer
#DROP TABLE IF EXISTS Books

-- ------------------------------------------------- DELETE ------------------------------------------------------------
#DELETE FROM movies WHERE dropPer > 70
#DELETE FROM clients WHERE id = 4

-- --------------------------------------------------- DESC ------------------------------------------------------------
#DESC customer
#DESC address
#DESC subscriptores
#DESC products2
#DESC clients
#DESC users

-- -------------------------------------------------- SHOW -------------------------------------------------------------
#SHOW DATABASES
#SHOW TABLES

-- --------------------------------------------------- USE -------------------------------------------------------------
# USE Lesson_SQL
# USE Lesson_SQL_3
# USE Lesson_SQL2

-- ------------------------------------------------- DESCRIBE ----------------------------------------------------------
DESCRIBE sakila.film;

-- -------------------------------------------------- INSERT -----------------------------------------------------------
--INSERT INTO subscriptores VALUES (1, 'Petr', 'Radko', 'test@mail.ru')
--INSERT INTO  movies VALUES ('Just bad movie', 10, 0, 100, 100)
#INSERT INTO products2 (name, price) VALUES  ('Milk', 49)
#INSERT INTO products2 VALUES (NULL , 'Bread', 16)
#INSERT INTO clients VALUES (NULL ,'Anya', 'Vaneckaya', 'anya777@email.com')
#INSERT INTO users VALUES ('Tomas')
#INSERT INTO users2 (names_list) VALUES ('Jimmy Voode')
#INSERT INTO users2 VALUES (NULL, 'Maik', 'Haiden', 2)
#INSERT INTO users2 VALUES (NULL , 'Hreh', 'Eitson', 0)
#INSERT INTO ItemOrder VALUES (1,1),
#   (2,1),
#   (3,1),
#   (4,1),
#   (5,2),
#   (6,2),
#   (7,2)
#INSERT  INTO  user3 VALUES (NULL , 'Pavel', 'Radko', 'test@email.com',DEFAULT )
#INSERT INTO Order2 VALUES (NULL , 'Elektronni Tovaru')
#INSERT INTO Item VALUES (NULL ,'Televisor')
#INSERT INTO customer VALUES (NULL , 'Parra', 'Carlos', 2),
#                             (NULL , 'Bianca', 'Maria', 1),
#                             (NULL , 'Parra', 'Sarra', 2),
#                             (NULL , 'Tortosano', 'Migel', 3)
#INSERT INTO address VALUES (NULL , 'Avenida San Anton 12 3C')
#INSERT INTO sales VALUES (NULL ,'Ania', 'Komarova', 'Chikle', 22)

-- --------------------------------------------------- VIEWS -----------------------------------------------------------
-- Las vistas (“views”) en SQL son un mecanismo que permite generar un resultado a partir de una consulta (query)
-- previamente ejecutada field1 almacenada, de manera que permite ejecutar nuevas consultas sobre este resultado como
-- si fuera una tabla normal.

-- Por favor muestre toda la información de todas las tablas del gráfico anterior.
-- NOTA: Crearemos una vista para tener toda la consulta a modo de tabla. Usar CREATE OR REPLACE VIEW nombre de la
-- vista AS. Dará error
CREATE OR REPLACE VIEW sakila.V_PELICULAS_ACTORES_CATEGORIAS AS
SELECT * FROM sakila.actor AS a
INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id
INNER JOIN sakila.film AS f ON f.film_id = fa.film_id
INNER JOIN sakila.film_category AS fc ON f.film_id = fc.film_id
INNER JOIN sakila.category AS c ON c.category_id = fc.category_id

-- Por favor muestre todos los campos de la tabla películas (film), field1 luego los distintos campos de cada tabla de
-- actores (actor) field1 categorías (category), de la información de todas las tablas del gráfico anterior en modo vista.
CREATE OR REPLACE VIEW sakila.V_PELICULAS_ACTORES_CATEGORIAS AS
SELECT f.*, a.actor_id, a.first_name, a.last_name, c.category_id, c.name AS category_name FROM sakila.actor AS a
INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id
INNER JOIN sakila.film AS f ON f.film_id = fa.film_id
INNER JOIN sakila.film_category AS fc ON f.film_id = fc.film_id
INNER JOIN sakila.category AS c ON c.category_id = fc.category_id

SELECT * FROM sakila.V_PELICULAS_ACTORES_CATEGORIAS;

-- ------------------------------------------------ UPDATE -------------------------------------------------------------
#UPDATE movies SET disLikes = 100 WHERE name = 'CMTV Movie'
#UPDATE movies SET  disLikes = disLikes * 3
#UPDATE users2 SET firstName = SUBSTRING_INDEX(names_list, ' ', 1)
#UPDATE users2 SET lastName = SUBSTRING_INDEX(names_list, ' ', -1)
#UPDATE users2 SET lastName = upper(lastName) WHERE id = 1;
# RTRIM/LTRIM udalenie probelov v nachale slova valueInt v konce slova
#UPDATE users2 SET rank = CASE
#   WHEN reputation > 350 THEN 'Elite'
#    WHEN reputation > 100 THEN 'Popularnui'
#    WHEN  reputation > 0 THEN 'Polzovatel'
#    WHEN reputation = 0 THEN 'Novichok'
#    ELSE 'Nyb'
#    END
#UPDATE users2 SET reputation = 21 WHERE id = 3
#UPDATE users2 SET  lastName = 'Yan' WHERE id = 1;

-- -------------------------------------------------- ALTER ------------------------------------------------------------
#ALTER TABLE clients ADD COLUMN id INT AUTO_INCREMENT FIRST , ADD PRIMARY KEY (id);
#ALTER TABLE clients ADD COLUMN adress VARCHAR(30)
#ALTER TABLE users ADD COLUMN id INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST
#ALTER TABLE users ADD COLUMN test VARCHAR(30)
#ALTER TABLE users ADD COLUMN  date INT AFTER test
#ALTER TABLE users DROP COLUMN date
#ALTER TABLE tests_users RENAME TO users;
#ALTER TABLE users CHANGE COLUMN name name_List VARCHAR(15) NOT NULL
#ALTER TABLE users MODIFY COLUMN name_List VARCHAR(20)
#ALTER TABLE users DROP COLUMN id
#ALTER TABLE users CHANGE COLUMN name_List name VARCHAR(15)
#ALTER TABLE users ADD  COLUMN id INT AUTO_INCREMENT PRIMARY KEY FIRST ,CHANGE COLUMN name name_list VARCHAR(20), ADD COLUMN  last_name VARCHAR(20)
#ALTER TABLE users2 DROP COLUMN names_list
#ALTER TABLE users2 ADD COLUMN rank VARCHAR(20) NOT NULL
#ALTER TABLE user3  ADD COLUMN income INT DEFAULT
#ALTER TABLE customer CHANGE COLUMN adders_id address_id INT NOT NULL;
#ALTER TABLE address CHANGE COLUMN adres_id address_id INT AUTO_INCREMENT PRIMARY KEY;


-- -------------------------------------------------- SELECT -----------------------------------------------------------
#SELECT name, price FROM products
#SELECT * FROM products WHERE rete >= 7
#SELECT * FROM products WHERE shop_name = 'Dicsi' AND rete = 7
#SELECT * FROM products
#SELECT * FROM products WHERE shop_name = 'Dicsi' OR rete > 8
#SELECT * FROM products WHERE shop_name LIKE '%re%'
#SELECT * FROM products WHERE shop_name LIKE 'Dics_'
#SELECT * FROM products WHERE shop_name LIKE '_ic%'
#SELECT * FROM products WHERE rete IN (7,8,9)
#SELECT * FROM products WHERE price BETWEEN 50 AND 100
#SELECT * FROM products WHERE NOT price BETWEEN 50 AND 100
#SELECT * FROM products WHERE NOT rete IN (7,8,9)
#SELECT * FROM movies
#SELECT name, duration FROM movies WHERE (likes > 100 OR disLikes < 100) AND dropPer < 70
#SELECT * FROM products2;
#SELECT *FROM clients;
#SELECT * FROM users;
#SELECT * FROM users
#SELECT  RIGHT(firstName,2) FROM users2
#SELECT LEFT(lastName ,2) FROM users2
#SELECT upper(name_list) FROM user
#SELECT *FROM users2;
#SELECT * FROM users2
#SELECT  firstName ,reputation, rank FROM users2 ORDER BY firstName
#SELECT * FROM users2 ORDER BY reputation DESC
#SELECT * FROM users2 ORDER BY reputation
#SELECT SUM(price) FROM sales
#SELECT  MAX(price) FROM sales
#SELECT MIN(price) FROM sales
#SELECT AVG(price) FROM sales
#SELECT COUNT(price) FROM sales
#SELECT * FROM sales WHERE price = (SELECT MAX(price) FROM sales )
#SELECT * FROM sales ORDER BY price DESC
#SELECT * FROM sales ORDER BY price ASC
#SELECT * FROM sales ORDER BY price
#SELECT firstName_list, SUM(price) FROM sales GROUP BY firstName_list
#SELECT firstName_list,s_product, MAX(price) FROM sales GROUP BY firstName_list
#SELECT firstName_list, s_product, MAX(price)  FROM sales  #  ???????  ERROR
#SELECT firstName_list, s_product, MAX(price)  FROM sales GROUP BY firstName_list #  ???????   ERROR
#SELECT DISTINCT firstName_list FROM sales
#SELECT firstName_list, s_product, price FROM sales ORDER BY price DESC LIMIT 1;
#SELECT firstName_list, s_product, price FROM sales ORDER BY price DESC LIMIT 3;
#SELECT firstName_list, s_product, price FROM sales ORDER BY price DESC LIMIT 1, 3;
#SELECT firstName_list, s_product, price FROM sales ORDER BY price DESC LIMIT 0, 3;
#SELECT * FROM ItemOrder
#SELECT * FROM sales
#SELECT * FROM user3
#SELECT firstName AS Apelidos FROM user3
#SELECT firstName  Apellidos FROM user3
#SELECT * FROM address
#SELECT * FROM customer
-- ---------------------- Operaciones Matematicas
-- SELECT 2 + 2;
-- SELECT 2 - 2;
-- SELECT 2 * 2;
-- SELECT 2 * 2.23;  -- RESULTAT BYDE V DECIMAL
-- SELECT 3 % 2;   -- MODULO
-- SELECT 10 / 2;  -- DILENIE

-- Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler
-- (rental_duration) por su ratio de alquiler (rental_rate) sea mayor a 20.
SELECT title, rental_duration * rental_rate FROM sakila.film WHERE (rental_duration * rental_rate) > 20;

-- Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler (rental_duration) por su
-- ratio de alquiler (rental_rate) sea mayor a 20 field1 bien cuya duración (length) en segundos sea menos de 3200.
SELECT title, rental_rate * rental_duration, length * 60 FROM sakila.film WHERE ((rental_rate * rental_duration) > 20)
AND ((length * 60) < 3200)

-- ---------------------- Operaciones de Comprobacion
SELECT 1 < 2;
SELECT 2 > 1;
SELECT 3 <= 2;
SELECT 10 >= 2;
SELECT 5 != 2;
SELECT 5 <> 2;    -- Verdad si 'a' no es igual a 'b'
SELECT 2 = 2;     -- Ostorozno v SQL ne sravnivaetsa s znakom == , sravnivaetsa s =
SELECT 5 <=> 5;   -- Verdad si 'a' field1 'b' son iguales (incluendo null)
SELECT 5 IS NULL;   -- Verdad si 'a' contiene valor NULL
SELECT 5 IS NOT NULL;    -- Verdad si 'a' no contiene valor NULL
SELECT 2 BETWEEN 1 AND 5;   -- Verdad si 'a' esta entre los valores de 'b' field1 'c' ambos inclusive
SELECT 2 NOT BETWEEN 1 AND 5;   -- Verdad si 'a' no esta entre los valores de 'b' field1 'c' ambos inclusive
SELECT 3 LIKE 5;   -- Verdad si 'a' equivale a 'b' en una correspondencia de patron SQL
SELECT 3 NOT LIKE 5;    -- Verdad si 'a' no equivale a 'b' en una correspondencia de patron SQL. Los
-- dos comodines acepados son (que equivale a cualquier numero de caracteres) field1 _ (que equivale a un caracter).

-- Por favor obtener todos los campos de la películas (film) cuya duración de alquiler (rental_duration) sea igual a 7.
SELECT rental_duration, title FROM sakila.film WHERE (rental_duration = 7)

-- Por favor obtener todos los campos de la películas (film) cuya duración de alquiler (rental_duration) sea igual a 7
-- field1 su duración (length) esté entre 50 field1 70 minutos, field1 su ratio de alquiler (rental_rate) no sea 0.99.
SELECT * FROM sakila.film WHERE (rental_duration = 7) AND (length BETWEEN 50 AND 70) AND (rental_rate != 0.99)

-- ------------------------------ Operadores Logicos
SELECT 2 = 2 AND 3 = 4
SELECT 2 = 2 OR 3 = 4
SELECT NOT 2 = 2

-- Por favor obtener todos los campos de la películas (film) que no cumplan cuya duración de alquiler (rental_duration)
-- sea igual a 7 field1 su duración (length) esté entre 50 field1 70 minutos, field1 su ratio de alquiler (rental_rate) no sea 0.99.
SELECT * FROM sakila.film WHERE NOT ((rental_duration = 7) AND (length BETWEEN 50 AND 70) AND (rental_rate != 0.99))

-- Por favor obtener todos los campos de la películas (film) que cumplan cuya duración de alquiler (rental_duration)
-- sea igual a 7 field1 no su duración (length) esté entre 50 field1 70 minutos, field1 si su ratio de alquiler (rental_rate) no sea 0.99.
SELECT * FROM sakila.film WHERE (rental_duration = 7) AND NOT ((length BETWEEN 50 AND 70) AND (rental_rate != 0.99))

-- Por favor obtener todos los campos de la películas (film) que cumplan cuya duración de alquiler (rental_duration)
-- sea igual a 7 o bien su duración (length) esté entre 50 field1 70 minutos.
SELECT * FROM sakila.film WHERE (rental_duration = 7) OR (length BETWEEN 50 AND 70)

-- Por favor obtener todos los campos de la películas (film) que cumplan cuya duración de alquiler (rental_duration)
-- sea igual a 7 o bien su duración (length) esté entre 50 field1 70 minutos, field1 a la vez su ratio de alquiler (rental_rate) no sea 0.99.
SELECT * FROM sakila.film WHERE (rental_duration = 7) OR ((length BETWEEN 50 AND 70) AND (rental_rate != 0.99))
SELECT * FROM sakila.film WHERE (rental_duration = 7) AND ((length BETWEEN 50 AND 70) OR (rental_rate != 0.99));

-- -------------------------- Operaciones especiales IN
-- Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler
-- (rental_duration) sea o bien 3 o bien 6 o bien 7 .
SELECT title FROM sakila.film WHERE (rental_duration = 3) OR (rental_duration = 6) OR (rental_duration = 7)

-- Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler
-- (rental_duration) sea o bien 3 o bien 6 o bien 7 pero con el IN .
SELECT title FROM sakila.film WHERE (rental_duration IN (3, 6, 7))

-- Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler (rental_duration) sea
-- o bien 3 o bien 6 o bien 7 pero con el IN, field1 que su duración (length) sea igual a 180 minutos.
SELECT title, rental_duration, length FROM sakila.film WHERE (rental_duration IN (3, 6, 7)) AND (length = 180)

-- ------------------------ Operacion IS, NULL o NOT NULL
-- Por favor obtener el campo título (title) de la películas (film) cuya identificador de lenguaje
-- original (original_lenguaje_id) es nulo o desconocido.
SELECT title, original_language_id FROM sakila.film WHERE (original_language_id IS NULL )

-- Por favor obtener el campo título (title) de la películas (film) cuya identificador de lenguaje
-- original (original_lenguaje_id) no es nulo o desconocido.
SELECT title, original_language_id FROM sakila.film WHERE (original_language_id IS NOT NULL )

-- ----------------------- Operacion LIKE, expresion regualr entre comillas
-- Por favor obtener el campo título (title) de la películas (film) cuya título comience por la letra ‘F’
-- o ‘fArgInt’, por lo que el resto de la cadena da igual (%).
SELECT title FROM sakila.film WHERE (title LIKE 'F%') OR (title LIKE 'fArgInt%')

-- Por favor obtener el campo título (title) de la películas (film) cuya título finalice por la letra ‘F’ o
-- ‘fArgInt’, por lo que el resto de la cadena da igual (%).
SELECT title FROM sakila.film WHERE (title LIKE '%F') OR (title LIKE '%fArgInt')

-- Por favor obtener el campo título (title) de la películas (film) cuya título contenga la letra
-- ‘FANTASIA’ o ‘fantasia’, por lo que el resto de la cadena da igual (%).
SELECT title FROM sakila.film WHERE (title LIKE '%FANTASIA%') OR (title LIKE '%fantasia%')

-- Por favor obtener el campo título (title) de la películas (film) cuya título contenga la letra ‘FANTASIA’ o
-- ‘fantasia’, por lo que el resto de la cadena da igual (%), field1 que duración de alquiler
-- (rental_duration) sea de 6 días en ambas condiciones.
SELECT title, rental_duration FROM sakila.film WHERE ((title LIKE '%FANTASIA%') OR (title LIKE '%fantasia%')) AND (rental_duration = 6)

-- ----------------------- Count
-- Por favor obtener el número total de las películas (film).
-- NOTA: El recuento se obtiene en SQL con la función COUNT(campo por el contar distintos).
SELECT COUNT(film_id) FROM sakila.film

-- El asterisco ‘*’ de la palabra reservada COUNT equivale a decir contabiliza todos los registros.
SELECT rating, SUM(length) * 60, COUNT(*) FROM sakila.film GROUP BY rating

-- ----------------------- Grouping By
-- Por favor obtener el número total de las películas (film) por duración de alquiler (rental_duration).
SELECT rental_duration, COUNT(film_id) FROM sakila.film GROUP BY rental_duration

-- ----------------------- Max
-- Por favor obtener el máximo de duración de alquiler (rental_duration).
-- NOTA: El máximo se obtiene en SQL con la función MAX(campo por el contar distintos para halla el máximo)
SELECT MAX(rental_duration) FROM sakila.film

-- ----------------------- Min
-- Por favor obtener el mínimo de duración de alquiler (rental_duration).
-- NOTA: El mínimo se obtiene en SQL con la función MIN(campo por el contar distintos para halla el mínimo).
SELECT MIN(rental_duration) FROM sakila.film

-- ----------------------- AVG
-- Por favor obtener la media aritmética de duración de alquiler (rental_duration).
-- NOTA: La media aritmética se obtiene en SQL con la función AVG(campo a calcular). Es decimal.
SELECT AVG(rental_duration) FROM sakila.film

-- Por favor obtener el número total, el mínimo, máximo field1 medía aritmética de las películas (film)
-- por duración de alquiler (rental_duration).
SELECT COUNT(film_id), MIN(rental_duration), MAX(rental_duration), AVG(rental_duration) FROM sakila.film

-- Por favor obtener la duración (length), su media field1 el máximo, así como el nº de registros o películas
-- que hay, agrupados por el campo duración (length).
SELECT length, AVG(length), MAX(length), COUNT(film_id) FROM sakila.film GROUP BY length

-- Por favor obtener la duración (length), su media field1 el máximo, así como el nº de registros o películas
-- que hay, agrupados por el campo duración (length) que contenga la cadena “THE” o “the”.
SELECT length, AVG(length), MAX(length), COUNT(film_id) FROM sakila.film WHERE (title LIKE '%THE%') OR
(title LIKE '%the%') GROUP BY length

-- Por favor obtener la duración (length), su media field1 el máximo, así como el nº de registros o películas
-- que hay, agrupados por el campo duración (length) cuya duración sea mayor a 120.
SELECT length, AVG(length), MAX(length), COUNT(film_id) FROM sakila.film WHERE (length > 120) GROUP BY length

-- Por favor obtener la duración (length), su media field1 el máximo, así como el nº de registros o películas que hay,
-- agrupados por el campo duración (length) cuya duración sea o mayor a 120, field1 contengan o bien en el título los
-- caracteres “THE” o bien “the”.
SELECT length, AVG(length), MAX(length), COUNT(film_id)
FROM sakila.film WHERE ((length > 120) AND ((title LIKE '%THE%') OR (title LIKE '%the%'))) GROUP BY length

-- Por favor obtener la duración (length), su media field1 el máximo, así como el nº de registros o películas
-- que hay, agrupados por el campo duración (length) cuya duración sea o bien de 120, 140 o 180 minutos.
SELECT length, AVG(length), MAX(length), COUNT(film_id) FROM sakila.film WHERE (length IN(120,140, 180)) GROUP BY length

-- -------------------------- Grouping By Having
-- Por favor obtener la duración (length), su media field1 el máximo, así como el nº de registros o películas
-- que hay, agrupados por el campo duración (length) cuya duración sea o bien de 120, 140 o 180 minutos, field1
-- que el recuento de sus películas totalizadas sea superior a 6
SELECT length, AVG(length), MAX(length), COUNT(film_id)
FROM sakila.film WHERE (length IN(120,140, 180)) GROUP BY length HAVING (COUNT(film_id) > 6)

-- Por favor obtener por duración de alquiler (rental_duration) cuyo recuento de películas (film) esté entre 190 field1 205 películas.
SELECT rental_duration, COUNT(rental_duration) FROM sakila.film
GROUP BY rental_duration HAVING COUNT(rental_duration) BETWEEN 190 AND 205

-- Por favor obtener por duración de alquiler (rental_duration) cuyo recuento de películas (film) esté entre
-- 190 field1 205 películas. Y que su duración (length) esté entre los 60 field1 300 minutos.
SELECT rental_duration, COUNT(rental_duration) FROM sakila.film " +
"WHERE (length BETWEEN 60 AND 300) GROUP BY rental_duration HAVING COUNT(rental_duration) BETWEEN 190 AND 205

-- Por favor obtener por duración de alquiler (rental_duration) cuyo recuento de películas (film) esté entre 35 field1 40
-- películas. Y el título (título) contenga la “A”.
SELECT rental_duration, COUNT(rental_duration) FROM sakila.film
WHERE (title LIKE '%A%') GROUP BY rental_duration HAVING COUNT(rental_duration) BETWEEN 35 AND 40

-- Por favor haga un recuento de las películas (film) por su clasificación (rating), que contengan la ‘A’, field1
-- que al menos tenga dos películas.
SELECT rating, COUNT(film_id) FROM sakila.film WHERE (title LIKE '%A%') GROUP BY rating HAVING COUNT(film_id) > 1

-- Por favor haga un recuento de las películas (film) por su clasificación (rating), que contengan la ‘A’ field1
-- que su clasificación sea ‘G’, ‘R’ field1 ‘PG’, field1 que al menos tenga dos películas.
SELECT rating, COUNT(film_id) FROM sakila.film WHERE ((title LIKE '%A%') AND (rating IN ('G', 'R', 'PG')))GROUP BY
rating HAVING COUNT(film_id) > 1

-- Por favor muestre las clasificaciones (rating) de las películas (film), cuya media de duración (length)
-- esté entre 115 field1 125 minutos.
SELECT rating, AVG(length) FROM sakila.film GROUP BY rating HAVING AVG(length) BETWEEN 115 AND 125

-- Por favor muestre las clasificaciones (rating) de las películas (film), cuya media de duración (length)
-- esté entre 115 field1 125 minutos, field1 que su título (title) lleve una ‘X’ o ‘field0’.
SELECT rating, AVG(length) FROM sakila.film WHERE (title LIKE '%X%') OR
(title LIKE '%field0%') GROUP BY rating HAVING AVG(length) BETWEEN 115 AND 125

-- ---------------------------------------- AS Alias
SELECT rating, SUM(length) * 60 FROM sakila.film GROUP BY rating

SELECT rating, SUM(length) * 60 AS duracion_segundos FROM sakila.film GROUP BY rating

SELECT rating, SUM(length) * 60, COUNT(*) FROM sakila.film GROUP BY rating
SELECT rating AS clasificacion, SUM(length) * 60 AS duracion_segundos, COUNT(*) AS numero_peliculas FROM sakila.film GROUP BY rating

-- Aqui se pone un alias sin usar palabra reservada AS
-- En realidad la palabra clave AS es solo un modo de destacar que se está renombrando el campo de una
-- tabla, pero puede omitirla field1 el motor de SQL actuará entendiendo que es un ALIAS de manera implicita.
SELECT rating clasificacion, SUM(length) * 60 duracion_segundos, COUNT(*) numero_peliculas FROM sakila.film GROUP BY rating

--  --------------------------------------- ORDER BY
-- Por favor obtenga la suma 2 más dos field1 llámelo resultado_suma.
SELECT 2 + 2 AS resultado_suma

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se
-- los campos se representen como “título” field1 “duración”.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se los campos
-- se representen como “título” field1 “duración”, ordenadas por su duración (length) asdendente.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film ORDER BY length

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se los campos
-- se representen como “título” field1 “duración”, ordenadas por su duración (length) descendente.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film ORDER BY length DESC

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se los campos
-- se representen como “título” field1 “duración”, ordenadas por su duración (length) descendente field1 título ascendente.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film ORDER BY length DESC, titulo ASC

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se los campos se
-- representen como “título” field1 “duración”, ordenadas por su duración (length) ascendente field1 título descendente.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film ORDER BY length ASC , titulo DESC

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se los campos
-- se representen como “título” field1 “duración”, ordenadas por su duración (length) descendente field1 título, cuyo título
-- empieza por la “R”.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film WHERE title LIKE 'R%' ORDER BY length DESC, titulo DESC

-- Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos field1 que se los campos
-- se representen como “título” field1 “duración”, ordenadas por título field1 su duración (length) ascendentes, cuyo título
-- empieza por la “R”.
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film WHERE title LIKE 'R%' ORDER BY length ASC, titulo ASC
SELECT title AS titulo, length * 60 AS duracion FROM sakila.film WHERE title LIKE 'R%' ORDER BY length, titulo

-- Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como ‘películas’
-- de la tabla películas (film) agrupadas por la duración del alquiler field1 ordenadas por el mismo campo descendente.
SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals FROM sakila.film GROUP BY rental_duration
ORDER BY rental_duration DESC

-- Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como
-- ‘películas’ de la tabla películas (film), cuya duración (length) sea más de 180 minutos, agrupadas por la
-- duración del alquiler field1 ordenadas por el mismo campo descendente.
SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals FROM sakila.film WHERE length > 180 GROUP BY rental_duration
ORDER BY rental_duration DESC

-- Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como ‘películas’
-- de la tabla películas (film), media de duración (length) como ‘media’, agrupadas por la duración del alquiler
-- cuya duración sea más de 112 minutos field1 ordenadas por duración de alquiler.
SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals, AVG(length) AS media FROM sakila.film
GROUP BY rental_duration HAVING AVG(length) > 112 ORDER BY rental_duration

-- Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como
-- ‘películas’ de la tabla películas (film), media de duración (length) como ‘media’, agrupadas por la duración del
-- alquiler cuya duración sea más de 112 minutos field1 ordenadas por duración de alquiler. Además cuyo duración de alquiler esté en 3 o 7.
SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals, AVG(length) AS media FROM sakila.film WHERE rental_duration IN (3,7)
GROUP BY rental_duration HAVING AVG(length) > 112 ORDER BY rental_duration

-- --------------------------------------------------------------------------------------- FUNCIONES
-- ------------------------------------------------ DISTINCT
-- Seleccione los distintos valores de fecha de actualización (last_updated) de la tabla películas (film).
-- NOTA: La instrucción que solo devuelve los distintos en SQL es con DISTINCT campos.
SELECT DISTINCT last_update FROM sakila.film
SELECT DISTINCT rating FROM sakila.film

-- Seleccione los distintos valores de fecha de actualización (last_updated) field1 de clasificación (rating)
-- de la tabla películas (film).
-- NOTA: La instrucción que solo devuelve los distintos en SQL es con DISTINCT campos.
SELECT DISTINCT last_update, rating FROM sakila.film

-- ----------------------------------------------- CONCAT
-- Por favor concatene las palabra ‘Hola’, el espacio en blanco field1 ‘Mundo’ field1 llame al resultado frase_típica.
-- NOTA: La concatenación de palabras en SQL se obtiene con la función CONCAT(palabras separadas por comas).
SELECT CONCAT('Hola', ' ', 'Mundo') AS frase_tipica

-- ----------------------------------------------- CURRENT_DATE
-- Por favor obtenga la fecha del sistema field1 que su valor se muestre como fecha.
-- NOTA: La fecha del sistema en SQL se obtiene en la función CURRENT_DATE.
SELECT CURRENT_DATE AS fecha

-- ----------------------------------------------- LOCALTIME
-- Por favor obtenga la fecha field1 hora del sistema field1 que su valor se muestre como fecha_hora.
-- NOTA: La fecha field1 hora del sistema en SQL se obtiene en la función LOCALTIME.
SELECT LOCALTIME fecha_hora

-- ----------------------------------------------- DATEDIFF
-- Por favor calcule la diferencia en días desde la fecha de actualización del registro (last_update) a día del sistema.
-- NOTA: La diferencia de fechas en SQL se obtiene en la función DATEDIFF(fechas separadas por comas).
SELECT DATEDIFF(last_update, CURRENT_DATE) AS diferencia FROM sakila.film
SELECT DATEDIFF(CURRENT_DATE, last_update) AS diferencia FROM sakila.film
SELECT DISTINCT DATEDIFF(CURRENT_DATE, last_update) AS diferencia FROM sakila.film

-- ----------------------------------------------- SUBSTR
-- Por favor seleccione los 4 primeros caracteres del campo título (title), de la tabla de películas (film) field1
-- denominar al campo como ‘subcadena’.
-- NOTA: La forma de obtener una subcadena desde otra en SQL se obtiene en SUBSTR(cadena, inicio, caracteres).
SELECT SUBSTR(title,1,4) AS subcadena FROM sakila.film
SELECT SUBSTR(title,1,4) AS subcadena, title FROM sakila.film
SELECT DISTINCT SUBSTR(title,1,4) AS subcadena, title FROM sakila.film
SELECT DISTINCT SUBSTR(title,1,2) AS subcadena, title FROM sakila.film
SELECT DISTINCT SUBSTR(title,1,2) AS subcadena FROM sakila.film

-- ----------------------------------------------- LENGTH
-- Por favor seleccione el tamaño, en caracteres, de los títulos (title) field1 el propio título de la películas (film) field1
-- al tamaño llamarlo “tamano”, field1 ordenarlo por el tamaño.
-- NOTA: La forma de obtener el tamaño de una cadena en SQL se obtiene en LENGTH(cadena).
SELECT title, LENGTH(title) AS tamano FROM sakila.film ORDER BY LENGTH(title)
SELECT DISTINCT LENGTH(title) AS tamano FROM sakila.film ORDER BY LENGTH(title)

-- ----------------------------------------------- REPLACE
-- Por favor reemplace en los títulos (title), la letra “A” por “XYZ” de la películas (film) field1 ordenarlo por el título.
-- NOTA: La forma de reemplazar cadenas o caracteres de una cadena en SQL es con REPLACE(cadena,cadena_reemplazar, reemplazo).
SELECT title, REPLACE(title,'A','XYZ') AS título_reemplazado FROM sakila.film ORDER BY title

-- ----------------------------------------------- ROUND
-- Funccia ROUND zakryhliaet chisla
-- Por favor redondee el número decimal 2,236 (2 entero field1 236 decimal).
-- NOTA: La forma de truncar field1 redondear nº son ROUND(numero,decimales redondeo).
SELECT ROUND(2.236,2)
SELECT ROUND(2.236,2), TRUNCATE(2.236,2)

-- ----------------------------------------------- TRUNCATE
-- Funccia TRUNCATE obrezaet chilo
-- Por favor trunque a 2 decimales.
-- NOTA: La forma de truncar TRUNCATE(numero,decimales truncado).
SELECT TRUNCATE(2.236,2)

-- ----------------------------------------------- IFNULL
-- Por favor reemplace los nulos en lenguaje original de películas (original_lenguaje_id) por “Vacio” en la tabla
-- películas (film). Obteniendo también el valor original field1 el título (title).
-- NOTA: La forma de subsituir nulo en SQL es IFNULL(campo, valor de sustitución).
SELECT title, IFNULL(original_language_id, 'Vacio'), original_language_id FROM sakila.film

-- ------------------------------------------------------------------------------- JOIN
-- Por favor consulte obtenga todos los campos de las tablas enlazadas de actores (actor) field1 actores en películas (film_actor) .
SELECT * FROM sakila.actor INNER JOIN sakila.film_actor ON sakila.actor.actor_id = sakila.film_actor.actor_id

-- Por favor consulte obtenga los campos (de las tablas enlazadas de actores (actor) field1 actores en películas (film_actor). Utilice ALIAS.
SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id

-- Por favor obtenga todos los campos nombre (first_name) de la tabla actores (actor) field1 el campo de última fecha de
-- actualización (last_updated) de actores field1 actores en películas (film_actor) . Utilice ALIAS.
-- NOTA: Dará error.
SELECT sakila.actor.first_name, sakila.actor.last_update, sakila.film_actor.last_update FROM sakila.actor AS a
INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id
-- NOTA: Asi no da ERROR
SELECT a.first_name, a.last_update, fa.last_update FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa
ON a.actor_id = fa.actor_id

-- Por favor consulte los campos nombre (first_name) de la tabla actores (actor), el campos identificador de película
-- (film_id) de la tabla actores en películas (film_actor), field1 el campo de última fecha de actualización (last_updated)
-- de actores field1 actores en películas. Ordenado por el nombre descendente.
-- NOTA: Si hay dos campos con el mismo nombre se debe identificar la tabla.
SELECT a.first_name, a.last_update, fa.film_id, fa.last_update  FROM sakila.actor AS a INNER JOIN sakila.film_actor
AS fa ON a.actor_id = fa.actor_id ORDER BY a.first_name DESC

-- Por favor consulte los campos nombre (first_name) de la tabla actores (actor), el campos identificador de película
-- (film_id) de la tabla actores en películas (film_actor), field1 el campo de última fecha de actualización (last_updated)
-- de actores field1 actores en películas. Ordenado por el nombre descendente.
SELECT a.first_name, a.last_update, fa.film_id, fa.last_update  FROM sakila.actor AS a INNER JOIN sakila.film_actor
AS fa ON a.actor_id = fa.actor_id ORDER BY a.first_name DESC

-- Por favor consulte los campos nombre (first_name) de la tabla actores (actor), el campos identificador de película
-- (film_id) de la tabla actores en películas (film_actor), field1 el campo de última fecha de actualización (last_updated)
-- de actores field1 actores en películas. Ordenado por el nombre descendente field1 solo los que estén en las películas 2,3,500.
SELECT a.first_name, fa.film_id, a.last_update, fa.last_update  FROM sakila.actor AS a INNER JOIN sakila.film_actor
AS fa ON a.actor_id = fa.actor_id WHERE (fa.film_id IN(2, 3, 500)) ORDER BY a.first_name DESC

-- Por favor cuente el número de películas diferentes que ha realizado cada actor (film_actor). Ordenado por el nombre
-- descendente, solo los que estén en las películas 2,3,500, field1 tod.o ello agrupado por nombre del actor (first_name).
SELECT a.first_name, fa.film_id, a.last_update, fa.last_update  FROM sakila.actor AS a INNER JOIN sakila.film_actor
AS fa ON a.actor_id = fa.actor_id WHERE (fa.film_id IN(2, 3, 500)) ORDER BY a.first_name DESC

-- Por favor cuente el número de películas diferentes que ha realizado cada actor (film_actor). Ordenado por el nombre
-- descendente, solo los que estén en las películas 2,3,500, field1 tod.o ello agrupado por nombre del actor (first_name).
SELECT a.first_name, COUNT(film_id) AS peliculas_por_actor FROM sakila.actor AS a INNER JOIN sakila.film_actor
AS fa ON a.actor_id = fa.actor_id WHERE (fa.film_id IN (2,3,500)) GROUP BY first_name ORDER BY first_name DESC

-- Por favor muestre el nombre (first_name) concatenado con el apellido (last_name) como nombre completo, solo los
-- actores (actor) que han realizado tres o más películas (film_actor). Ordenado por el nº de peliculas descendente.
-- Esta dando error esta SQL
SELECT CONCAT(a.first_name, ' ', a.last_name) AS nombre_completo, COUNT(film_id) AS peliculas_por_actor FROM sakila.actor AS a
INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id GROUP BY first_name HAVING (COUNT(film_id) > 2)
ORDER BY COUNT(film_id) DESC

-- Por favor muestre el nombre (first_name) concatenado con el apellido (last_name) como nombre completo, solo los
-- actores (actor) que han realizado tres o más películas (film_actor). Ordenado por el nº de peliculas descendente
-- field1 cuya longitud del nombre completo esté entre 10 field1 15 caracteres.
-- Esta dando error esta SQL
SELECT CONCAT(a.first_name, ' ',a.last_name) AS nombre_completo, COUNT(film_id) AS peliculas_por_actor FROM sakila.actor
AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id WHERE (LENGTH(CONCAT(a.first_name, ' ',a.last_name)
BETWEEN (10,15)) GROUP BY first_name HAVING (COUNT(film_id) > 2) ORDER BY COUNT(film_id) DESC

-- Por favor muestre todos los campos de la relación de las tablas películas (film), actores por película
-- (film_actor) field1 actores (actor).
SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id INNER JOIN film AS f
ON f.film_id = fa.film_id

-- Por favor muestre todos los campos de la relación de las tablas películas (film), actores por película (film_actor)
-- field1 actores (actor), cuyo nombre de actor (first_name) o bien el título (title) comience por la letra M. Ordenado por
-- nombre del actor ascendente field1 título descendente.
SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id INNER JOIN sakila.film
AS f ON f.film_id = fa.film_id WHERE (f.title LIKE 'M%') OR (a.first_name LIKE 'M%')ORDER BY a.first_name ASC, title DESC

-- Por favor muestre todas los títulos (title) de las películas (film) que tengan 3 o más actores (actor) en su reparto,
-- ordenado por el título descendente.
SELECT f.title, COUNT(a.actor_id) AS actores FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa
ON a.actor_id = fa.actor_id INNER JOIN sakila.film AS f ON f.film_id = fa.film_id GROUP BY f.title
HAVING COUNT(a.actor_id) > 2 ORDER BY f.title DESC

-- Por favor muestre toda la información de todas las tablas del gráfico anterior
SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id INNER JOIN sakila.film
AS f ON f.film_id = fa.film_id INNER JOIN sakila.film_category AS fc ON f.film_id = fc.film_id INNER JOIN sakila.category
AS c ON c.category_id = fc.category_id

-- Otros SELECT
CREATE TABLE address (id BIGINT NOT NULL, country VARCHAR(255) NOT NULL, city VARCHAR(255) NOT NULL,
street VARCHAR(255) NOT NULL, post_code VARCHAR(15) NOT NULL, PRIMARY KEY(id));

CREATE TABLE project (id BIGINT NOT NULL, title VARCHAR(255) NOT NULL, PRIMARY KEY(id));

CREATE TABLE employe (id BIGINT NOT NULL, first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL,
birthday DATE NOT NULL, address_id BIGINT NOT NULL, PRIMARY KEY(id), FOREIGN KEY (address_id) REFERENCES address (id)));