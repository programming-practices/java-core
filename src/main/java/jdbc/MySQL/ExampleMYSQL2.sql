USE test;
-- ==================================== CREATE TABLE t2 LIKE t
-- CREATE TABLE t (id INT PRIMARY KEY, name VARCHAR(16), age INT);
-- SET OPERATIONS 
-- INSERT INTO t(id, name, age) VALUES(1, 'aaa', 10);
-- INSERT INTO t(id, name, age) VALUES(2, 'bbb', 20);
-- INSERT INTO t(id, name, age) VALUES(3, 'ccc', 30);

-- SELECT * FROM (SELECT * FROM (SELECT * FROM t) AS x) AS x;
-- ==================================== UNION
-- SELECT id FROM t WHERE age = 10 UNION SELECT id FROM t WHERE age = 30;
-- SELECT id FROM t WHERE age = 10 OR age = 30;
-- SELECT id FROM t WHERE age IN (10, 30);
-- SELECT id FROM t WHERE age IN (10, 20);
-- SELECT id FROM t WHERE age IN (20, 30);

-- SELECT id FROM t WHERE age IN (10, 20)
-- UNION
-- SELECT id FROM t WHERE age IN (20, 30);

-- SELECT id FROM t WHERE age IN (10, 20)
-- UNION ALL
-- SELECT id FROM t WHERE age IN (20, 30);

-- SELECT id FROM t WHERE age BETWEEN 5 AND 25
-- UNION ALL
-- SELECT id FROM t WHERE age BETWEEN 15 AND 35;

-- ===================================== INTERSECT: No in MySQL
-- SELECT id FROM
-- ((SELECT * FROM t WHERE age IN(10, 15, 20)) AS x
-- INNER JOIN
-- ((SELECT * FROM t WHERE age IN(20, 25, 30)) AS y)
-- USING (id));

-- SELECT id FROM t WHERE
-- age IN(10, 15, 20)
-- AND
-- id IN(SELECT id FROM t WHERE age IN(20, 25, 30));

-- ====================================== EXCEPT / MINUS: No in MySQL
-- SELECT id FROM t WHERE age IN(10, 15, 20) 
-- AND id NOT IN
-- (SELECT id FROM t WHERE age IN(20, 25, 30);

-- SELECT id FROM
-- ((SELECT id, age FROM t WHERE age IN(10, 15, 20)) AS x
-- LEFT JOIN
-- ((SELECT id, age FROM t WHERE age IN(20, 25, 30)) AS y)
-- USING (id, age)) 
-- WHERE y.age IS NULL;
-- ====================================== CARTESIAN PRODUCT
SELECT x.id, y.age FROM t AS x, t AS y; 

SELECT * FROM t AS x, t AS y;

SELECT * FROM
t AS x
CROSS JOIN
t AS y;

-- ====================================== PROJECTION
SELECT id, age FROM t;
SELECT id AS t_id, age AS user_age FROM t; 

-- ====================================== RESTRICTION / SELECTION
SELECT id, age FROM t WHERE name LIKE 'b%b';

SELECT id, age FROM t WHERE age + id > 15;






