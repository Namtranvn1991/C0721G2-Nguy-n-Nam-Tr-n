drop database if exists student_management;

create database student_management;

use student_management;

create table class(
ClassID int primary key not null auto_increment,
ClassName varchar(60) not null,
StartDate datetime not null,
`Status` bit
);

create table student(
StudentID int primary key not null auto_increment,
StudentName varchar(30),
Address varchar(50),
Phone varchar(20),
`Status` bit,
ClassID int not null,
foreign key (ClassID) references class (ClassID)
);

create table `subject`(
SubID int primary key not null auto_increment,
SubName varchar(30) not null,
Credit tinyint not null default 1 check (Credit>=1),
`Status` bit default 1
);

create table mark(
MarkID int primary key not null auto_increment,
SubID int not null,
StudentID int not null,
Mark float default 0 check (Mark BETWEEN 0 AND 100),
unique (SubID,StudentID),
foreign key (SubID) references `subject` (SubID),
foreign key (StudentID) references student (StudentID)
);

insert into class
value (2,'C7','2021-10-12',1);

insert into class (ClassName,StartDate,`Status`)
value ('C7','2021-10-12',1),
('C7','2021-10-12',1),
('C4','2021-10-12',1);

delete from class
where ClassID=3;

insert into class (ClassName,StartDate,`Status`)
value ('C8','2021-10-12',1);

insert into class
value (3,'C33','2021-10-12',1);

select *
from class
where ClassName collate '7';
