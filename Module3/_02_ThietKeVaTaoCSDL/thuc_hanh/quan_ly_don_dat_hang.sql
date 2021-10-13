drop database if exists oder_management;

create database oder_management;

use oder_management;

create table dv_khach(
ma_DV int not null primary key,
ten_DV varchar(50) not null,
address varchar(50) not null,
phone int not null);

create table nguoi_dat(
ma_ND int not null primary key,
ma_DV int not null,
ten_DV  varchar(50) not null,
foreign key (ma_DV) references dv_khach (ma_DV)
);

create table nguoi_nhan(
ma_NN int not null primary key,
ma_DV int not null,
foreign key (ma_DV) references dv_khach (ma_DV)
);

create table nguoi_giao(
ma_NG int not null primary key,
ten_NG varchar(50) not null
);

create table noi_giao(
ma_so_DDG int not null primary key,
ten_noi_giao varchar(50) not null
);

create table dat(
so_HD int not null primary key,
ngay_dat date not null,
so_luong int not null,
ma_ND int not null,
foreign key (ma_ND) references nguoi_dat (ma_ND)
);

create table giao(
so_PG int not null primary key,
ngay_giao date not null,
don_gia int not null,
so_luong int not null,
ma_NN int not null,
ma_so_DDG int not null,
ma_NG int not null,
foreign key (ma_NN) references nguoi_nhan (ma_NN),
foreign key (ma_so_DDG) references noi_giao(ma_so_DDG),
foreign key (ma_NG) references nguoi_giao(ma_NG)
);

create table hang (
ma_hang int not null primary key,
ten_hang varchar(50) not null,
dv_tinh varchar(5) not null,
mota TEXT,
so_HD int not null,
so_PG int not null,
foreign key (so_HD) references dat (so_HD),
foreign key (so_PG) references giao (so_PG)
);

