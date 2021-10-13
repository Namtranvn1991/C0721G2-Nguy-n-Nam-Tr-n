drop database if exists my_database1;
-- Xóa database  
CREATE database my_database1;
-- Tạo database
use my_database1;
-- Thực hành tạo bảng và bài tập quản lý sinh viên 
CREATE TABLE Student (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  age INT NULL,
  country VARCHAR(45) NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE class (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id));
  
  create table Teacher (
  id int Not null,
  name VARCHAR(45) NULL,
  age INT NULL,
  country VARCHAR(45) NULL,
  primary key(id));

  