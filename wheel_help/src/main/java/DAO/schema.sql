/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  shika823
 * Created: 23 Apr 2021
 */


CREATE TABLE IF NOT EXISTS Customer (
	 Customer_ID INTEGER auto_increment,
    Username VARCHAR(30),
    Password VARCHAR(30),
    EmailAddress VARCHAR(60),
    First_Name VARCHAR(30),
    Last_Name VARCHAR(50),
    Phone INTEGER,
	CONSTRAINT customer_pk PRIMARY KEY (Customer_ID)
);
 

CREATE TABLE Owner (
    Owner_ID INTEGER auto_increment,
    Username VARCHAR(30),
    Password VARCHAR(30),
	 Email VARCHAR(30),
  CONSTRAINT owner_pk PRIMARY KEY (Owner_ID)
   
);
 
CREATE TABLE Car (
    Car_ID INTEGER auto_increment,
    Car_NAME VARCHAR(50),
    Car_Type VARCHAR(40),
    Seat_Number INTEGER,
    Hourly_Charge DECIMAL(7,2),
    Location VARCHAR(70),
	 owner_Id integer,
    CONSTRAINT car_pk PRIMARY KEY (Car_ID),
	 CONSTRAINT car_ownerid_fk FOREIGN KEY (owner_id) REFERENCES Owner (Owner_id)
);

 
CREATE TABLE Transaction (
    Transaction_ID INTEGER auto_increment,
	 Car_ID INTEGER,
	 Customer_ID INTEGER,
    Transaction_Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 Transaction_Total DECIMAL(7,2),
	 CONSTRAINT transaction_pk PRIMARY KEY (Transaction_ID),
	 CONSTRAINT transaction_carid_fk FOREIGN KEY (Car_ID) REFERENCES Car (Car_ID),
	 CONSTRAINT transaction_customerid_fk FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID)
);

/*

INSERT INTO Customer (username, password, emailaddress, first_name, last_name, phone) 
VALUES ('SUV', 'gahajja', '77.77', 'place',  '77.77', '0212458890');
select * from customer

INSERT INTO Car (Car_ Name, Car_Type, SEAT_Number, hourly_charge, location) 
VALUES ('2006 Ford Ranger', 'SUV', '1', '77.77', 'place');
select * from car

INSERT INTO Owner (username, password, email) 
VALUES ('SUV', 'ssssaa', 'djshd');
select * from owner

INSERT INTO Transaction (transaction_total) 
VALUES ('44.44');
SELECT * FROM TRANSACTION

*/



