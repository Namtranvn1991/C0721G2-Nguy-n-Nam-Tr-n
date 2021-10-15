drop database if exists case_study;

create database case_study;

use case_study;

create table ViTri (
IDViTri int primary key auto_increment,
TenViTri varchar(45) not null
);
create table TrinhDo(
IDTrinhDo int primary key auto_increment,
TenTrinhDo varchar(45) not null
);

create table BoPhan(
IDBoPhan int primary key auto_increment,
TenBoPhan varchar(45) not null
);


create table NhanVien(
IDNhanVien int primary key auto_increment,
TenNhanVien varchar(45) not null,
IDViTri int,
IDTrinhDo int,
IDBoPhan int,
NgaySinh date,
SoCMTND varchar(45),
Luong varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
foreign key (IDViTri) references ViTri(IDViTri),
foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
foreign key (IDBoPhan) references BoPhan(IDBoPhan)
);

create table LoaiKhach(
IDLoaiKhach int primary key auto_increment,
TenLoaiKhach varchar(45) not null
);

create table KhachHang(
IDKhachHang int primary key auto_increment,
TenKhachHang varchar(45) not null,
IDLoaiKhach int,
NgaySinh date,
SoCMTND varchar(45),
Luong varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);

create table KieuThue(
IDKieuThue int primary key auto_increment,
TenKieuThue varchar(45) not null,
Gia int not null
);

create table LoaiDichVu(
IDLoaiDichVu int primary key auto_increment,
TenLoaiDichVu varchar(45) not null
);

create table DichVu(
IDDichVu int primary key auto_increment,
TenDichVu varchar(45) not null,
DienTich int,
SoTang int,
SoNguoiToiDa varchar(45),
ChiPhiThue varchar(45),
IDKieuThue int,
IDLoaiDichVu int,
TrangThai varchar(45),
foreign key (IDKieuThue) references KieuThue(IDKieuThue),
foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu)
);

create table DichVuDiKem(
IDDichVuDiKem int primary key auto_increment,
TenDichVuDiKem varchar(45) not null,
Gia int not null,
DonVi int not null,
TrangThaiKhaDung varchar(45)
);

create table HopDong(
IDHopDong int primary key auto_increment,
IDNhanVien int,
IDKhachHang int, 
IDDichVu int,
NgayLamHopDong date,
NgayKetThuc date,
TienDatCoc int,
TongTien int,
foreign key (IDNhanVien) references NhanVien(IDNhanVien),
foreign key (IDKhachHang) references KhachHang(IDKhachHang),
foreign key (IDDichVu) references DichVu(IDDichVu)
);

create table HopDongChiTiet(
IDHopDongChiTiet int primary key auto_increment,
IDHopDong int,
IDDichVuDiKem int,
SoLuong int,
foreign key (IDHopDong) references HopDong(IDHopDong),
foreign key (IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem),
unique (IDHopDong,IDDichVuDiKem)
);

insert into nhanvien (TenNhanVien,NgaySinh,DiaChi)
value ("Hoang AAAAAAAAAA","1991-2-3","DaNang"),
	  ("Hoa V","1991-2-3","DaNang"),
	  ("Toa V","2010-2-3","QuangTri"),
	  ("Aoa V","1999-2-3","SaiGon"),
	  ("Boa B","2000-2-3","DaNang"),
	  ("Koa K","2011-2-3","DaNang");
    
insert into LoaiKhach (TenLoaiKhach)
value ("Diamond"),
	  ("Platinum"),   
	  ("Gold"),   
	  ("Silver"),   
      ("Member");
      
 insert into KhachHang (TenKhachHang,IDLoaiKhach,DiaChi)
 value ("Nguyen A",1,"DaNang"),
       ("Tran C",2,"Vinh"),
       ("Nguyen C",1,"QuangNgai"),
       ("Le C",1,"Vinh"),
       ("Nguyen C",3,"DaNang");
    
    
