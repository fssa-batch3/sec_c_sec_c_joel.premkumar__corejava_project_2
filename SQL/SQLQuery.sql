use joel_premkumar_corejava_project;


CREATE TABLE IF NOT EXISTS stock (
	id INT AUTO_INCREMENT PRIMARY KEY ,
    stockName VARCHAR(30) NOT NULL UNIQUE,
    isin VARCHAR(20) NOT NULL,
    descrip VARCHAR(500) NOT NULL,
    price DOUBLE NOT NULL,
	creation_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	expire_date_time TIMESTAMP
);

CREATE TABLE IF NOT EXISTS users (
	user_id INT AUTO_INCREMENT PRIMARY KEY ,
    user_name VARCHAR(30) NOT NULL,
    email VARCHAR(40) NOT NULL UNIQUE,
    phone_number BIGINT NOT NULL UNIQUE,
    password  VARCHAR(40)  NOT NULL
);


create table if not exists History(
id INT AUTO_INCREMENT PRIMARY KEY ,
user_id INT NOT NULL,
stock_name VARCHAR(30) NOT NULL,
quantity INT NOT NULL,
inr DOUBLE NOT NULL, 
usd DOUBLE NOT NULL,
purshased_date TIMESTAMP DEFAULT current_timestamp
);


SELECT * FROM users;


-- DESCRIBE stock;