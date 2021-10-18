use case_study;

-- task 2 cach 1
select *, length(ten_nhan_vien)
from nhan_vien
where (ten_nhan_vien like 'H%' or ten_nhan_vien like 'T%' or ten_nhan_vien like 'K%') and length(ten_nhan_vien) <=15;
-- task 2 cach 2
select *
from nhan_vien
where REGEXP_LIKE(ten_nhan_vien,'[HKT][a-z]+\\s([A-Z][a-z]*\\s)*[A-Z][a-z]*') and length(ten_nhan_vien) <=15;

-- task 3 
select *, TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) as age 
from nhan_vien
where dia_chi in ("DaNang","QuangTri") and (TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) between 18 and 50);

-- task 4
select khach_hang.id_khach_hang ,khach_hang.ten_khach_hang , khach_hang.id_loai_khach , count(hop_dong.id_khach_hang) as soLanDatPhong
from khach_hang
join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
-- where khach_hang.id_loai_khach = 1
group by hop_dong.id_khach_hang
having khach_hang.id_loai_khach = 1
order by count(hop_dong.id_khach_hang);

-- task 5
select khach_hang.id_khach_hang, khach_hang.ten_khach_hang, loai_khach.ten_loai_khach, hop_dong.id_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
		(dich_vu.chi_phi_thue + sum(dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong))as tong_tien
from hop_dong
right join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong, khach_hang.id_khach_hang;

-- task 6
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
from dich_vu
join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (year(hop_dong.ngay_lam_hop_dong ) = 2019) and (month(hop_dong.ngay_lam_hop_dong ) between 1 and 3);

-- task 7 cach 1
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
from dich_vu
join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (year(hop_dong.ngay_lam_hop_dong ) = 2018 ) 
	   and not exists (
			select dich_vu.id_dich_vu
			from hop_dong
			where hop_dong.id_dich_vu = dich_vu.id_dich_vu and (year(hop_dong.ngay_lam_hop_dong ) = 2019)
        ) ;
        
-- task 7 cach 2     
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
from dich_vu
join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (year(hop_dong.ngay_lam_hop_dong ) = 2018 ) 
	   and dich_vu.id_dich_vu not in (
			select dich_vu.id_dich_vu
			from dich_vu
            join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
			where (year(hop_dong.ngay_lam_hop_dong ) = 2019)
        ) ; 
        
-- task 8 cach 1         
Select distinct ten_khach_hang
From khach_hang;

-- task 8 cach 2   
Select ten_khach_hang
From khach_hang
group by ten_khach_hang;

-- task 9
-- cach 1 
drop table if exists tempT; 
create temporary table tempT (
select hop_dong.id_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, 
		(dich_vu.chi_phi_thue + sum(dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong)) as tong_tien
from hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong
having year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) = 2);

select sum(tong_tien) as TongDoanhThu
from tempT;  

-- cach 2 
select sum(tong_tien)
from (select hop_dong.id_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, 
		(dich_vu.chi_phi_thue + sum(dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong)) as tong_tien
from hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong
having year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) = 2) as A;

select hop_dong.id_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, 
		(dich_vu.chi_phi_thue + sum(dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong)) as tong_tien
from hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong
having year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) = 2;


select count(hop_dong.id_hop_dong) as Tongkhach_hang
from hop_dong
join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
where year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) = 2;

-- task 10
select hop_dong.id_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.tien_dat_coc,
		count(hop_dong.id_hop_dong) as Sodich_vu_di_kem
from hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong;

-- task 11 
select dich_vu_di_kem.ten_dich_vu_di_kem, hop_dong.id_hop_dong,khach_hang.ten_khach_hang, khach_hang.id_loai_khach, khach_hang.dia_chi
from hop_dong
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
where khach_hang.id_loai_khach = 1 and khach_hang.dia_chi = 'Vinh';

-- task 12 
select hop_dong.id_hop_dong, nhan_vien.ten_nhan_vien, khach_hang.ten_khach_hang, khach_hang.sdt, dich_vu.ten_dich_vu, hop_dong.tien_dat_coc
		, hop_dong.ngay_lam_hop_dong, dich_vu_di_kem.ten_dich_vu_di_kem , count(dich_vu_di_kem.id_dich_vu_di_kem) as Sodich_vu_di_kem
from dich_vu
join hop_dong on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) between 10 and 12 
and not exists (
select hop_dong.ngay_lam_hop_dong
from hop_dong
where (hop_dong.id_dich_vu = dich_vu.id_dich_vu) and (year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) between 1 and 6)
)
group by hop_dong.id_hop_dong;

-- task 13
select dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, count(dich_vu_di_kem.id_dich_vu_di_kem)
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by dich_vu_di_kem.id_dich_vu_di_kem
having count(dich_vu_di_kem.id_dich_vu_di_kem) =  
(select count(dich_vu_di_kem.id_dich_vu_di_kem) as maxCount
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by dich_vu_di_kem.id_dich_vu_di_kem
limit 1);

-- task 14
select dich_vu_di_kem.ten_dich_vu_di_kem, hop_dong.id_hop_dong, dich_vu.ten_dich_vu, count(dich_vu_di_kem.id_dich_vu_di_kem)
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
group by dich_vu_di_kem.id_dich_vu_di_kem
having count(dich_vu_di_kem.id_dich_vu_di_kem) = 1;

-- task 15
select nhan_vien.id_nhan_vien, nhan_vien.ten_nhan_vien ,nhan_vien.id_trinh_do, nhan_vien.dia_chi, nhan_vien.sdt
, hop_dong.id_hop_dong, bo_phan.ten_bo_phan, count(nhan_vien.id_nhan_vien)
from nhan_vien
join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
where (year(hop_dong.ngay_lam_hop_dong) between 2018 and 2019)
group by nhan_vien.id_nhan_vien
having count(nhan_vien.id_nhan_vien)<=3;

-- task 16
delete from nhan_vien
where not exists (
select nhan_vien.id_nhan_vien
from hop_dong 
where hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien and year(hop_dong.ngay_lam_hop_dong) between 2017 and 2019
);

-- task 17
SET SQL_SAFE_UPDATES = 0;
update khach_hang
set khach_hang.id_loai_khach = 1
where khach_hang.id_khach_hang in (
select *
from (select khach_hang.id_khach_hang
from khach_hang
join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
where year(hop_dong.ngay_lam_hop_dong) = 2019 and khach_hang.id_loai_khach = 2
group by khach_hang.id_khach_hang
having sum(tong_tien) > 100)
tdlTmp
);

-- task 18
delete from khach_hang
where not exists (
select khach_hang.id_khach_hang
from hop_dong
where hop_dong.id_khach_hang = khach_hang.id_khach_hang and year(hop_dong.ngay_lam_hop_dong) > 2016
);

-- task 19
update dich_vu_di_kem
set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
where dich_vu_di_kem.id_dich_vu_di_kem in (
select *
from (select dich_vu_di_kem.id_dich_vu_di_kem
from hop_dong
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong
having count(hop_dong.id_hop_dong) > 10)
tdlTmp
);

-- task 20
select id_nhan_vien as id, ten_nhan_vien as ho_ten , sdt, ngay_sinh, email, dia_chi
from nhan_vien
union
select id_khach_hang as id, ten_khach_hang as ho_ten , sdt, ngay_sinh, email, dia_chi
from khach_hang;










