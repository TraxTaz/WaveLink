CREATE TABLE Posts
(
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    date varchar(50),
    description varchar(1000),

    primary key (id),
    FOREIGN KEY (user_id) REFERENCES Users (id)
);

CREATE TABLE Comments
(
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    message varchar(500),
    date varchar(50),
    post_id int NOT NULL,

    primary key (id),
    FOREIGN KEY (user_id) REFERENCES Users (id),
    FOREIGN KEY (post_id) REFERENCES Posts (id)
);