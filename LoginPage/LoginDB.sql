CREATE DATABASE Login;

Use Login;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE login_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password) 
VALUES ('vdhanokar25@gmail.com', '123456');

ALTER TABLE users
ADD COLUMN name VARCHAR(100) NOT NULL UNIQUE;

Insert into users (name , username, password) values ('vishal','v@gmail.com',2508);

select * from users;
