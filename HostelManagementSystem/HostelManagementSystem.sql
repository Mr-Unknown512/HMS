create database Hostels;
use Hostels;

create table Sign_up_Accounts
(
	Account_Typre varchar (35),
	Name varchar (35),
	Username varchar(25), 
	Password varchar(30)
);
select * from Sign_UP_Accounts;
drop table Sign_UP_Accounts;

create table Seller
(
	Name varchar(30), 
	CNIC varchar(20), 
	Address varchar(100), 
	Contact varchar(20)
);

select * from Seller;
drop table Seller;

create table Hostels_Information
(
	Hostel_Owner varchar(40),
	Hostel_Name varchar(50), 
	Location varchar(50), 
	Total_Rooms varchar(5), 
	Avaliable_Rooms varchar(5), 
	Booked_Rooms varchar(5)
);
select * from hostels_information;
drop table hostels_information;

create table Add_Rooms
(
	Hostel_Owner varchar (50),
    Hostel_Name varchar (50),
    Hostel_Address varchar (50),
    Total_Rooms varchar (10),
    Room_Number varchar (15),
    Availability varchar (50),
    Bed_Type varchar (25),
    Price varchar (30)
);

select * from Add_Rooms;
drop table Add_Rooms;

create table Room_Booking
(
	Customer_Name varchar(50),
	Customer_CNIC varchar(20), 
	Customer_Address varchar(75), 
	Customer_Contact varchar(20), 
	Customer_Profession varchar(50), 
	Hostel_Name varchar(50), 
	Hostel_Room_Number varchar(10)
);

select * from Room_Booking;
drop table Room_Booking;

create table Customers
(
	
);

create table Admin_Login
(
	Firstname varchar(30),
	Lastname varchar(30),
    EMail varchar(50)
);
select * from Admin_Login;
drop table admin_login;