/*==============================================================*/
/* Table: levels                                                */
/*==============================================================*/

INSERT OR REPLACE INTO levels VALUES (1,  "Операции ввода/вывода", 1, "Научимся выводить текст в консоль", false)
INSERT OR REPLACE INTO levels VALUES (2,  "Циклы", 1, "Делаем операции несколько раз", false)
INSERT OR REPLACE INTO levels VALUES (3,  "Ветвления и переключатели", 1, "Выбираем из нескольких вариантов", false)
INSERT OR REPLACE INTO levels VALUES (4,  "Типы данных", 1, "Изучим основные типы данных в С++", false)
INSERT OR REPLACE INTO levels VALUES (5,  "Массивы", 1, "Создаем первые массивы и учимся с ними работать", false)
INSERT OR REPLACE INTO levels VALUES (6,  "Указатели", 1, "Работаем с адресами", false)
INSERT OR REPLACE INTO levels VALUES (7,  "Классы и структуры", 1, "Начинаем изучать ООП", false)
INSERT OR REPLACE INTO levels VALUES (8,  "Наследование", 1, "Изучим основные типы данных в С++", false)
INSERT OR REPLACE INTO levels VALUES (9,  "Полиморфизм", 1, "Изучим основные типы данных в С++", false)
INSERT OR REPLACE INTO levels VALUES (10, "Шаблоны", 1, "Изучим основные типы данных в С++", false)


/*==============================================================*/
/* Table: parts_level                                           */
/* Table 1:theory                                               */
/* Table 2:tests                                                */
/* Table 3:fill_gaps                                            */
/*==============================================================*/

INSERT OR REPLACE INTO parts_level VALUES (1, 1, 1, false, 1)
INSERT OR REPLACE INTO parts_level VALUES (2, 2, 1, false, 1)
INSERT OR REPLACE INTO parts_level VALUES (3, 1, 1, false, 2)
INSERT OR REPLACE INTO parts_level VALUES (4, 1, 1, false, 3)
INSERT OR REPLACE INTO parts_level VALUES (5, 3, 2, false, 1)

/*==============================================================*/
/* Table: theory                                                */
/*==============================================================*/

INSERT OR REPLACE INTO theory VALUES (1, "text", 1, 1, 1)
INSERT OR REPLACE INTO theory VALUES (2, "text", 2, 1, 1)
INSERT OR REPLACE INTO theory VALUES (3, "text", 1, 1, 1)
INSERT OR REPLACE INTO theory VALUES (4, "text", 2, 1, 1)

/*==============================================================*/
/* Table: tests                                                 */
/*==============================================================*/

INSERT OR REPLACE INTO tests VALUES ()

/*==============================================================*/
/* Table: fill_gaps                                             */
/*==============================================================*/

INSERT OR REPLACE INTO fill_gaps VALUES ()