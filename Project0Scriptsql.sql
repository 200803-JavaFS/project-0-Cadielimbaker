--CREATE DATABASE project0;

CREATE TABLE Users (
	Id SERIAL PRIMARY KEY,
	firstName VARCHAR(20),
	lastName VARCHAR(40),
	userName VARCHAR(30),
	phoneNumber NUMERIC(10,2),
	password VARCHAR(12),
	userType INTEGER
);

SELECT * FROM Users;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Account;

CREATE TABLE Account(
	accountId SERIAL PRIMARY KEY,
	accountType VARCHAR(20),
	Id_fk INTEGER REFERENCES Users(Id),
	accountStatus VARCHAR(20),
	balance NUMERIC(10,2)
	);
	
INSERT INTO Users(firstName, lastName, userName, phoneNumber, password, userType)
	VALUES('Cadie', 'Limbaker','cadielimbaker', 1233244, 'password', 2),
		('Melissa', 'Adams', 'melissaadams', 5321234, 'password', 1),
		('Samuel', 'Travis', 'samueltravis', 6433521, 'password', 0)
	
SELECT * FROM Users;

INSERT INTO Account (accountType, Id_fk, accountStatus, balance)
	VALUES('Checking', 1, 'Pending', 100.00);
	
---ALTER TABLE Account ADD COLUMN update_at TIMESTAMP;

--Function
	CREATE OR REPLACE FUNCTION trigger_set_time() RETURNS TRIGGER 
		AS $$
		BEGIN 
				NEW.update_at = NOW();
				RETURN NEW;
		END;
		$$ LANGUAGE plpgsql;

	CREATE TRIGGER set_time BEFORE UPDATE ON Account FOR EACH ROW 
		EXECUTE PROCEDURE trigger_set_time();

--Testing my trigger function
	UPDATE Account SET balance = 1,000.50 WHERE accountId = 6;	

