if not exists (select * from sys.databases where name = 'centro_odontologico_hibernate')
	create database centro_odontologico_hibernate;
go

use centro_odontologico_hibernate
go

if not exists(select * from sys.sql_logins where name = 'centro')
	create login centro with password = 'centro';
go

if not exists (select * from sys.sysusers where name = 'centro')
	create user centro for login centro;
go

ALTER ROLE db_datareader ADD MEMBER centro
GO
ALTER ROLE db_datawriter ADD MEMBER centro
GO

CREATE ROLE usuarioCentro AUTHORIZATION dbo;
EXEC sp_addrolemember 'usuarioCentro', 'centro';
go

GRANT ALTER, DELETE, EXECUTE, INSERT, REFERENCES, SELECT,
          UPDATE, VIEW DEFINITION ON SCHEMA::dbo TO centro;

GRANT CREATE TABLE, CREATE PROCEDURE, CREATE FUNCTION, CREATE VIEW TO centro;