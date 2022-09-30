-- USER QUAN TRI HE THONG - QUAN LY THU VIEN 

-- Chay ben user sys -----------------------------------------------------------
--select * from dba_users;
--create user administrator identified by 123;
--grant connect, resource, dba to administrator;
--GRANT ALL PRIVILEGES TO administrator; -- Gan tat ca cac quyen he thong

select username, last_login as lastLogin from dba_users where username = 'ADMINISTRATOR';

-- Table -----------------------------------------------------------------------
drop table ACCOUNT_USER CASCADE CONSTRAINTS;
drop table ACCOUNT_ADMIN CASCADE CONSTRAINTS; 
drop table DIACHI CASCADE CONSTRAINTS;
drop table KHACH CASCADE CONSTRAINTS;
drop table THE CASCADE CONSTRAINTS;
drop table TACGIA CASCADE CONSTRAINTS;
drop table CHUCVU CASCADE CONSTRAINTS;
drop table SACH CASCADE CONSTRAINTS;
drop table NHANVIEN CASCADE CONSTRAINTS;
drop table PHIEUMUON CASCADE CONSTRAINTS;

-- Tài kho?n ??c gi? 
create table ACCOUNT_USER 
(
	CMND char (12) primary key,
	pass char (70)
);

-- Tài kho?n admin 
create table ACCOUNT_ADMIN
(
	userName char (50) primary key,
	pass char (70)
);

-- Ð?a ch? theo 63 t?nh thành 
create table DIACHI 
(
	tenDC nvarchar2 (80) primary key
);
select * from dba_users;
-- Thông tin ??c gi? 
create table KHACH
(
	CMND char(12) not null primary key,
	Ten nvarchar2 (30),
	ngaySinh date,
	gioiTinh nvarchar2 (10),
	tenDC nvarchar2 (80),
	dienThoai char (10),
	constraint fk_K_AU foreign key (CMND) references ACCOUNT_USER (CMND),
	constraint fk_K_DC foreign key (tenDC) references DIACHI (tenDC)
);

-- Th? (Ð?c và Mu?n) 
create table THE
(
	maThe number not null primary key, -- Ð?c và Mu?n
	ngayCap date,
	loaiThe nvarchar2 (20),
	CMND char(12), 
	constraint fk_cmnd foreign key (CMND) references KHACH (CMND)
);

-- Tác gi? 
create table TACGIA
(
	maTG char(20) not null primary key,
	teNTG nvarchar2 (50)
);

-- Ch?c v? 
create table CHUCVU
(
	maCV char(20) not null primary key,
	tenCV nvarchar2 (20)
);

-- Sách 
create table SACH
(
	maSach char(10) not null primary key,
	tenSach nvarchar2(70),
	maTG char(20),
	namXB int,
	giaSach int,
	soLuong int,
	constraint fk_S_TG foreign key (maTG) references TACGIA (maTG)
);

-- Nhân viên 
create table NHANVIEN
(
	maNV char (20) not null primary key,
	tenNV nvarchar2(50),
	maCV char(20),
	gioiTinh nvarchar2(3),
	namSinh date,
	tenDC nvarchar2(80),
	dienThoai char(10),
    luong int,
    constraint fk_NV_CV foreign key (maCV) references CHUCVU (maCV),
    constraint fk_NV_DC foreign key (tenDC) references DIACHI (tenDC)
);

-- Phi?u m??n 
create table PHIEUMUON
(
	CMND char(12),
	maSach char(10),
	maNV char(20),
	ngayBD date,
	ngayKT date,
	tongTien int,
	primary key(CMND, maSach, maNV), 
	constraint fk_PM_K foreign key (CMND) references KHACH (CMND),
	constraint fk_PM_S foreign key (maSach) references SACH (maSach),
	constraint fk_PM_NV foreign key (maNV) references NHANVIEN (maNV)
);

-- Data ------------------------------------------------------------------------
-- ??a ch? 
insert into DIACHI values (N'An Giang');
insert into DIACHI values (N'Bà r?a - V?ng tàu');
insert into DIACHI values (N'B?c Giang');
insert into DIACHI values (N'B?c K?n');
insert into DIACHI values (N'B?c Liêu');
insert into DIACHI values (N'B?c Ninh');
insert into DIACHI values (N'B?n Tre');
insert into DIACHI values (N'B?nh Ð?nh');
insert into DIACHI values (N'B?nh Dýõng');
insert into DIACHI values (N'B?nh Phý?c');
insert into DIACHI values (N'B?nh Thu?n');
insert into DIACHI values (N'Cà Mau');
insert into DIACHI values (N'C?n Thõ');
insert into DIACHI values (N'Cao B?ng');
insert into DIACHI values (N'Ðà N?ng');
insert into DIACHI values (N'Ð?k L?k');
insert into DIACHI values (N'Ð?k Nông');
insert into DIACHI values (N'Ði?n Biên');
insert into DIACHI values (N'Ð?ng Nai');
insert into DIACHI values (N'Ð?ng Tháp');
insert into DIACHI values (N'Gia Lai');
insert into DIACHI values (N'Hà Giang');
insert into DIACHI values (N'Hà Nam');
insert into DIACHI values (N'Hà N?i');
insert into DIACHI values (N'Hà T?nh');
insert into DIACHI values (N'H?i Dýõng');
insert into DIACHI values (N'H?i Ph?ng');
insert into DIACHI values (N'H?u Giang');
insert into DIACHI values (N'H?a B?nh');
insert into DIACHI values (N'Hýng Yên');
insert into DIACHI values (N'Khánh H?a');
insert into DIACHI values (N'Kiên Giang');
insert into DIACHI values (N'Kon Tum');
insert into DIACHI values (N'Lai Châu');
insert into DIACHI values (N'Lâm Ð?ng');
insert into DIACHI values (N'L?ng Sõn');
insert into DIACHI values (N'Lào Cai');
insert into DIACHI values (N'Long An');
insert into DIACHI values (N'Nam Ð?nh');
insert into DIACHI values (N'Ngh? An');
insert into DIACHI values (N'Ninh B?nh');
insert into DIACHI values (N'Ninh Thu?n');
insert into DIACHI values (N'Phú Th?');
insert into DIACHI values (N'Phú Yên');
insert into DIACHI values (N'Qu?ng B?nh');
insert into DIACHI values (N'Qu?ng Nam');
insert into DIACHI values (N'Qu?ng Ng?i');
insert into DIACHI values (N'Qu?ng Ninh');
insert into DIACHI values (N'Qu?ng Tr?');
insert into DIACHI values (N'Sóc Trãng');
insert into DIACHI values (N'Sõn La');
insert into DIACHI values (N'Tây Ninh');
insert into DIACHI values (N'Thái B?nh');
insert into DIACHI values (N'Thái Nguyên');
insert into DIACHI values (N'Thanh Hóa');
insert into DIACHI values (N'Th?a Thiên Hu?');
insert into DIACHI values (N'Ti?n Giang');
insert into DIACHI values (N'TP. H? Chí Minh');
insert into DIACHI values (N'Trà Vinh');
insert into DIACHI values (N'Tuyên Quang');
insert into DIACHI values (N'V?nh Long');
insert into DIACHI values (N'V?nh Phúc');
insert into DIACHI values (N'Yên Bái');
select * from DIACHI;

-- Tài kho?n admin 
insert into ACCOUNT_ADMIN values ('administrator', '123');
insert into ACCOUNT_ADMIN values ('sys', 'sys');
select * from ACCOUNT_ADMIN;

-- Tài kho?n ð?c gi? 
insert into ACCOUNT_USER values ('0001', '123');
insert into ACCOUNT_USER values ('0002', '123');
insert into ACCOUNT_USER values ('0003', '123');
insert into ACCOUNT_USER values ('0004', '123');
insert into ACCOUNT_USER values ('0005', '123');
insert into ACCOUNT_USER values ('0006', '123');
insert into ACCOUNT_USER values ('0007', '123');
insert into ACCOUNT_USER values ('0008', '123');
insert into ACCOUNT_USER values ('0009', '123');
insert into ACCOUNT_USER values ('0010', '123');
insert into ACCOUNT_USER values ('0011', '123');
insert into ACCOUNT_USER values ('0012', '123');
insert into ACCOUNT_USER values ('0013', '123');
insert into ACCOUNT_USER values ('0014', '123');
insert into ACCOUNT_USER values ('0015', '123');
insert into ACCOUNT_USER values ('0016', '123');
insert into ACCOUNT_USER values ('0017', '123');
insert into ACCOUNT_USER values ('0018', '123');
insert into ACCOUNT_USER values ('0019', '123');
insert into ACCOUNT_USER values ('0020', '123');
select * from ACCOUNT_USER;

-- Thông tin ð?c gi? 
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY';
--set dateformat dmy
insert into KHACH values ('0001', N'Nguy?n Công Phý?ng', '20/11/1995', 'Nam', N'TP. H? Chí Minh', '0123456789');
insert into KHACH values ('0002', N'Nguy?n Vãn Toàn', '20/10/1995', 'Nam', N'TP. H? Chí Minh', '0122256789');
insert into KHACH values ('0003', N'Nguy?n Quang H?i', '20/12/1993', 'Nam', N'TP. H? Chí Minh', '0993456789');
insert into KHACH values ('0004', N'Nguy?n Ti?n Linh', '11/11/1995', 'Nam', N'TP. H? Chí Minh', '0883456789');
insert into KHACH values ('0005', N'Tr?n ??nh Tr?ng', '21/11/1995', 'Nam', N'TP. H? Chí Minh', '0123446789');
insert into KHACH values ('0006', N'Nguy?n Tr?ng Hoàng', '13/11/1995', 'Nam', N'TP. H? Chí Minh', '0123006789');
insert into KHACH values ('0007', N'??ng Vãn Lâm', '12/11/1997', 'Nam', N'TP. H? Chí Minh', '0123456700');
insert into KHACH values ('0008', N'V? V?n Thanh', '25/11/1995', 'Nam', N'TP. H? Chí Minh', '0123456799');
insert into KHACH values ('0009', N'Tr?n Xuân Trý?ng', '20/09/1995', 'Nam', N'TP. H? Chí Minh', '0123451189');
insert into KHACH values ('0010', N'Nguy?n Phong H?ng Duy', '20/01/1995', 'Nam', N'TP. H? Chí Minh', '0100456789');
insert into KHACH values ('0011', N'Hà ??c Chinh', '20/05/1995', 'Nam', N'TP. H? Chí Minh', '0155456789');
insert into KHACH values ('0012', N'Qu? Ng?c H?i', '20/02/1995', 'Nam', N'TP. H? Chí Minh', '0123226789');
insert into KHACH values ('0013', N'Bùi Ti?n D?ng', '22/11/1995', 'Nam', N'TP. H? Chí Minh', '0123456339');
insert into KHACH values ('0014', N'?? Duy M?nh', '25/09/1995', 'Nam', N'TP. H? Chí Minh', '0123456449');
insert into KHACH values ('0015', N'Nguy?n Tu?n Anh', '26/11/1995', 'Nam', N'TP. H? Chí Minh', '0123489789');
insert into KHACH values ('0016', N'Lê Công Vinh', '21/12/1995', 'Nam', N'TP. H? Chí Minh', '0958395012');
insert into KHACH values ('0017', N'Nguy?n Hoàng ??c', '21/05/1995', 'Nam', N'TP. H? Chí Minh', '098593051');
insert into KHACH values ('0018', N'Bùi Hoàng Vi?t Anh', '20/07/1995', 'Nam', N'TP. H? Chí Minh', '0593950192');
insert into KHACH values ('0019', N'Nguy?n Thành Chung', '20/03/1995', 'Nam', N'TP. H? Chí Minh', '0192850395');
insert into KHACH values ('0020', N'?? Hùng D?ng', '20/08/1998', 'Nam', N'Hà N?i', '0593850182');
select * from KHACH;

-- Th? 
-- Ma the tang du dong voi sequence
CREATE SEQUENCE kcthe
       INCREMENT BY 1    -- tang 1 don vi
       START WITH 1      -- bat dau tu 1
       NOCYCLE;

ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY';
--set dateformat dmy
insert into THE values (kcthe.nextval, '01/03/2020', N'??c', '0001');
insert into THE values (kcthe.nextval, '01/03/2020', N'Mý?n', '0001');
insert into THE values (kcthe.nextval, '02/03/2020', N'??c', '0002');
insert into THE values (kcthe.nextval, '03/03/2020', N'??c', '0002');
insert into THE values (kcthe.nextval, '03/03/2020', N'Mý?n', '0002');
insert into THE values (kcthe.nextval, '04/03/2020', N'??c', '0003');
insert into THE values (kcthe.nextval, '05/03/2020', N'??c', '0004');
insert into THE values (kcthe.nextval, '06/03/2020', N'??c', '0005');
insert into THE values (kcthe.nextval, '06/03/2020', N'Mý?n', '0005');
insert into THE values (kcthe.nextval, '07/03/2020', N'??c', '0006');
insert into THE values (kcthe.nextval, '07/03/2020', N'Mý?n', '0006');
insert into THE values (kcthe.nextval, '08/03/2020', N'??c', '0007');
insert into THE values (kcthe.nextval, '09/03/2020', N'??c', '0008');
insert into THE values (kcthe.nextval, '09/03/2020', N'Mý?n', '0008');
insert into THE values (kcthe.nextval, '10/03/2020', N'??c', '0009');
insert into THE values (kcthe.nextval, '11/03/2020', N'??c', '0010');
insert into THE values (kcthe.nextval, '12/03/2020', N'??c', '0011');
insert into THE values (kcthe.nextval, '13/03/2020', N'??c', '0012');
insert into THE values (kcthe.nextval, '13/03/2020', N'Mý?n', '0012');
insert into THE values (kcthe.nextval, '14/03/2020', N'??c', '0013');
insert into THE values (kcthe.nextval, '15/03/2020', N'??c', '0014');
insert into THE values (kcthe.nextval, '15/03/2020', N'Mý?n', '0014');
insert into THE values (kcthe.nextval, '16/03/2020', N'??c', '0015');
insert into THE values (kcthe.nextval, '17/03/2020', N'??c', '0016');
insert into THE values (kcthe.nextval, '18/03/2020', N'??c', '0017');
insert into THE values (kcthe.nextval, '19/03/2020', N'??c', '0018');
insert into THE values (kcthe.nextval, '20/03/2020', N'??c', '0019');
insert into THE values (kcthe.nextval, '20/03/2020', N'??c', '0019');
insert into THE values (kcthe.nextval, '21/03/2020', N'??c', '0020');
insert into THE values (kcthe.nextval, '21/03/2020', N'??c', '0020');
select * from THE;

-- Tác gi? 
insert into TACGIA values ('NNA', N'Nguy?n Nh?t Ánh');
insert into TACGIA values ('TH', N'Trang H?');
insert into TACGIA values ('NPV', N'Nguy?n Phong Vi?t');
insert into TACGIA values ('NMN', N'Nguy?n Minh Nh?t');
insert into TACGIA values ('AK', N'Anh Khang');
select * from TACGIA;

-- Ch?c v? 
insert into CHUCVU values ('GD', N'Giám Ð?c');
insert into CHUCVU values ('PGD', N'Phó Giám Ð?c');
insert into CHUCVU values ('TT', N'Th? Thý');
insert into CHUCVU values ('TN', N'Thu Ngân');
insert into CHUCVU values ('LC', N'Lao công');
select * from CHUCVU;

-- Sách 
insert into SACH values ('S001', N'M?t bi?c', 'NNA', '2013', '110000', '50');
insert into SACH values ('S002', N'Cho tôi xin m?t vé ði tu?i thõ', 'NNA', '2008', '100000', '25');
insert into SACH values ('S003', N'Tôi là Bêtô', 'NNA', '2011', '100000', '20');
insert into SACH values ('S004', N'Cô gái ð?n t? hôm qua', 'NNA', '2015', '110000', '20');
insert into SACH values ('S005', N'Có hai con mèo ng?i bên c?a s? ', 'NNA', '2012', '110000', '20');
insert into SACH values ('S006', N'S? l?a ch?n c?a b?u tr?i', 'NMN', '2005', '90000', '15');
insert into SACH values ('S007', N'L?c l?i gi?a cô ðõn', 'NMN', '2014', '95000', '15');
insert into SACH values ('S008', N'Nõi nh?ng cõn gió d?ng chân', 'NMN', '2012', '90000', '15');
insert into SACH values ('S009', N'Nh?ng ngý?i xa l?', 'NMN', '2016', '90000', '15');
insert into SACH values ('S010', N'Ch?y tr?n m?t tr?i', 'NMN', '2016', '90000', '20');
insert into SACH values ('S011', N'Nh?ng ð?ng l?a trên v?nh Tây T?', 'TH', '2017', '86000', '15');
insert into SACH values ('S012', N'S?i Dây T?nh Yêu', 'TH', '2012', '90000', '15');
insert into SACH values ('S013', N'Ðàn bà ba mýõi', 'TH', '2010', '90000', '15');
insert into SACH values ('S014', N'Ði qua thýõng nh?', 'NPV', '2012', '70000', '11');
insert into SACH values ('S015', N'V? ðâu nh?ng v?t thýõng', 'NPV', '2015', '80000', '12');
insert into SACH values ('S016', N'Sinh ra ð? cô ðõn', 'NPV', '2014', '80000', '15');
insert into SACH values ('S017', N'Ngày trôi v? phía c?', 'AK', '2012', '90000', '19');
insert into SACH values ('S018', N'Bu?n làm sao buông', 'AK', '2014', '90000', '20');
insert into SACH values ('S019', N'Thýõng m?y c?ng là ngý?i dýng', 'AK', '2016', '90000', '15');
insert into SACH values ('S020', N'Ðý?ng hai ng?, ngý?i thýõng thành l?', 'AK', '2013', '100000', '15');
select * from SACH;

-- Nhân viên 
insert into NHANVIEN values ('NV001', N'Ph?m Gia B?o', 'TT', 'Nam', '12/04/2001', N'Tây Ninh', '0184728783', '9000000');
insert into NHANVIEN values ('NV002', N'Ph?m Gia Ð?t', 'TT', 'Nam', '12/04/2001', N'TP. H? Chí Minh', '0184728993', '9000000');
insert into NHANVIEN values ('NV003', N'Nguy?n Lê Gia B?o', 'TN', 'Nam', '20/06/2001', N'TP. H? Chí Minh', '0184711783', '9500000');
insert into NHANVIEN values ('NV004', N'Lê B?u Ði?n', 'TN', 'Nam', '10/09/2001', N'B?n Tre', '0224728783', '9500000');
insert into NHANVIEN values ('NV005', N'Mai Tu?n Thành', 'TN', 'Nam', '26/04/2001', N'Thanh Hóa', '0774728783', '9500000');
insert into NHANVIEN values ('NV006', N'Lê Ng?c Ngân', 'TT', N'N?', '01/05/2001', N'TP. H? Chí Minh', '0180028783', '9000000');
insert into NHANVIEN values ('NV007', N'L? Uy?n Nhi', 'TT', N'N?', '11/11/2001', N'TP. H? Chí Minh', '0184720083', '9000000');
insert into NHANVIEN values ('NV008', N'Mai Th? C?m Tiên', 'TT', N'N?', '17/08/2002', N'TP. H? Chí Minh', '0988728783', '9000000');
insert into NHANVIEN values ('NV009', N'Bùi T?n Trý?ng', 'PGD', 'Nam', '11/12/1999', N'TP. H? Chí Minh', '0189828783', '10000000');
insert into NHANVIEN values ('NV010', N'Nguy?n Thanh Tùng', 'GD', 'Nam', '13/09/1993', N'Thái B?nh', '0987728783', '12000000');
insert into NHANVIEN values ('NV011', N'Phan Nguy?n Gia Hân', 'LC', N'N?', '12/10/2000', N'B?n Tre', '0967583859', '8000000');
insert into NHANVIEN values ('NV012', N'Nguy?n Th? Th?o Ly', 'LC', 'Nam', '11/09/2001', N'TP. H? Chí Minh', '0958395910', '8000000');
select * from NHANVIEN;

-- Phi?u mý?n 
insert into PHIEUMUON values ('0001', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0002', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0003', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0004', 'S001', 'NV002', '23/11/2020', '23/11/2021', '100000');
insert into PHIEUMUON values ('0005', 'S001', 'NV002', '23/11/2020', '23/11/2021', '100000');
insert into PHIEUMUON values ('0006', 'S001', 'NV003', '25/11/2020', '25/11/2021', '100000');
insert into PHIEUMUON values ('0007', 'S001', 'NV004', '26/11/2020', '26/11/2021', '100000');
select * from PHIEUMUON;


CREATE OR REPLACE TRIGGER trigger_luong
BEFORE INSERT or update of luong on NHANVIEN
   for each row
begin
    if (NHANVIEN.luong < 0)
    then raise_application_error ('So dien thoai phai > 0!!!');
    end if;
END;



-- Cac nhom quyen cua he thong -------------------------------------------------
-- Liet ke quyen tuong ung cua DBA	
select * from DBA_SYS_PRIVS where grantee like 'DBA';	

-- User co quyen DBA
select * from DBA_ROLE_PRIVS where granted_role = 'DBA'; 

-- Xem cac nhom quyen
select * from dba_roles where common = 'NO'; 


CREATE ROLE KHACHHANG;
grant create session, connect to KHACHHANG;
grant select on KHACH to KHACHHANG;
grant select on THE to KHACHHANG;
grant select on SACH to KHACHHANG;
grant select on TACGIA to KHACHHANG;
grant select on ACCOUNT_USER to KHACHHANG;
grant select on DIACHI to KHACHHANG;


create role NHANVIEN;
grant create session, connect to NHANVIEN;
grant select on NHANVIEN to NHANVIEN;
grant select on THE to NHANVIEN;
grant insert on THE to NHANVIEN;
grant update on THE to NHANVIEN;
grant select on SACH to NHANVIEN;
grant insert on SACH to NHANVIEN;
grant update on SACH to NHANVIEN;
grant select on TACGIA to NHANVIEN;
grant insert on TACGIA to NHANVIEN;
grant update on TACGIA to NHANVIEN;
grant select on PHIEUMUON to NHANVIEN;
grant update on PHIEUMUON to NHANVIEN;
grant insert on PHIEUMUON to NHANVIEN;
grant select on ACCOUNT_USER to NHANVIEN;
grant select on DIACHI to NHANVIEN;


create role QUANTRI;
grant create session, connect to QUANTRI;
grant select any table to QUANTRI;
grant update any table to QUANTRI;
grant delete any table to QUANTRI;
grant insert any table to QUANTRI;