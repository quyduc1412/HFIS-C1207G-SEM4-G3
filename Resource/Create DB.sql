CREATE DATABASE AutoAncillariesLimitedDB
GO
USE AutoAncillariesLimitedDB
GO
DROP TABLE Customer
CREATE TABLE Customer(
	[ID] int identity(0,1),
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
CREATE TABLE Images_Item(
	[ID] int identity(0,1),
	[ID_Item] int,
	[Image_Link] ntext,
	PRIMARY KEY ([ID]),
	CONSTRAINT fk_Images_Item FOREIGN KEY ([ID_Item])
	REFERENCES Item([ID])
)

GO
CREATE TABLE Item(
	[ID] int identity(0,1),
	[Name] ntext,
	[Description] ntext,
	[Type_ID] int,
	[Price] float,
	[Date_Created] datetime,
	PRIMARY KEY ([ID]),
	CONSTRAINT fk_Item FOREIGN KEY ([Type_ID])
	REFERENCES TypeItem([ID])
)
GO
CREATE TABLE PurchaseOrder(
	[ID] int identity(0,1),
	[Date_Order] datetime,
	[ID_Customer] int,
	[ID_Item] int,
	PRIMARY KEY ([ID])
)
INSERT INTO TypeItem VALUES('Type 1')
INSERT INTO TypeItem VALUES('Type 2')
SELECT *  FROM TypeItem
INSERT INTO Item VALUES('K0345','Lop xe',0,4545,GETDATE())
SELECT *  FROM Item