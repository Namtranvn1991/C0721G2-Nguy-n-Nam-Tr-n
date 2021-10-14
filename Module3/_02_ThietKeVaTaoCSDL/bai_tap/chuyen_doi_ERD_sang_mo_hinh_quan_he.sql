drop database if exists receipt_management;

create database receipt_management;

use receipt_management;

create table phieu_xuat(
soPX int primary key,
ngay_xuat date not null
);

create table phieu_nhap(
soPN int primary key,
ngay_nhap date  not null
);

create table vat_tu(
ma_VT int primary key,
ten_VT varchar(20)  not null
);

create table chi_tiet_PX(
soPX int,
ma_VT int,
DG_xuat int not null,
SL_xuat int not null,
primary key (soPX,ma_VT),
foreign key (soPX) references  phieu_xuat (soPX),
foreign key (ma_VT) references  vat_tu (ma_VT)
);

create table chi_tiet_NX(
soPN int,
ma_VT int,
DG_nhap int not null,
SL_nhap int not null,
primary key (soPN,ma_VT),
foreign key (soPN) references  phieu_nhap (soPN),
foreign key (ma_VT) references  vat_tu (ma_VT)
);

create table sdt (
ma_sdt int primary key,
sdt int not null
);

create table nhaCC (
ma_NCC int primary key,
ten_NCC varchar(30) not null,
dia_chi varchar(30) not null,
ma_sdt int,
foreign key (ma_sdt) references sdt (ma_sdt)
);


create table don_DH(
so_DH int primary key,
ngay_DH date not null,
ma_NCC int not null,
foreign key (ma_NCC) references nhaCC (ma_NCC)
);

create table chi_tiet_DDH(
so_DH int,
ma_VT int,
primary key (so_DH,ma_VT),
foreign key (so_DH) references don_DH (so_DH),
foreign key (ma_VT) references vat_tu (ma_VT)
);

