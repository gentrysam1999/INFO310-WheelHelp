CREATE TABLE Owner (
    Owner_ID INTEGER,
    Username VARCHAR(30),
    Car_ID INTEGER,
    PRIMARY KEY (Owner_ID, Username),
    FOREIGN KEY (Username) REFERENCES Account (Username),
    FOREIGN KEY (Car_ID) REFERENCES Car (Car_ID)
);

CREATE TABLE Account (
    Username VARCHAR(30),
    Password VARCHAR(30),
    EmailAddress VARCHAR(60),
    First_Name VARCHAR(30),
    Last_Name VARCHAR(50),
    Phone INTEGER
);

CREATE TABLE Car (
    Car_ID INTEGER,
    Car_Type VARCHAR(40),
    Colour VARCHAR(20),
    Seat_Number INTEGER,
    Hourly_Charge DECIMAL(7,2),
    Location VARCHAR(70),
    PRIMARY KEY (Car_ID)
);

CREATE TABLE Transaction (
    Transaction_ID INTEGER,
    Transaction_Date DATE,
    total DECIMAL(7,2)
);