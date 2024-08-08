USE Human_friends;

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
('домашние');  

INSERT INTO packed_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 

INSERT INTO home_animals (Genus_name, Class_id)
VALUES ('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 

INSERT INTO cats VALUES
 (1, 'Пупа', 'ж', '2011-01-01', 'кс-кс-кс', 1),
(2, 'Олег', 'м', '2016-01-01', "отставить!", 1),  
(3, 'Тьма', 'ж', '2017-01-01', "", 1); 

INSERT INTO dogs VALUES
 (1, 'Дик', 'м', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
(2, 'Граф', 'м', '2021-06-12', "сидеть, лежать, лапу", 2),  
(3, 'Шарик', 'м', '2018-05-01', "сидеть, лежать, лапу, след, фас", 2), 
(4, 'Босс', 'м', '2021-05-10', "сидеть, лежать, фу, место", 2);

INSERT INTO hamsters VALUES
 (1, 'Малой', 'м', '2020-10-12', '', 3),
(2, 'Медведь', 'м', '2021-03-12', "атака сверху", 3),  
(3, 'Ниндзя', 'ж', '2022-07-11', NULL, 3), 
(4, 'Бурый', 'м', '2022-05-10', NULL, 3);

INSERT INTO horses VALUES
 (1, 'Гром', 'м', '2020-01-12', 'бегом, шагом', 1),
(2, 'Закат', 'ж', '2017-03-12', "бегом, шагом, хоп", 1),  
(3, 'Байкал', 'м', '2016-07-12', "бегом, шагом, хоп, брр", 1), 
(4, 'Молния', 'ж', '2020-11-10', "бегом, шагом, хоп", 1);

INSERT INTO donkeys VALUES
(1, 'Первый', 'м', '2019-04-10', NULL, 2),
(2, 'Второй', 'м', '2020-03-12', "", 2),  
(3, 'Третий', 'м', '2021-07-12', "", 2), 
(4, 'Четвертый', 'м', '2022-12-10', NULL, 2);

INSERT INTO camels VALUES
(1, 'Горбатый', 'м', '2022-04-10', 'вернись', 3),
(2, 'Самец', 'м', '2019-03-12', "остановись", 3),  
(3, 'Сифон', 'м', '2015-07-12', "повернись", 3), 
(4, 'Борода', 'ж', '2022-12-10', "улыбнись", 3);

INSERT INTO gender Values
('м'),
('ж');