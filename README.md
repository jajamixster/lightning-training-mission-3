# Relational Database with Spring Boot

This applicatio require mySQL running on localhost port 8080

to create database using terminal in macOS run

```
$ sudo mysql --password
```
then creat database name **db_webservice** and user **webservice** with password **password**
```
mysql> create database db_webservice;
mysql> create user 'webservice'@'localhost' identified by 'password';
mysql> grant all on db_webservice.* to 'webservice'@'localhost';
```
