// This is all about how we should create table for Bank data of the coustomers
-----------------------------------------------------------------------------------------
create database bankmanagementsystem;

use bankmanagementsystem;

create table signup(
formNO varchar(20),
Name  varchar(20),
fname varchar(20),
dob varchar(20),
gender varchar(20),
email varchar(30),
Mstatus varchar(20),
Adr varchar(40),
city varchar(25),
state varchar(25),
pin varchar(20));

select * from signup;

create table signup2(
formNO varchar(20),
religion  varchar(20),
category varchar(20),
income varchar(20),
education varchar(20),
occupation varchar(30),
pan varchar(20),
aadhar varchar(40),
seniorcitizen varchar(25),
existingaccount varchar(25)
);

select * from signup2;

create table signup3(
formNO varchar(20),
accountType  varchar(20),
cardnumber varchar(25),
pin varchar(10),
facility varchar(100)
);

select * from signup3;

create table login(
formNo varchar(20), 
cardNumber varchar(20), 
pin varchar(10));

select * from login;

create table bank(
pin varchar(10),
date varchar(50),
type varchar(20),
amount varchar(20)
);

select * from bank;

