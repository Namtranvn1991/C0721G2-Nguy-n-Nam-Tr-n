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
DonVi int,
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
value ("Hoang AAA","1991-2-3","DaNang"),
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
       ("Nguyen C",3,"DaNang"),
       ("Tran DDDD",3,"Vinh");      
       
       
insert into LoaiDichVu (TenLoaiDichVu)
value ("Villa"),
	  ("House"),   
	  ("Room"); 
      
insert into DichVu (TenDichVu,IDLoaiDichVu,ChiPhiThue)
value ("Villa1",1,120),
       ("Villa2",1,100),
       ("Villa3",1,200),
       ("House1",2,50),
       ("House2",2,80),
       ("House3",2,50),
       ("Room1",3,10),
       ("Room2",3,15);
       
insert into DichVuDiKem(TenDichVuDiKem,Gia)
value ("AAA",5),
      ("BBB",1), 
      ("CCC",3), 
      ("DDD",10); 
      
insert into HopDong (IDNhanVien,IDKhachHang,IDDichVu,NgayLamHopDong) 
value (2,1,2,"2018-2-3"),     
      (1,1,2,"2019-2-3"), 
      (2,2,3,"2018-2-3"), 
      (4,3,4,"2019-11-3"), 
      (3,4,5,"2019-4-3"),
      (3,5,5,"2019-11-3");
       
insert into HopDongChiTiet  (IDHopDong,IDDichVuDiKem,SoLuong)
value (1,1,2),
	  (2,2,3),
	  (2,1,2),
	  (3,3,2),
	  (4,4,2),
	  (5,2,2);
    
