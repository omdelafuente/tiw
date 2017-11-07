CREATE TABLE USR
(
name  VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
email VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
PRIMARY KEY (email)
);

CREATE TABLE EVENT
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
category VARCHAR(10) NOT NULL,
image LONGBLOB NOT NULL,
price DECIMAL(6,2) NOT NULL,
eventDate TIMESTAMP NULL,
place VARCHAR(50) NOT NULL,
description TEXT NOT NULL,
availableTickets INT NOT NULL,
state VARCHAR(10) NOT NULL,
creator VARCHAR(30),
FOREIGN KEY (creator) REFERENCES USR(email)
);

CREATE TABLE PURCHASE
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
event INT NOT NULL,
client VARCHAR(30) NOT NULL,
tickets INT NOT NULL,
FOREIGN KEY (event) REFERENCES EVENT(id),
FOREIGN KEY (client) REFERENCES USR(email)
);
