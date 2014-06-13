CREATE DATABASE AutoAncillariesLimitedDB
GO
USE AutoAncillariesLimitedDB
GO
CREATE TABLE Customer(
	[ID] int,
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