CREATE TABLE IF NOT EXISTS `users` (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(MAX),
    surname varchar(MAX),
    userPk varchar(MAX),
    email varchar(MAX),
    address varchar(MAX),
    status int

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
