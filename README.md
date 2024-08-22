# Итоговая контрольная работа #

Полный текст задания находится по [ссылке](/Итоговая%20контрольная%20работа.pdf):

## 1. Операционные системы и виртуализация (Linux) ##

### 1.1. Использование команды cat в Linux ###

![img](/img/lin1.jpg)

### 1.2. Работа с директориями в Linux ###

![img](/img/lin2.jpg)

### 1.3. Работа с MySQL в Linux. Установить MySQL на вашу вычислительную машину  ###

Скрины установки доступны [тут](/Linux/mysql.pdf).

### 1.4. Управление deb-пакетами ###

Пример использования команды dpkg показан в [файле](/Linux/dpkg.pdf).


## 2. Объектно-ориентированное программирование ##

Диаграмма классов представлена на рисунке:
![img](/img/Диаграмма%20классов.jpg)

Работа с MySQL записана в [файл ](/SQL/MySQL.pdf), также в папке [SQL](/SQL) можно увидеть скрипты SQL.

### Программа-реестр домашних животных ###

#### Анализ ####

В программе не предусмотрено удаление животного, видимо вынесено в отдельную утилиту, только для
руководства питомника (◕‿◕) .

#### Разработка ####

Так как нет доступа к базе данных из моей локальной сети, портировал таблицы в CSV файлы.
OpenCSV подключать не стал, структура таблиц известна - написал примитивный парсер - CSVmanager.

Изначально, написал код, который считывал данные из таблиц animal_classes, packed_animals, 
home_animals и создавал классы через Reflection API Class.forName() метод.
Код получился слишком раздутым, поэтому упростил, убрав обращения к вышеперечисленным таблицам.

Код представлен в папке 'program'.



