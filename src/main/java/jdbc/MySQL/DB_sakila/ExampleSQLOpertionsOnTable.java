package jdbc.MySQL.DB_sakila;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleSQLOpertionsOnTable {
    // -------------------------------------------------- Operaciones Matematicas ------------------------------------------
    private static final String QUERY = "SELECT 2 + 2";
    private static final String QUERY1 = "SELECT 2 - 2";
    private static final String QUERY2 = "SELECT 3 * 2";
    private static final String QUERY3 = "SELECT 10 / 2";
    private static final String QUERY4 = "SELECT 5 % 2";

    // Por favor obtener el campo título (title) de la
    // películas (film) cuya duración de alquiler
    // (rental_duration) por su ratio de alquiler
    // (rental_rate) sea mayor a 20.
    private static final String QUERY5 = "SELECT title, rental_duration * rental_rate FROM sakila.film WHERE " +
            "(rental_duration * rental_rate) > 20;";

    // Por favor obtener el campo título (title) de la
    // películas (film) cuya duración de alquiler
    // (rental_duration) por su ratio de alquiler
    // (rental_rate) sea mayor a 20 y bien cuya duración
    // (length) en segundos sea menos de 3200.
    private static final String QUERY6 = "SELECT title, rental_rate * rental_duration, length * 60 FROM " +
            "sakila.film WHERE ((rental_rate * rental_duration) > 20) AND ((length * 60) < 3200)";

    // ------------------------------------------------- Comparoaciones ----------------------------------------------------
    private static final String QUERY7 = "SELECT 1 < 2";
    private static final String QUERY8 = "SELECT 2 > 1";
    private static final String QUERY9 = "SELECT 3 <= 2";
    private static final String QUERY10 = "SELECT 10 >= 2";
    private static final String QUERY11 = "SELECT 5 != 2";
    private static final String QUERY14 = "SELECT 5 <> 2"; // Verdad si 'a' no es igual a 'b'
    private static final String QUERY12 = "SELECT 2 = 2"; // Ostorozno v SQL ne sravnivaetsa s znakom == , sravnivaetsa s =
    private static final String QUERY13 = "SELECT 5 <=> 5"; // Verdad si 'a' y 'b' son iguales (incluendo null)
    private static final String QUERY15 = "SELECT 5 IS NULL"; // Verdad si 'a' contiene valor NULL
    private static final String QUERY16 = "SELECT 5 IS NOT NULL"; // Verdad si 'a' no contiene valor NULL
    private static final String QUERY17 = "SELECT 2 BETWEEN 1 AND 5"; // Verdad si 'a' esta entre los valores de 'b' y 'c' ambos inclusive
    private static final String QUERY18 = "SELECT 2 NOT BETWEEN 1 AND 5"; // Verdad si 'a' no esta entre los valores de 'b' y 'c' ambos inclusive
    private static final String QUERY19 = "SELECT 3 LIKE 5"; // Verdad si 'a' equivale a 'b' en una correspondencia de patron SQL
    private static final String QUERY20 = "SELECT 3 NOT LIKE 5"; // Verdad si 'a' no equivale a 'b' en una correspondencia de patron SQL. Los
    // dos comodines acepados son (que equivale a cualquier numero de caracteres) y _ (que equivale a un caracter).

    // Por favor obtener todos los campos de la películas (film) cuya duración de alquiler (rental_duration) sea igual a 7.
    private static final String QUERY21 = "SELECT rental_duration, title FROM sakila.film WHERE (rental_duration = 7)";

    // Por favor obtener todos los campos de la películas (film) cuya duración de alquiler (rental_duration) sea igual
    // a 7 y su duración (length) esté entre 50 y 70 minutos, y su ratio de alquiler (rental_rate) no sea 0.99.
    private static final String QUERY22 = "SELECT * FROM sakila.film WHERE (rental_duration = 7) AND (length BETWEEN " +
            "50 AND 70) AND (rental_rate != 0.99)";

    // ----------------------------------------------- Operadores Logicos --------------------------------------------------
    private static final String QUERY23 = "SELECT 2 = 2 AND 3 = 4";
    private static final String QUERY24 = "SELECT 2 = 2 OR 3 = 4";
    private static final String QUERY25 = "SELECT NOT 2 = 2";

    // Por favor obtener todos los campos de la películas (film) que no cumplan cuya duración de alquiler (rental_duration)
    // sea igual a 7 y su duración (length) esté entre 50 y 70 minutos, y su ratio de alquiler (rental_rate) no sea 0.99.
    private static final String QUERY26 = "SELECT * FROM sakila.film WHERE NOT ((rental_duration = 7) AND (length " +
            "BETWEEN 50 AND 70) AND (rental_rate != 0.99))";

    // Por favor obtener todos los campos de la películas (film) que cumplan cuya duración de alquiler (rental_duration)
    // sea igual a 7 y no su duración (length) esté entre 50 y 70 minutos, y si su ratio de alquiler (rental_rate) no sea 0.99.
    private static final String QUERY27 = "SELECT * FROM sakila.film WHERE (rental_duration = 7) AND NOT " +
            "((length BETWEEN 50 AND 70) AND (rental_rate != 0.99))";

    // Por favor obtener todos los campos de la películas (film) que cumplan cuya duración de alquiler
    // (rental_duration) sea igual a 7 o bien su duración (length) esté entre 50 y 70 minutos.
    private static final String QUERY28 = "SELECT * FROM sakila.film WHERE (rental_duration = 7) OR (length BETWEEN 50 AND 70)";

    // Por favor obtener todos los campos de la películas (film) que cumplan cuya duración de alquiler (rental_duration)
    // sea igual a 7 o bien su duración (length) esté entre 50 y 70 minutos, y a la vez su ratio de alquiler
    // (rental_rate) no sea 0.99.
    private static final String QUERY29 = "SELECT * FROM sakila.film WHERE (rental_duration = 7) OR " +
            "((length BETWEEN 50 AND 70) AND (rental_rate != 0.99))";
    private static final String QUERY30 = "SELECT * FROM sakila.film WHERE (rental_duration = 7) AND " +
            "((length BETWEEN 50 AND 70) OR (rental_rate != 0.9));";

    // --------------------------------------------------- IN --------------------------------------------------------------
    // Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler
    // (rental_duration) sea o bien 3 o bien 6 o bien 7 .
    private static final String QUERY31 = "SELECT title FROM sakila.film WHERE (rental_duration = 3) OR " +
            "(rental_duration = 6) OR (rental_duration = 7)";

    // Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler
    // (rental_duration) sea o bien 3 o bien 6 o bien 7 pero con el IN .
    private static final String QUERY32 = "SELECT title FROM sakila.film WHERE (rental_duration IN (3, 6, 7))";

    // Por favor obtener el campo título (title) de la películas (film) cuya duración de alquiler (rental_duration) sea
    // o bien 3 o bien 6 o bien 7 pero con el IN, y que su duración (length) sea igual a 180 minutos.
    private static final String QUERY33 = "SELECT title, rental_duration, length FROM sakila.film WHERE " +
            "(rental_duration IN (3, 6, 7)) AND (length = 180)";

    // --------------------------------------------- IS NULL o NOT NULL ---------------------------------------------------
    // Por favor obtener el campo título (title) de la películas (film) cuya identificador de lenguaje
    // original (original_lenguaje_id) es nulo o desconocido.
    private static final String QUERY34 = "SELECT title, original_language_id FROM sakila.film WHERE " +
            "(original_language_id IS NULL )";

    // Por favor obtener el campo título (title) de lacpelículas (film) cuya identificador de lenguaje
    // original (original_lenguaje_id) no es nulo o desconocido.
    private static final String QUERY35 = "SELECT title, original_language_id FROM sakila.film WHERE " +
            "(original_language_id IS NOT NULL )";

    // ----------------------------------- LIKE, expresion regualr entre comillas ------------------------------------------
    // Por favor obtener el campo título (title) de lacpelículas (film) cuya título comience por la letra ‘F’
    // o ‘fArgInt’, por lo que el resto de la cadena da igual (%).
    private static final String QUERY36 = "SELECT title FROM sakila.film WHERE (title LIKE 'F%') OR (title LIKE 'fArgInt%')";

    // Por favor obtener el campo título (title) de lacpelículas (film) cuya título finalice por la letra ‘F’ o
    // ‘fArgInt’, por lo que el resto de la cadena da igual (%).
    private static final String QUERY37 = "SELECT title FROM sakila.film WHERE (title LIKE '%F') OR (title LIKE '%fArgInt')";

    // Por favor obtener el campo título (title) de lacpelículas (film) cuya título contenga la letrac‘FANTASIA’ o
    // ‘fantasia’, por lo que el resto de laccadena da igual (%).
    private static final String QUERY38 = "SELECT title FROM sakila.film WHERE (title LIKE '%FANTASIA%') OR " +
            "(title LIKE '%fantasia%')";

    // Por favor obtener el campo título (title) de lacpelículas (film) cuya título contenga la letra FANTASIA’ o
    // ‘fantasia’, por lo que el resto de la cadena da igual (%), y que duración de alquiler
    // (rental_duration) sea de 6 días en ambas condiciones.
    private static final String QUERY39 = "SELECT title, rental_duration FROM sakila.film WHERE " +
            "((title LIKE '%FANTASIA%') OR (title LIKE '%fantasia%')) AND (rental_duration = 6)";

    // ------------------------------------------------ Count --------------------------------------------------------------
    // Por favor obtener el número total de las películas (film).
    // NOTA: El recuento se obtiene en SQL con la función COUNT(campo por el contar distintos).
    private static final String QUERY40 = "SELECT COUNT(film_id) FROM sakila.film";

    // El asterisco ‘*’ de la palabra reservada COUNT equivale a decir contabiliza todos los registros.
    private static final String QUERY65 = "SELECT rating, SUM(length) * 60, COUNT(*) FROM sakila.film GROUP BY rating";

    // ----------------------------------------------- Grouping By ---------------------------------------------------------
    // Por favor obtener el número total de las películas (film) por duración de alquiler (rental_duration).
    private static final String QUERY41 = "SELECT rental_duration, COUNT(film_id) FROM sakila.film GROUP BY rental_duration";

    // -------------------------------------------------- Max --------------------------------------------------------------
    // Por favor obtener el máximo de duración de alquiler (rental_duration).
    // NOTA: El máximo se obtiene en SQL con la función MAX(campo por el contar distintos para halla el máximo)
    private static final String QUERY42 = "SELECT MAX(rental_duration) FROM sakila.film";

    // -------------------------------------------------- Min --------------------------------------------------------------
    // Por favor obtener el mínimo de duración de alquiler (rental_duration).
    // NOTA: El mínimo se obtiene en SQL con la función MIN(campo por el contar distintos para halla el mínimo).
    private static final String QUERY43 = "SELECT MIN(rental_duration) FROM sakila.film";

    // -------------------------------------------------- AVG --------------------------------------------------------------
    // Por favor obtener la media aritmética de duración de alquiler (rental_duration).
    // NOTA: La media aritmética se obtiene en SQL con la función AVG(campo a calcular). Es decimal.
    private static final String QUERY44 = "SELECT AVG(rental_duration) FROM sakila.film";

    // Por favor obtener el número total, el mínimo, máximo y medía aritmética de las películas (film)
    // por duración de alquiler (rental_duration).
    private static final String QUERY45 = "SELECT COUNT(film_id), MIN(rental_duration), MAX(rental_duration), " +
            "AVG(rental_duration) FROM sakila.film";

    // ------------------------------------------------ others -------------------------------------------------------------
    // Por favor obtener la duración (length), su media y el máximo, así como el nº de registros o películas
    // que hay, agrupados por el campo duración (length).
    private static final String QUERY46 = "SELECT length, AVG(length), MAX(length), COUNT(film_id)" +
            "FROM sakila.film GROUP BY length";
    private static final String QUERY47 = "SELECT length, AVG(length), MAX(length), COUNT(film_id) FROM sakila.film";

    // Por favor obtener la duración (length), su media y el máximo, así como el nº de registros o películas
    // que hay, agrupados por el campo duración (length) que contenga la cadena “THE” o “the”.
    private static final String QUERY48 = "SELECT length, AVG(length), MAX(length), COUNT(film_id) " +
            "FROM sakila.film WHERE (title LIKE '%THE%') OR (title LIKE '%the%') GROUP BY length";

    // Por favor obtener la duración (length), su media y el máximo, así como el nº de registros o películas
    // que hay, agrupados por el campo duración (length) cuya duración sea mayor a 120.
    private static final String QUERY49 = "SELECT length, AVG(length), MAX(length), COUNT(film_id) " +
            "FROM sakila.film WHERE (length > 120) GROUP BY length";

    // Por favor obtener la duración (length), su media y el máximo, así como el nº de registros o películas que hay,
    // agrupados por el campo duración (length) cuya duración sea o mayor a 120, y contengan o bien en el título los
    // caracteres “THE” o bien “the”.
    private static final String QUERY50 = "SELECT length, AVG(length), MAX(length), COUNT(film_id) " +
            "FROM sakila.film WHERE ((length > 120) AND ((title LIKE '%THE%') OR (title LIKE '%the%'))) GROUP BY length";

    // Por favor obtener la duración (length), su media y el máximo, así como el nº de registros o películas
    // que hay, agrupados por el campo duración (length) cuya duración sea o bien de 120, 140 o 180 minutos.
    private static final String QUERY51 = "SELECT length, AVG(length), MAX(length), COUNT(film_id) " +
            "FROM sakila.film WHERE (length IN(120,140, 180)) GROUP BY length";

    // ---------------------------------------------- Grouping By Having ---------------------------------------------------
    // Por favor obtener la duración (length), su media y el máximo, así como el nº de registros o películas
    // que hay, agrupados por el campo duración (length) cuya duración sea o bien de 120, 140 o 180 minutos, y
    // que el recuento de sus películas totalizadas sea superior a 6
    private static final String QUERY52 = "SELECT length, AVG(length), MAX(length), COUNT(film_id) " +
            "FROM sakila.film WHERE (length IN(120,140, 180)) GROUP BY length HAVING (COUNT(film_id) > 6)";

    // Por favor obtener por duración de alquiler (rental_duration) cuyo recuento de películas (film) esté entre 190 y
    // 205 películas.
    private static final String QUERY53 = "SELECT rental_duration, COUNT(rental_duration) FROM sakila.film " +
            "GROUP BY rental_duration HAVING COUNT(rental_duration) BETWEEN 190 AND 205";

    // Por favor obtener por duración de alquiler (rental_duration) cuyo recuento de películas (film) esté entre
    // 190 y 205 películas. Y que su duración (length) esté entre los 60 y 300 minutos.
    private static final String QUERY54 = "SELECT rental_duration, COUNT(rental_duration) FROM sakila.film " +
            "WHERE (length BETWEEN 60 AND 300) GROUP BY rental_duration HAVING COUNT(rental_duration) BETWEEN 190 AND 205";

    // Por favor obtener por duración de alquiler (rental_duration) cuyo recuento de películas (film) esté entre 35 y 40
    // películas. Y el título (título) contenga la “A”.
    private static final String QUERY55 = "SELECT rental_duration, COUNT(rental_duration) FROM sakila.film " +
            "WHERE (title LIKE '%A%') GROUP BY rental_duration HAVING COUNT(rental_duration) BETWEEN 35 AND 40";

    // Por favor haga un recuento de las películas (film) por su clasificación (rating), que contengan la ‘A’, y
    // que al menos tenga dos películas.
    private static final String QUERY56 = "SELECT rating, COUNT(film_id) FROM sakila.film " +
            "WHERE (title LIKE '%A%') GROUP BY rating HAVING COUNT(film_id) > 1";

    // Por favor haga un recuento de las películas (film) por su clasificación (rating), que contengan la ‘A’ y
    // que su clasificación sea ‘G’, ‘R’ y ‘PG’, y que al menos tenga dos películas.
    private static final String QUERY57 = "SELECT rating, COUNT(film_id) FROM sakila.film " +
            "WHERE ((title LIKE '%A%') AND (rating IN ('G', 'R', 'PG')))GROUP BY rating HAVING COUNT(film_id) > 1";

    // Por favor muestre las clasificaciones (rating) de las películas (film), cuya media de duración (length)
    // esté entre 115 y 125 minutos.
    private static final String QUERY58 = "SELECT rating, AVG(length) FROM sakila.film " +
            "GROUP BY rating HAVING AVG(length) BETWEEN 115 AND 125";

    // Por favor muestre las clasificaciones (rating) de las películas (film), cuya media de duración (length)
    // esté entre 115 y 125 minutos, y que su título (title) lleve una ‘X’ o ‘x’.
    private static final String QUERY59 = "SELECT rating, AVG(length) FROM sakila.film WHERE (title LIKE '%X%') OR " +
            "(title LIKE '%x%') GROUP BY rating HAVING AVG(length) BETWEEN 115 AND 125";

    // ----------------------------------------------- AS Alias ------------------------------------------------------------
    private static final String QUERY60 = "SELECT rating, SUM(length) * 60 FROM sakila.film GROUP BY rating";
    // En realidad la palabra clave AS es solo un modo de destacar que se está renombrando el campo de una
    // tabla, pero puede omitirla y el motor de SQL actuará entendiendo que es un ALIAS de manera implicita
    private static final String QUERY61 = "SELECT rating, SUM(length) * 60 AS duracion_segundos FROM sakila.film GROUP BY rating";
    // Se puede poner un alias si usar palabra resevada AS
    private static final String QUERY62 = "SELECT rating, SUM(length) * 60 duracion_segundos FROM sakila.film GROUP BY rating";

    // El asterisco ‘*’ de la palabra reservada COUNT equivale a decir contabiliza todos los registros.
    private static final String QUERY63 = "SELECT rating, SUM(length) * 60, COUNT(*) FROM sakila.film GROUP BY rating";
    private static final String QUERY64 = "SELECT rating AS clasificacion, SUM(length) * 60 AS duracion_segundos, " +
            "COUNT(*) AS numero_peliculas FROM sakila.film GROUP BY rating";
    // Aqui se pone un alias sin usar palabra reservada AS
    // En realidad la palabra clave AS es solo un modo de destacar que se está renombrando el campo de una
    // tabla, pero puede omitirla y el motor de SQL actuará entendiendo que es un ALIAS de manera implicita.
    private static final String QUERY66 = "SELECT rating clasificacion, SUM(length) * 60 duracion_segundos, " +
            "COUNT(*) numero_peliculas FROM sakila.film GROUP BY rating";

//------------------------------------------------- ORDER BY -----------------------------------------------------------
    // PARA LA ORDENACIÓN DEBEMOS INDICAR EL TIPO DE ORDENACIÓN ASCENDENTE (ASC) O DESCENDENTE (DESC)
    // Por defecto si no se indica de manera expresa el tipo de condición, será ASCENDENTE (ASC).

    // Por favor obtenga la suma 2 más dos y llámelo resultado_suma.
    private static final String QUERY67 = "SELECT 2 + 2 AS resultado_suma";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se
    // los campos se representen como “título” y “duración”.
    private static final String QUERY68 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se los campos
    // se representen como “título” y “duración”, ordenadas por su duración (length) asdendente.
    private static final String QUERY69 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film ORDER BY length";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se los campos
    // se representen como “título” y “duración”, ordenadas por su duración (length) descendente.
    private static final String QUERY70 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film ORDER BY length DESC";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se los campos
    // se representen como “título” y “duración”, ordenadas por su duración (length) descendente y título ascendente.
    private static final String QUERY71 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film " +
            "ORDER BY length DESC, titulo ASC";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se los campos se
    // representen como “título” y “duración”, ordenadas por su duración (length) ascendente y título descendente.
    private static final String QUERY72 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film " +
            "ORDER BY length ASC , titulo DESC ";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se los campos
    // se representen como “título” y “duración”, ordenadas por su duración (length) descendente y título, cuyo título
    // empieza por la “R”.
    private static final String QUERY73 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film " +
            "WHERE title LIKE 'R%' ORDER BY length DESC , titulo DESC ";

    // Por favor obtenga el título (title) de las películas (film), su duración (length) en segundos y que se los campos
    // se representen como “título” y “duración”, ordenadas por título y su duración (length) ascendentes, cuyo título
    // empieza por la “R”.
    private static final String QUERY74 = "SELECT title AS titulo, length * 60 AS duracion FROM sakila.film " +
            "WHERE title LIKE 'R%' ORDER BY length ASC, titulo ASC";

    // Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como ‘películas’
    // de la tabla películas (film) agrupadas por la duración del alquiler y ordenadas por el mismo campo descendente.
    private static final String QUERY75 = "SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals FROM sakila.film" +
            " GROUP BY rental_duration ORDER BY rental_duration DESC ";

    // Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como
    // ‘películas’ de la tabla películas (film), cuya duración (length) sea más de 180 minutos, agrupadas por la
    // duración del alquiler y ordenadas por el mismo campo descendente.
    private static final String QUERY76 = "SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals FROM sakila.film" +
            " WHERE length > 180 GROUP BY rental_duration ORDER BY rental_duration DESC ";

    // Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como ‘películas’
    // de la tabla películas (film), media de duración (length) como ‘media’, agrupadas por la duración del alquiler
    // cuya duración sea más de 112 minutos y ordenadas por duración de alquiler.
    private static final String QUERY77 = "SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals, AVG(length) AS media " +
            "FROM sakila.film GROUP BY rental_duration HAVING AVG(length) > 112 ORDER BY rental_duration ";

    // Por favor obtenga la duración de alquiler (rental_duration) como ‘días_alquiler’, el nº de películas como
    // ‘películas’ de la tabla películas (film), media de duración (length) como ‘media’, agrupadas por la duración del
    // alquiler cuya duración sea más de 112 minutos y ordenadas por duración de alquiler.
    // Además cuyo duración de alquiler esté en 3 o 7.
    private static final String QUERY78 = "SELECT rental_duration AS dias_alquiler, COUNT(*) AS pelicuals, " +
            "AVG(length) AS media FROM sakila.film WHERE rental_duration IN (3,7) GROUP BY rental_duration " +
            "HAVING AVG(length) > 112 ORDER BY rental_duration ";

// ------------------------------------------------ FUNCIONES ----------------------------------------------------------

    // ------------------------------------------------ DISTINCT
    // Seleccione los distintos valores de fecha de actualización (last_updated) de la tabla películas (film).
    // NOTA: La instrucción que solo devuelve los distintos en SQL es con DISTINCT campos.
    private static final String QUERY79 = "SELECT DISTINCT last_update FROM sakila.film";
    private static final String QUERY80 = "SELECT DISTINCT rating FROM sakila.film";

    // Seleccione los distintos valores de fecha de actualización (last_updated) y de clasificación (rating)
    // de la tabla películas (film).
    // NOTA: La instrucción que solo devuelve los distintos en SQL es con DISTINCT campos.
    private static final String QUERY81 = "SELECT DISTINCT last_update, rating FROM sakila.film";

    // ----------------------------------------------- CONCAT
    // Por favor concatene las palabra ‘Hola’, el espacio en blanco y ‘Mundo’ y llame al resultado frase_típica.
    // NOTA: La concatenación de palabras en SQL se obtiene con la función CONCAT(palabras separadas por comas).
    private static final String QUERY82 = "SELECT CONCAT('Hola', ' ', 'Mundo') AS frase_tipica";

    // ----------------------------------------------- CURRENT_DATE
    // Por favor obtenga la fecha del sistema y que su valor se muestre como fecha.
    // NOTA: La fecha del sistema en SQL se obtiene en la función CURRENT_DATE.
    private static final String QUERY83 = "SELECT CURRENT_DATE AS fecha";

    // ----------------------------------------------- LOCALTIME
    // Por favor obtenga la fecha y hora del sistema y que su valor se muestre como fecha_hora.
    // NOTA: La fecha y hora del sistema en SQL se obtiene en la función LOCALTIME.
    private static final String QUERY84 = "SELECT LOCALTIME fecha_hora";

    // ----------------------------------------------- DATEDIFF
    // Por favor calcule la diferencia en días desde la fecha de actualización del registro (last_update) a día del sistema.
    // NOTA: La diferencia de fechas en SQL se obtiene en la función DATEDIFF(fechas separadas por comas).
    private static final String QUERY85 = "SELECT DATEDIFF(last_update, CURRENT_DATE) AS diferencia FROM sakila.film";
    private static final String QUERY86 = "SELECT DATEDIFF(CURRENT_DATE, last_update) AS diferencia FROM sakila.film";
    private static final String QUERY87 = "SELECT DISTINCT DATEDIFF(CURRENT_DATE, last_update) AS diferencia FROM sakila.film";

    // ----------------------------------------------- SUBSTR
    // Por favor seleccione los 4 primeros caracteres del campo título (title), de la tabla de películas (film) y
    // denominar al campo como ‘subcadena’.
    // NOTA: La forma de obtener una subcadena desde otra en SQL se obtiene en SUBSTR(cadena, inicio, caracteres).
    private static final String QUERY88 = "SELECT SUBSTR(title,1,4) AS subcadena FROM sakila.film";
    private static final String QUERY91 = "SELECT SUBSTR(title,1,4) AS subcadena, title FROM sakila.film";
    private static final String QUERY92 = "SELECT DISTINCT SUBSTR(title,1,4) AS subcadena, title FROM sakila.film";
    private static final String QUERY93 = "SELECT DISTINCT SUBSTR(title,1,2) AS subcadena, title FROM sakila.film";
    private static final String QUERY94 = "SELECT DISTINCT SUBSTR(title,1,2) AS subcadena FROM sakila.film";

    // ----------------------------------------------- LENGTH
    // Por favor seleccione el tamaño, en caracteres, de los títulos (title) y el propio título de la películas (film) y
    // al tamaño llamarlo “tamano”, y ordenarlo por el tamaño.
    // NOTA: La forma de obtener el tamaño de una cadena en SQL se obtiene en LENGTH(cadena).
    private static final String QUERY89 = "SELECT title, LENGTH(title) AS tamano FROM sakila.film ORDER BY LENGTH(title)";
    private static final String QUERY95 = "SELECT DISTINCT LENGTH(title) AS tamano FROM sakila.film ORDER BY LENGTH(title)";

    // ----------------------------------------------- REPLACE
    // Por favor reemplace en los títulos (title), la letra “A” por “XYZ” de la películas (film) y ordenarlo por el título.
    // NOTA: La forma de reemplazar cadenas o caracteres de una cadena en SQL es con REPLACE(cadena,cadena_reemplazar, reemplazo).
    private static final String QUERY90 = "SELECT title, REPLACE(title,'A','XYZ') AS título_reemplazado FROM sakila.film ORDER BY title";

    // ----------------------------------------------- ROUND
    // Funccia ROUND zakryhliaet chisla
    // Por favor redondee el número decimal 2,236 (2 entero y 236 decimal).
    // NOTA: La forma de truncar y redondear nº son ROUND(numero,decimales redondeo).
    private static final String QUERY96 = "SELECT ROUND(2.236,2)";
    private static final String QUERY98 = "SELECT ROUND(2.236,2), TRUNCATE(2.236,2)";

    // ----------------------------------------------- TRUNCATE
    // Funccia TRUNCATE obrezaet chilo
    // Por favor trunque a 2 decimales.
    // NOTA: La forma de truncar TRUNCATE(numero,decimales truncado).
    private static final String QUERY97 = "SELECT TRUNCATE(2.236,2)";

    // ----------------------------------------------- IFNULL
    // Por favor reemplace los nulos en lenguaje original de películas (original_lenguaje_id) por “Vacio” en la tabla
    // películas (film). Obteniendo también el valor original y el título (title).
    // NOTA: La forma de subsituir nulo en SQL es IFNULL(campo, valor de sustitución).
    private static final String QUERY99 = "SELECT title, IFNULL(original_language_id, 'Vacio'), original_language_id FROM sakila.film";

    // ----------------------------------------------------- JOIN ----------------------------------------------------------
    // Por favor consulte obtenga todos los campos de las tablas enlazadas de actores (actor) y actores en películas (film_actor) .
    private static final String QUERY100 = "SELECT * FROM sakila.actor INNER JOIN sakila.film_actor " +
            "ON sakila.actor.actor_id = sakila.film_actor.actor_id";

    // Por favor consulte obtenga los campos (de las tablas enlazadas de actores (actor) y actores en películas (film_actor). Utilice ALIAS.
    private static final String QUERY101 = "SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id";

    // Por favor obtenga todos los campos nombre (first_name) de la tabla actores (actor) y el campo de última fecha de
    // actualización (last_updated) de actores y actores en películas (film_actor) . Utilice ALIAS.
    // NOTA: Dará error.
    private static final String QUERY102 = "SELECT sakila.actor.first_name, sakila.actor.last_update, sakila.film_actor.last_update " +
            "FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id";
    // NOTA: Asi no da ERROR
    private static final String QUERY103 = "SELECT a.first_name, a.last_update, fa.last_update FROM sakila.actor " +
            "AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id";

    // Por favor consulte los campos nombre (first_name) de la tabla actores (actor), el campos identificador de película
    // (film_id) de la tabla actores en películas (film_actor), y el campo de última fecha de actualización (last_updated)
    // de actores y actores en películas. Ordenado por el nombre descendente.
    // NOTA: Si hay dos campos con el mismo nombre se debe identificar la tabla.
    private static final String QUERY104 = "SELECT a.first_name, a.last_update, fa.film_id, fa.last_update  FROM sakila.actor " +
            "AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id ORDER BY a.first_name DESC";

    // Por favor consulte los campos nombre (first_name) de la tabla actores (actor), el campos identificador de película
    // (film_id) de la tabla actores en películas (film_actor), y el campo de última fecha de actualización (last_updated)
    // de actores y actores en películas. Ordenado por el nombre descendente.
    private static final String QUERY105 = "SELECT a.first_name, a.last_update, fa.film_id, fa.last_update  FROM sakila.actor " +
            "AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id ORDER BY a.first_name DESC";

    // Por favor consulte los campos nombre (first_name) de la tabla actores (actor), el campos identificador de película
    // (film_id) de la tabla actores en películas (film_actor), y el campo de última fecha de actualización (last_updated)
    // de actores y actores en películas. Ordenado por el nombre descendente y solo los que estén en las películas 2,3,500.
    private static final String QUERY106 = "SELECT a.first_name, fa.film_id, a.last_update, fa.last_update  FROM sakila.actor " +
            "AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id WHERE (fa.film_id IN(2, 3, 500)) " +
            "ORDER BY a.first_name DESC";

    // Por favor cuente el número de películas diferentes que ha realizado cada actor (film_actor). Ordenado por el nombre
    // descendente, solo los que estén en las películas 2,3,500, y tod.o ello agrupado por nombre del actor (first_name).
    private static final String QUERY107 = "SELECT a.first_name, fa.film_id, a.last_update, fa.last_update  FROM sakila.actor " +
            "AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id WHERE (fa.film_id IN(2, 3, 500)) " +
            "ORDER BY a.first_name DESC";

    // Por favor cuente el número de películas diferentes que ha realizado cada actor (film_actor). Ordenado por el nombre
    // descendente, solo los que estén en las películas 2,3,500, y tod.o ello agrupado por nombre del actor (first_name).
    private static final String QUERY108 = "SELECT a.first_name, COUNT(film_id) AS peliculas_por_actor " +
            "FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "WHERE (fa.film_id IN (2,3,500)) GROUP BY first_name ORDER BY first_name DESC";

    // Por favor muestre el nombre (first_name) concatenado con el apellido (last_name) como nombre completo, solo los
    // actores (actor) que han realizado tres o más películas (film_actor). Ordenado por el nº de peliculas descendente.
    // Esta dando error esta SQL
    private static final String QUERY109 = "SELECT CONCAT(a.first_name, ' ', a.last_name) AS nombre_completo, " +
            "COUNT(film_id) AS peliculas_por_actor " +
            "FROM sakila.actor AS a " +
            "INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "GROUP BY first_name HAVING (COUNT(film_id) > 2) " +
            "ORDER BY COUNT(film_id) DESC";

    // Por favor muestre el nombre (first_name) concatenado con el apellido (last_name) como nombre completo, solo los
    // actores (actor) que han realizado tres o más películas (film_actor). Ordenado por el nº de peliculas descendente
    // y cuya longitud del nombre completo esté entre 10 y 15 caracteres.
    // Esta dando error esta SQL
    private static final String QUERY110 = "SELECT CONCAT(a.first_name, ' ',a.last_name) AS nombre_completo, COUNT(film_id) " +
            "AS peliculas_por_actor FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "WHERE (LENGTH(CONCAT(a.first_name, ' ',a.last_name) BETWEEN (10,15)) GROUP BY first_name HAVING (COUNT(film_id) > 2) " +
            "ORDER BY COUNT(film_id) DESC";

    // Por favor muestre todos los campos de la relación de las tablas películas (film), actores por película
    // (film_actor) y actores (actor).
    private static final String QUERY111 = "SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa " +
            "ON a.actor_id = fa.actor_id INNER JOIN film AS fArgInt ON fArgInt.film_id = fa.film_id";

    // Por favor muestre todos los campos de la relación de las tablas películas (film), actores por película (film_actor)
    // y actores (actor), cuyo nombre de actor (first_name) o bien el título (title) comience por la letra M. Ordenado por
    // nombre del actor ascendente y título descendente.
    private static final String QUERY112 = "SELECT * FROM sakila.actor AS a INNER JOIN sakila.film_actor AS fa " +
            "ON a.actor_id = fa.actor_id INNER JOIN sakila.film AS fArgInt ON fArgInt.film_id = fa.film_id " +
            "WHERE (fArgInt.title LIKE 'M%') OR (a.first_name LIKE 'M%')ORDER BY a.first_name ASC, title DESC";

    // Por favor muestre todas los títulos (title) de las películas (film) que tengan 3 o más actores (actor) en su reparto,
    // ordenado por el título descendente.
    private static final String QUERY113 = "SELECT fArgInt.title, COUNT(a.actor_id) AS actores FROM sakila.actor AS a " +
            "INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "INNER JOIN sakila.film AS fArgInt ON fArgInt.film_id = fa.film_id " +
            "GROUP BY fArgInt.title HAVING COUNT(a.actor_id) > 2 " +
            "ORDER BY fArgInt.title DESC";

    // Por favor muestre toda la información de todas las tablas del gráfico anterior
    private static final String QUERY114 = "SELECT * FROM sakila.actor AS a " +
            "INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "INNER JOIN sakila.film AS fArgInt ON fArgInt.film_id = fa.film_id " +
            "INNER JOIN sakila.film_category AS fc ON fArgInt.film_id = fc.film_id " +
            "INNER JOIN sakila.category AS c ON c.category_id = fc.category_id";

// --------------------------------------------------- VIEWS -----------------------------------------------------------
    // Las vistas (“views”) en SQL son un mecanismo que permite generar un resultado a partir de una consulta (query)
    // previamente ejecutada y almacenada, de manera que permite ejecutar nuevas consultas sobre este resultado como
    // si fuera una tabla normal.

    // Por favor muestre toda la información de todas las tablas del gráfico anterior.
    // NOTA: Crearemos una vista para tener toda la consulta a modo de tabla. Usar CREATE OR REPLACE VIEW nombre de la
    // vista AS. Dará error
    private static final String QUERY115 = "CREATE OR REPLACE VIEW sakila.V_PELICULAS_ACTORES_CATEGORIAS AS " +
            "SELECT * FROM sakila.actor AS a " +
            "INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "INNER JOIN sakila.film AS fArgInt ON fArgInt.film_id = fa.film_id " +
            "INNER JOIN sakila.film_category AS fc ON fArgInt.film_id = fc.film_id " +
            "INNER JOIN sakila.category AS c ON c.category_id = fc.category_id";

    // Por favor muestre todos los campos de la tabla películas (film), y luego los distintos campos de cada tabla de
    // actores (actor) y categorías (category), de la información de todas las tablas del gráfico anterior en modo vista.
    private static final String QUERY116 = "CREATE OR REPLACE VIEW sakila.V_PELICULAS_ACTORES_CATEGORIAS AS " +
            "SELECT f.*, a.actor_id, a.first_name, a.last_name, c.category_id, c.name AS category_name FROM sakila.actor AS a " +
            "INNER JOIN sakila.film_actor AS fa ON a.actor_id = fa.actor_id " +
            "INNER JOIN sakila.film AS f ON f.film_id = fa.film_id " +
            "INNER JOIN sakila.film_category AS fc ON f.film_id = fc.film_id " +
            "INNER JOIN sakila.category AS c ON c.category_id = fc.category_id";
    private static final String QUERY116A = "SELECT * FROM sakila.V_PELICULAS_ACTORES_CATEGORIAS";

    public static void main(String[] args) {
        try (Statement statement = ConnectionMySQL_Sakila.getConnection().createStatement()) {
            statement.execute("USE sakila");

            try (ResultSet resultSet = statement.executeQuery(QUERY116)) {
                while (resultSet.next()) {
//                System.out.println(resultSet.getBoolean(1));
                    System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(3));
//                System.out.println(resultSet.getString(4));
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getFloat(1));
                    System.out.println(resultSet.getInt(2));
//                System.out.println(resultSet.getInt(3));
//                System.out.println(resultSet.getInt(4));
//                System.out.println(resultSet.getDate(1) + "  " + resultSet.getTime(1));
//                System.out.println(resultSet.getDate(1));
//                System.out.println(resultSet.getTime(1));
//                System.out.println(resultSet.getString("title"));
//                System.out.println(resultSet.getString("description"));
//                System.out.println(resultSet.getDate("release_year"));
//                System.out.println(resultSet.getInt("language_id"));
//                System.out.println(resultSet.getInt("original_language_id"));
//                System.out.println(resultSet.getInt("rental_duration"));
//                System.out.println(resultSet.getFloat("rental_rate"));
//                System.out.println(resultSet.getInt("length"));
//                System.out.println(resultSet.getFloat("replacement_cost"));
//                System.out.println(resultSet.getString("rating"));
//                System.out.println(resultSet.getString("special_features"));
//                System.out.println(resultSet.getTimestamp("last_update"));

                    System.out.println("--------------------------------------");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
