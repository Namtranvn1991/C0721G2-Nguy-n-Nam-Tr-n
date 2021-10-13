drop database if exists sale_management;

create database sale_management;

use sale_management;

create table customer(
cID int primary key,
cName varchar(30) not null,
cAge int default 18 check (cAge>=18)
);

create table product(
pID int primary key,
pName varchar(30) not null,
pPrice double not null
);

create table oder(
oID int primary key,
cID int not null,
oDate date not null,
oTotalPrice double not null,
foreign key (cID) references customer(cID)
);


create table oder_detail(
oID int,
pID int,
odQTY varchar(50),
primary key (oID,pID),
foreign key (oID) references oder(oID),
foreign key (pID) references product(pID)
);

