/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  shika823
 * Created: 23 Apr 2021
 */


CREATE TABLE Customer (
	 Customer_ID INTEGER auto_increment,
    Username VARCHAR(30),
    Password VARCHAR(30),
    EmailAddress VARCHAR(60),
    First_Name VARCHAR(30),
    Last_Name VARCHAR(50),
    Phone INTEGER,
	CONSTRAINT customer_pk PRIMARY KEY (Customer_ID)
);
 
CREATE TABLE Car (
    Car_ID INTEGER auto_increment,
    Car_Type VARCHAR(40),
    Seat_Number INTEGER,
    Hourly_Charge DECIMAL(7,2),
    Location VARCHAR(70),
    CONSTRAINT car_pk PRIMARY KEY (Car_ID)
);

CREATE TABLE Owner (
    Owner_ID INTEGER auto_increment,
    Username VARCHAR(30),
    Password VARCHAR(30),
	 Email VARCHAR(30),
    Car_ID INTEGER,
    CONSTRAINT owner_pk PRIMARY KEY (Owner_ID),
    CONSTRAINT owner_carid_fk FOREIGN KEY (Car_ID) REFERENCES Car(Car_ID)
);
 
 
CREATE TABLE Transaction (
    Transaction_ID INTEGER auto_increment,
	 Car_ID INTEGER,
	 Customer_ID INTEGER,
    Transaction_Date TIMESTAMP,
	 Transaction_Total DECIMAL(7,2),
	 CONSTRAINT transaction_pk PRIMARY KEY (Transaction_ID),
	 CONSTRAINT transaction_carid_fk FOREIGN KEY (Car_ID) REFERENCES Car (Car_ID),
	 CONSTRAINT transaction_customerid_fk FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID)
);


