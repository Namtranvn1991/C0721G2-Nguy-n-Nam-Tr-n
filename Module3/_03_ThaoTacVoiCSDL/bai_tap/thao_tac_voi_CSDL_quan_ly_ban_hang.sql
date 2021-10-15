drop database if exists sale_management;

create database sale_management;

use sale_management;

create table customer(
cID int primary key auto_increment,
cName varchar(25) not null,
cAge tinyint not null
);

create table product(
pID int primary key auto_increment,
pName varchar(25) not null,
pPrice int not null
);

create table oder(
oID int primary key auto_increment,
cID int not null,
oDate date not null,
oTotalPrice int,
foreign key (cID) references customer(cID)
);


create table oder_detail(
oID int,
pID int,
odQTY int not null,
primary key (oID,pID),
foreign key (oID) references oder(oID),
foreign key (pID) references product(pID)
);

insert into customer (cName,cAge)
value ('Minh Quan',	10),
	  ('Ngoc Oanh',	20),
	  ('Hong Ha',	50);    
      
insert into product (pName,pPrice)
value ('May Giat',	3),
	  ('Tu Lanh',	5),
	  ('Dieu Hoa',	7),   
	  ('Quat',	1),   
	  ('Bep Dien',	2);   
      
insert into oder (cID,oDate,oTotalPrice)
value (1,'2006-3-21',null),
	  (2,'2006-3-23',null),
	  (1,'2006-3-16',null);
      
insert into oder_detail
value (1,1,3),   
	  (1,3,7),   
	  (1,4,2),   
	  (2,1,1),   
	  (3,1,8),   
	  (2,5,4),   
	  (2,3,3);  
      
select *
from oder;

select customer.cName, product.pName
from oder_detail
join oder on oder_detail.oID = oder.oID
join product on oder_detail.pID = product.pID
join customer on oder.cID = customer.cID;

select customer.cName, count(oder.oID) as count
from oder
join customer on oder.cID = customer.cID
group by customer.cName;

select product.pName, count(oder_detail.oID) as count
from oder_detail
join product on oder_detail.pID = product.pID
group by oder_detail.pID;

select customer.cName as customerDidntBuyAnyThing
from customer
where not exists(
select customer.cName
from oder
where oder.cID = customer.cID);

select *
from oder_detail
join product on product.pID = oder_detail.pID
order by oID; 

select oder.oID, oder.oDate, sum(oder_detail.odQTY*product.pPrice) as oTotalPrice
from (
oder_detail 
join product on product.pID = oder_detail.pID
join oder on oder.oID = oder_detail.oID
)
group by oder.oID; 

select ucase(cName), length(cName), now()
from customer;


      
      
      
		


