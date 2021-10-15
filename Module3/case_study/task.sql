use case_study;

-- task 2 cach 1
select *, length(TenNhanVien)
from nhanvien
where (TenNhanVien like 'H%' or TenNhanVien like 'T%' or TenNhanVien like 'K%') and length(TenNhanVien) <=15;
-- task 2 cach 2
select *
from nhanvien
where REGEXP_LIKE(TenNhanVien,'[HKT][a-z]+\\s([A-Z][a-z]*\\s)*[A-Z][a-z]*') and length(TenNhanVien) <=15;

-- task 3 
select *, TIMESTAMPDIFF(YEAR, NgaySinh, CURDATE()) as age 
from nhanvien
where DiaChi in ("DaNang","QuangTri") and (TIMESTAMPDIFF(YEAR, NgaySinh, CURDATE()) between 18 and 50);

-- task 4
select KhachHang.IDKhachHang ,KhachHang.TenKhachHang , KhachHang.IDLoaiKhach , count(HopDong.IDKhachHang) as soLanDatPhong
from KhachHang
join HopDong on HopDong.IDKhachHang = KhachHang.IDKhachHang
-- where KhachHang.IDLoaiKhach = 1
group by HopDong.IDKhachHang
having KhachHang.IDLoaiKhach = 1
order by count(HopDong.IDKhachHang);

-- task 5
select KhachHang.IDKhachHang, KhachHang.TenKhachHang, LoaiKhach.TenLoaiKhach, HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, HopDong.NgayKetThuc, 
		(DichVu.ChiPhiThue + sum(DichVuDiKem.Gia*HopDongChiTiet.SoLuong))as TongTien
from HopDong
right join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
left join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong, KhachHang.IDKhachHang;

-- task 6
select DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich, DichVu.ChiPhiThue, LoaiDichVu.TenLoaiDichVu, HopDong.NgayLamHopDong
from DichVu
join LoaiDichVu on LoaiDichVu.IDLoaiDichVu = DichVu.IDLoaiDichVu
join HopDong on HopDong.IDDichVu = DichVu.IDDichVu
where (year(HopDong.NgayLamHopDong ) = 2019) and (month(HopDong.NgayLamHopDong ) between 1 and 3);

-- task 7 cach 1
select DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich, DichVu.SoNguoiToiDa, DichVu.ChiPhiThue, LoaiDichVu.TenLoaiDichVu, HopDong.NgayLamHopDong
from DichVu
join LoaiDichVu on LoaiDichVu.IDLoaiDichVu = DichVu.IDLoaiDichVu
join HopDong on HopDong.IDDichVu = DichVu.IDDichVu
where (year(HopDong.NgayLamHopDong ) = 2018 ) 
	   and not exists (
			select DichVu.IDDichVu
			from HopDong
			where HopDong.IDDichVu = DichVu.IDDichVu and (year(HopDong.NgayLamHopDong ) = 2019)
        ) ;
        
-- task 7 cach 2     
select DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich, DichVu.SoNguoiToiDa, DichVu.ChiPhiThue, LoaiDichVu.TenLoaiDichVu, HopDong.NgayLamHopDong
from DichVu
join LoaiDichVu on LoaiDichVu.IDLoaiDichVu = DichVu.IDLoaiDichVu
join HopDong on HopDong.IDDichVu = DichVu.IDDichVu
where (year(HopDong.NgayLamHopDong ) = 2018 ) 
	   and DichVu.IDDichVu not in (
			select DichVu.IDDichVu
			from DichVu
            join HopDong on HopDong.IDDichVu = DichVu.IDDichVu
			where (year(HopDong.NgayLamHopDong ) = 2019)
        ) ; 
        
-- task 8 cach 1         
Select distinct TenKhachHang
From KhachHang;

-- task 8 cach 2   
Select TenKhachHang
From KhachHang
group by TenKhachHang;

-- task 9
-- cach 1 
drop table if exists tempT; 
create temporary table tempT (
select HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, 
		(DichVu.ChiPhiThue + sum(DichVuDiKem.Gia*HopDongChiTiet.SoLuong)) as TongTien
from HopDong
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong
having year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) = 2);

select sum(TongTien) as TongDoanhThu
from tempT;  

-- cach 2 
select sum(TongTien)
from (select HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, 
		(DichVu.ChiPhiThue + sum(DichVuDiKem.Gia*HopDongChiTiet.SoLuong)) as TongTien
from HopDong
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong
having year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) = 2) as A;

select HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, 
		(DichVu.ChiPhiThue + sum(DichVuDiKem.Gia*HopDongChiTiet.SoLuong)) as TongTien
from HopDong
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong
having year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) = 2;


select count(HopDong.IDHopDong) as TongKhachHang
from HopDong
join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
where year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) = 2;

-- task 10
select HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, HopDong.NgayLamHopDong, HopDong.TienDatCoc,
		count(HopDong.IDHopDong) as SoDichVuDiKem
from HopDong
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong;

-- task 11 
select DichVuDiKem.TenDichVuDiKem, HopDong.IDHopDong,KhachHang.TenKhachHang, KhachHang.IDLoaiKhach, KhachHang.DiaChi
from HopDong
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
where KhachHang.IDLoaiKhach = 1 and KhachHang.DiaChi = 'Vinh';

-- task 12 
select HopDong.IDHopDong, NhanVien.TenNhanVien, KhachHang.TenKhachHang, KhachHang.SDT, DichVu.TenDichVu, HopDong.TienDatCoc
		, HopDong.NgayLamHopDong, DichVuDiKem.TenDichVuDiKem , count(DichVuDiKem.IDDichVuDiKem) as SoDichVuDiKem
from DichVu
join HopDong on DichVu.IDDichVu = HopDong.IDDichVu
join NhanVien on NhanVien.IDNhanVien = HopDong.IDNhanVien
join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
where year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) between 10 and 12 
and not exists (
select HopDong.NgayLamHopDong
from HopDong
where (HopDong.IDDichVu = DichVu.IDDichVu) and (year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) between 1 and 6)
)
group by HopDong.IDHopDong;



