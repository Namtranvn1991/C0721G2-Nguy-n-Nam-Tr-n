USE student_management;

SELECT *
FROM Student
where StudentName like 'h%';

select *
from class
where month(StartDate) =12 ;

select *
from `subject`;

select *
from `subject`
where Credit>=3 and Credit<=5;

SET SQL_SAFE_UPDATES = 0;
update Student
set ClassID = 2
where StudentName like 'Hung';

select S.StudentName, M.mark, Sub.SubName
from student S 
left join mark M on M.StudentID = S.StudentID
join `subject` Sub on Sub.SubID = M.SubID
order by M.mark desc, S.StudentName;


