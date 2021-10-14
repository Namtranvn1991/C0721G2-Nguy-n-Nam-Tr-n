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
ExamTimes TINYINT DEFAULT 1,
unique (SubID,StudentID),
foreign key (SubID) references `subject` (SubID),
foreign key (StudentID) references student (StudentID)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);       
