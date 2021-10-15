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
select HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, HopDong.NgayKetThuc, 
		(DichVu.ChiPhiThue + sum(DichVuDiKem.Gia*HopDongChiTiet.SoLuong)) as TongTien
from HopDong
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong
having year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) = 2;


select HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, HopDong.NgayKetThuc, 
		(DichVu.ChiPhiThue + sum(DichVuDiKem.Gia*HopDongChiTiet.SoLuong)) as TongTien
from HopDong
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong;
        
             
        
        





