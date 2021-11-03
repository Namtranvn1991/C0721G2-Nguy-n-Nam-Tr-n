drop database if exists case_study;

create database case_study;

use case_study;

create table vi_tri (
id_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45) not null
);
create table trinh_do(
id_trinh_do int primary key auto_increment,
ten_trinh_do varchar(45) not null
);

create table bo_phan(
id_bo_phan int primary key auto_increment,
ten_bo_phan varchar(45) not null
);


create table nhan_vien(
id_nhan_vien int primary key auto_increment,
nhan_vien_code varchar(10) unique,
ten_nhan_vien varchar(45) not null,
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmtnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
status_nv bit default 1,
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
ON DELETE CASCADE
);

create table loai_khach(
id_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45) not null
);

create table khach_hang(
id_khach_hang int primary key auto_increment,
ten_khach_hang varchar(45) not null,
id_loai_khach int,
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
status_kh bit default 1,
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
ON DELETE CASCADE
);

create table kieu_thue(
id_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45) not null,
gia int not null
);

create table loai_dich_vu(
id_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45) not null
);

create table dich_vu(
id_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45) not null,
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
status_dv bit default 1,
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
ON DELETE CASCADE
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45) not null,
gia int not null,
don_vi int,
trang_thai_kha_dung varchar(45)
);

create table hop_dong(
id_hop_dong int primary key auto_increment,
id_nhan_vien int,
id_khach_hang int, 
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
status_hd bit default 1,
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang)
ON DELETE CASCADE,
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
ON DELETE CASCADE
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_hop_dong) references hop_dong(id_hop_dong)
ON DELETE CASCADE,
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),
unique (id_hop_dong,id_dich_vu_di_kem)
);

insert into bo_phan(ten_bo_phan)
value ("Bussiness"),
	  ("Technical"),
	  ("Administrative"),
	  ("Management"),
	  ("Service");
      
insert into vi_tri(ten_vi_tri)
value ("Manager"),
	  ("Deputy"),
	  ("Staff");  
      
insert into trinh_do(ten_trinh_do)
value ("High school graduated"),
	  ("Bachelor"),
	  ("Engineer"),
	  ("Master"); 
      
      

insert into nhan_vien (nhan_vien_code, ten_nhan_vien,ngay_sinh,dia_chi,id_bo_phan)
value ("NV-0001","Hoang AAA","1991-2-3","DaNang",1),
	  ("NV-0002","Hoa V","1991-2-3","DaNang",1),
	  ("NV-0003","Toa V","2010-2-3","QuangTri",2),
	  ("NV-0004","Aoa V","1999-2-3","SaiGon",3),
	  ("NV-0005","Boa B","2000-2-3","DaNang",4),
	  ("NV-0006","Koa K","2011-2-3","DaNang",5);
    
insert into loai_khach (ten_loai_khach)
value ("Diamond"),
	  ("Platinum"),   
	  ("Gold"),   
	  ("Silver"),   
      ("Member");
      
insert into khach_hang (ten_khach_hang,ngay_sinh,id_loai_khach,dia_chi)
value ("Nguyen A","1994-2-3",2,"DaNang"),
       ("Tran C","1989-2-3",2,"Vinh"),
       ("Nguyen C","1990-2-3",2,"QuangNgai"),
       ("Le C","1991-12-3",2,"Vinh"),
       ("Nguyen C","1991-2-3",2,"DaNang"),
       ("Vo thi ZZ","1992-2-11",1,"DaNang"),
       ("Tran DDDD","1991-2-3",2,"Vinh");      
       
       
insert into loai_dich_vu (ten_loai_dich_vu)
value ("Villa"),
	  ("House"),   
	  ("Room"); 
      
insert into dich_vu (ten_dich_vu,id_loai_dich_vu,chi_phi_thue)
value ("Villa1",1,120),
       ("Villa2",1,100),
       ("Villa3",1,200),
       ("House1",2,50),
       ("House2",2,80),
       ("House3",2,50),
       ("Room1",3,10),
       ("Room2",3,15);
       
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia)
value ("Massage",5),
      ("FreeDrink",1), 
      ("Gym",3), 
      ("AZ",10); 
      
insert into hop_dong (id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tong_tien) 
value (2,1,2,"2019-2-12","2019-12-15",55),     
      (1,1,2,"2019-2-12","2019-12-16",90), 
      (2,2,3,"2018-2-3","2018-2-3",120), 
      (4,3,4,"2019-11-3","2018-2-3",120), 
      (3,4,8,"2018-4-3","2018-2-3",99),
      (3,5,8,"2019-2-3","2018-2-3",50);
       
insert into hop_dong_chi_tiet  (id_hop_dong,id_dich_vu_di_kem,so_luong)
value (1,1,2),
	  (2,2,3),
	  (2,1,2),
	  (3,3,2),
	  (4,4,2),
	  (5,2,2);
    
