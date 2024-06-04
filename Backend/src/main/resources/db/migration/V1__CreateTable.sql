CREATE TABLE Users
(
    id int NOT NULL AUTO_INCREMENT,
    username varchar(50),
    password varchar(50),
    bio varchar(150),
    primary key (id),
    UNIQUE (username)
);