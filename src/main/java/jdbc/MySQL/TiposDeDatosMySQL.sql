-- ------------------------------------------------- int ---------------------------------------------------------------
-- ------------------------------------------------- Celue chisla
-- TINYINT SIGNED  -128  127
-- TINYINT UNSIGNED  0  255 (2^8 = 256)
-- Po ymolchaniy vse tipu idut znakovue
-- Esli chislo perxodit diaposon to server ego obrezet do maksimyma danoho diapazona

-- ------------------------------------------------- Chisla s plavaywchoi tochkoi
-- DECIMAL (6,2) eto oznachaet chto v etom pole mozet xranitsa 6 cifer pri etom 2 cisla budut posle
-- comu. Naprimer 9999.99. Eti dva chisla chto peredaytsa v skobkax nazivatsa: 6 nazivaetsa tochnost a 2 nazivaetsa
-- mawtabom. Mawtab ne mozet bit bolwe tochnosti

-- Float()
-- 3.4432E2  =  344.32   E2 = 10^2=100
-- Float(6,2)  = 9999.99

-- ------------------------------------------------ Data Time