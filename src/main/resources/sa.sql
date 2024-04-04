CREATE DATABASE SA;

CREATE TABLE CLIENT (
                        ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         EMAIL VARCHAR(50) UNIQUE
);

CREATE TABLE SENTIMENT (
                           ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           TEXTE VARCHAR(50),
                           TYPE VARCHAR(10),
                           CLIENT_ID INT, -- Ajout du type de données INT
                           CONSTRAINT client_fk FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(ID)
);
