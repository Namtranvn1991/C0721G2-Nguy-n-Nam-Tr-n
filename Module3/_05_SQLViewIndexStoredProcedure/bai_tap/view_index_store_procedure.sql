drop database if exists Products;

create database Products;

use Products;

create table products (
id int primary key auto_increment,
product_code varchar(10),
product_name varchar(20),
product_price int,
product_amount int,
product_description text,
product_status bit
);

insert into products(product_code,product_name,product_price,product_amount,product_status)
value ("IP10","iphone 10", 1000, 10, 1),
	  ("IP11","iphone 11", 1555, 4, 0),
	  ("SS10","samsung 10", 1000, 12, 1),
	  ("SS9","samsung 9", 999, 15, 1),
	  ("HW12","huawei 12", 888, 3, 0);
      
-- Index 
      
create unique index index_product_code on products(product_code);
create unique index index_name_price on products(product_name,product_price);

select *
from products
where product_code like "IP%";

select *
from products
where product_name like "IP%" and product_price >1000;

-- View
create view view_products as
select product_code,product_name,product_price,product_status
from products;

select *
from view_products;

update view_products
set product_status = 0
where product_code like "IP%";

delete from products
where product_status = 0;

-- store procedure
DELIMITER //

CREATE PROCEDURE findAllProducts()

BEGIN

  SELECT * FROM products;

END //

DELIMITER ;

DROP PROCEDURE IF EXISTS insertProduct;

DELIMITER //

CREATE PROCEDURE insertProduct(`code` varchar(10), `name`varchar(20), price int)

BEGIN

 insert into products (product_code,product_name,product_price)
 value (`code`,`name`,price);

END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE editProduct(idEdit int, price int)

BEGIN

update products
set product_price = price
where id = idEdit;

END //


DELIMITER ;


DELIMITER //

CREATE PROCEDURE removeProduct(idRemove int)

BEGIN

delete from products
where id = idRemove;

END //

DELIMITER ;

call findAllProducts();
call removeProduct(2);
call insertProduct("IP5", "Iphone 5", 555);
call editProduct(1, 1222);
