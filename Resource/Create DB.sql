CREATE DATABASE AutoAncillariesLimitedDB
GO
USE AutoAncillariesLimitedDB
GO
DROP TABLE Customer
CREATE TABLE Customer(
	[ID] int identity(1,1),
	[Email] ntext,
	[FirstName] nvarchar(20),
	[LastName] nvarchar(20),
	[PassWord] nvarchar(33),
	[PhoneNumber] nvarchar(15),
	[Gender] bit,
	[Address] ntext,
	[City] nvarchar(20),
	[Country] nvarchar(15),
	CONSTRAINT pk_Customer PRIMARY KEY (id)
)
GO
CREATE TABLE TypeItem(
	[ID] int identity(1,1),
	[Name_Type] nvarchar(33),
	PRIMARY KEY ([ID]),
)
GO
CREATE TABLE Item(
	[ID] int identity(1,1),
	[Name] ntext,
	[Description] ntext,
	[Type_ID] int,
	[Price] float,
	[Date_Created] datetime,
	[Images] ntext,
	PRIMARY KEY ([ID]),
	CONSTRAINT fk_Item FOREIGN KEY ([Type_ID])
	REFERENCES TypeItem([ID])
)
GO
CREATE TABLE WareHouses(
	[ID] int identity(1,1),
	[Name] ntext,
	[Address] ntext,
	[Phone] ntext,
	[Email] ntext,
	PRIMARY KEY ([ID])
)
GO
CREATE TABLE Employee(
	[ID] int identity(1,1),
	[Email] ntext,
	[Password] ntext,
	[Name] ntext,
	[Address] ntext,
	[Phone] ntext,
	[WareHouses_ID] int,
	PRIMARY KEY ([ID]),
	CONSTRAINT fk_Employee FOREIGN KEY ([WareHouses_ID])
	REFERENCES WareHouses([ID])
)
GO
CREATE TABLE BatchOrder(
	[ID] int identity(1,1),
	[Date_Order] datetime,
	[ID_Customer] int,
	PRIMARY KEY ([ID])
)
GO
CREATE TABLE PurchaseOrder(
	[ID] int identity(1,1),
	[ID_Item] int,
	[ID_BatchOrder] int,
	PRIMARY KEY ([ID]),
	CONSTRAINT fk_PurchaseOrder_BatchOrder FOREIGN KEY ([ID_BatchOrder])
	REFERENCES BatchOrder([ID]),
	CONSTRAINT fk_PurchaseOrder_Item FOREIGN KEY ([ID_Item])
	REFERENCES Item([ID])
)
INSERT INTO TypeItem VALUES('Type 1')
INSERT INTO TypeItem VALUES('Type 2')
SELECT *  FROM TypeItem
INSERT INTO Item VALUES('K0345','Lop xe',0,4545,GETDATE())
SELECT *  FROM Item
SELECT * FROM WareHouses
INSERT INTO WareHouses VALUES('WareHouses 1','Mien Bac','0123456789','WareHouses1@gmail.com')