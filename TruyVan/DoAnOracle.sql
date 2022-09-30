                                                                  -- 2001190421.
                                                           -- Nguyen Le Gia Bao.

------------================= DO AN HQTCSDL ORACLE =================------------
select * from dba_fga_audit_trail;
select session_id, db_user, object_schema, object_name, policy_name, sql_text, statement_type from dba_fga_audit_trail;

select dba_tablespaces.tablespace_name, file_name, logging, online_status 
from dba_tablespaces, dba_data_files
where dba_tablespaces.tablespace_name = dba_data_files.tablespace_name;
select * from dba_data_files;

select last_login as lastLogin from dba_users where username = '0001';

--------------------------------------------------------------------------------
-- Tao user va gan quyen
create user "0001" identified by 123;
grant connect to "0001"; 
grant insert, select, update on sys.ACCOUNT_USER to "0001";
grant insert, select, update on sys.DIACHI to "0001";
grant insert, select, update on sys.KHACH to "0001";
grant insert, select, update on sys.THE to "0001";
grant insert, select, update on sys.TACGIA to "0001";
grant insert, select, update on sys.SACH to "0001";
grant select on sys.view_inDiaChi to "0001";
grant select on sys.dba_users to "0001";

create user "0002" identified by 123;
grant connect to "0002";
grant insert, select, update on sys.ACCOUNT_USER to "0002";
grant insert, select, update on sys.DIACHI to "0002";
grant insert, select, update on sys.KHACH to "0002";
grant insert, select, update on sys.THE to "0002";
grant insert, select, update on sys.TACGIA to "0002";
grant insert, select, update on sys.SACH to "0002";
grant select on sys.view_inDiaChi to "0002";
grant select on sys.dba_users to "0002";

create user "0003" identified by 123;
grant connect to "0003";
grant insert, select, update on sys.ACCOUNT_USER to "0003";
grant insert, select, update on sys.DIACHI to "0003";
grant insert, select, update on sys.KHACH to "0003";
grant insert, select, update on sys.THE to "0003";
grant insert, select, update on sys.TACGIA to "0003";
grant insert, select, update on sys.SACH to "0003";
grant select on sys.view_inDiaChi to "0003";
grant select on sys.dba_users to "0003";

create user "0004" identified by 123;
grant connect to "0004";
grant insert, select, update on sys.ACCOUNT_USER to "0004";
grant insert, select, update on sys.DIACHI to "0004";
grant insert, select, update on sys.KHACH to "0004";
grant insert, select, update on sys.THE to "0004";
grant insert, select, update on sys.TACGIA to "0004";
grant insert, select, update on sys.SACH to "0004";
grant select on sys.view_inDiaChi to "0004";
grant select on sys.dba_users to "0004";

create user "0005" identified by 123;
grant connect to "0005";
grant insert, select, update on sys.ACCOUNT_USER to "0005";
grant insert, select, update on sys.DIACHI to "0005";
grant insert, select, update on sys.KHACH to "0005";
grant insert, select, update on sys.THE to "0005";
grant insert, select, update on sys.TACGIA to "0005";
grant insert, select, update on sys.SACH to "0005";
grant select on sys.view_inDiaChi to "0005";
grant select on sys.dba_users to "0005";

create user "0006" identified by 123;
grant connect to "0006"; 
grant insert, select, update on sys.ACCOUNT_USER to "0006";
grant insert, select, update on sys.DIACHI to "0006";
grant insert, select, update on sys.KHACH to "0006";
grant insert, select, update on sys.THE to "0006";
grant insert, select, update on sys.TACGIA to "0006";
grant insert, select, update on sys.SACH to "0006";
grant select on sys.view_inDiaChi to "0006";
grant select on sys.dba_users to "0006";

create user "0007" identified by 123;
grant connect to "0007"; 
grant insert, select, update on sys.ACCOUNT_USER to "0007";
grant insert, select, update on sys.DIACHI to "0007";
grant insert, select, update on sys.KHACH to "0007";
grant insert, select, update on sys.THE to "0007";
grant insert, select, update on sys.TACGIA to "0007";
grant insert, select, update on sys.SACH to "0007";
grant select on sys.view_inDiaChi to "0007";
grant select on sys.dba_users to "0007";

create user "0008" identified by 123;
grant connect to "0008"; 
grant insert, select, update on sys.ACCOUNT_USER to "0008";
grant insert, select, update on sys.DIACHI to "0008";
grant insert, select, update on sys.KHACH to "0008";
grant insert, select, update on sys.THE to "0008";
grant insert, select, update on sys.TACGIA to "0008";
grant insert, select, update on sys.SACH to "0008";
grant select on sys.view_inDiaChi to "0008";
grant select on sys.dba_users to "0008";

create user "0009" identified by 123;
grant connect to "0009"; 
grant insert, select, update on sys.ACCOUNT_USER to "0009";
grant insert, select, update on sys.DIACHI to "0009";
grant insert, select, update on sys.KHACH to "0009";
grant insert, select, update on sys.THE to "0009";
grant insert, select, update on sys.TACGIA to "0009";
grant insert, select, update on sys.SACH to "0009";
grant select on sys.view_inDiaChi to "0009";
grant select on sys.dba_users to "0009";

create user "0010" identified by 123;
grant connect to "0010";
grant insert, select, update on sys.ACCOUNT_USER to "0010";
grant insert, select, update on sys.DIACHI to "0010";
grant insert, select, update on sys.KHACH to "0010";
grant insert, select, update on sys.THE to "0010";
grant insert, select, update on sys.TACGIA to "0010";
grant insert, select, update on sys.SACH to "0010";
grant select on sys.view_inDiaChi to "0010";
grant select on sys.dba_users to "0010";

create user "0011" identified by 123;
grant connect to "0011"; 
grant insert, select, update on sys.ACCOUNT_USER to "0011";
grant insert, select, update on sys.DIACHI to "0011";
grant insert, select, update on sys.KHACH to "0011";
grant insert, select, update on sys.THE to "0011";
grant insert, select, update on sys.TACGIA to "0011";
grant insert, select, update on sys.SACH to "0011";
grant select on sys.view_inDiaChi to "0011";
grant select on sys.dba_users to "0011";

create user "0012" identified by 123;
grant connect to "0012"; 
grant insert, select, update on sys.ACCOUNT_USER to "0012";
grant insert, select, update on sys.DIACHI to "0012";
grant insert, select, update on sys.KHACH to "0012";
grant insert, select, update on sys.THE to "0012";
grant insert, select, update on sys.TACGIA to "0012";
grant insert, select, update on sys.SACH to "0012";
grant select on sys.view_inDiaChi to "0012";
grant select on sys.dba_users to "0012";

create user "0013" identified by 123;
grant connect to "0013"; 
grant insert, select, update on sys.ACCOUNT_USER to "0013";
grant insert, select, update on sys.DIACHI to "0013";
grant insert, select, update on sys.KHACH to "0013";
grant insert, select, update on sys.THE to "0013";
grant insert, select, update on sys.TACGIA to "0013";
grant insert, select, update on sys.SACH to "0013";
grant select on sys.view_inDiaChi to "0013";
grant select on sys.dba_users to "0013";

create user "0014" identified by 123;
grant connect to "0014"; 
grant insert, select, update on sys.ACCOUNT_USER to "0014";
grant insert, select, update on sys.DIACHI to "0014";
grant insert, select, update on sys.KHACH to "0014";
grant insert, select, update on sys.THE to "0014";
grant insert, select, update on sys.TACGIA to "0014";
grant insert, select, update on sys.SACH to "0014";
grant select on sys.view_inDiaChi to "0014";
grant select on sys.dba_users to "0014";

create user "0015" identified by 123;
grant connect to "0015"; 
grant insert, select, update on sys.ACCOUNT_USER to "0015";
grant insert, select, update on sys.DIACHI to "0015";
grant insert, select, update on sys.KHACH to "0015";
grant insert, select, update on sys.THE to "0015";
grant insert, select, update on sys.TACGIA to "0015";
grant insert, select, update on sys.SACH to "0015";
grant select on sys.view_inDiaChi to "0015";
grant select on sys.dba_users to "0015";

create user "0016" identified by 123;
grant connect to "0016"; 
grant insert, select, update on sys.ACCOUNT_USER to "0016";
grant insert, select, update on sys.DIACHI to "0016";
grant insert, select, update on sys.KHACH to "0016";
grant insert, select, update on sys.THE to "0016";
grant insert, select, update on sys.TACGIA to "0016";
grant insert, select, update on sys.SACH to "0016";
grant select on sys.view_inDiaChi to "0016";
grant select on sys.dba_users to "0016";

create user "0017" identified by 123;
grant connect to "0017"; 
grant insert, select, update on sys.ACCOUNT_USER to "0017";
grant insert, select, update on sys.DIACHI to "0017";
grant insert, select, update on sys.KHACH to "0017";
grant insert, select, update on sys.THE to "0017";
grant insert, select, update on sys.TACGIA to "0017";
grant insert, select, update on sys.SACH to "0017";
grant select on sys.view_inDiaChi to "0017";
grant select on sys.dba_users to "0017";

create user "0018" identified by 123;
grant connect to "0018"; 
grant insert, select, update on sys.ACCOUNT_USER to "0018";
grant insert, select, update on sys.DIACHI to "0018";
grant insert, select, update on sys.KHACH to "0018";
grant insert, select, update on sys.THE to "0018";
grant insert, select, update on sys.TACGIA to "0018";
grant insert, select, update on sys.SACH to "0018";
grant select on sys.view_inDiaChi to "0018";
grant select on sys.dba_users to "0018";

create user "0019" identified by 123;
grant connect to "0019"; 
grant insert, select, update on sys.ACCOUNT_USER to "0019";
grant insert, select, update on sys.DIACHI to "0019";
grant insert, select, update on sys.KHACH to "0019";
grant insert, select, update on sys.THE to "0019";
grant insert, select, update on sys.TACGIA to "0019";
grant insert, select, update on sys.SACH to "0019";
grant select on sys.view_inDiaChi to "0019";
grant select on sys.dba_users to "0019";

create user "0020" identified by 123;
grant connect to "0020"; 
grant insert, select, update on sys.ACCOUNT_USER to "0020";
grant insert, select, update on sys.DIACHI to "0020";
grant insert, select, update on sys.KHACH to "0020";
grant insert, select, update on sys.THE to "0020";
grant insert, select, update on sys.TACGIA to "0020";
grant insert, select, update on sys.SACH to "0020";
grant select on sys.view_inDiaChi to "0020";
grant select on sys.dba_users to "0020";
commit


-- User quan tri
select * from dba_users;
create user administrator identified by 123;
grant connect, resource, dba to administrator;
GRANT ALL PRIVILEGES TO administrator;


set SERVEROUTPUT ON

select * from sys.dba_profiles;
desc dba_profiles;

commit

--ACCOUNT_USER--ACCOUNT_ADMIN--DIACHI--KHACH--THE--TACGIA--CHUCVU--SACH--NHANVIEN--PHIEUMUON--
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

-- GIO HANG --------------------------------------------------------------------
create table GIOHANG
(
    maHD INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) NOT NULL primary key,
    maSach char (10) not null,
    CMND char (12) not null,
    giaSach int,
	soLuong int,
    constraint fk_GH_S foreign key (maSach) references SACH (maSach),
    constraint fk_GH_K foreign key (CMND) references KHACH (CMND)
); 

-- Tài kho?n ??c gi? ---------------------------------------------------------------------------------------------------------
create table ACCOUNT_USER 
(
	CMND char (12) primary key,
	pass char (70)
);

-- Tài kho?n admin -----------------------------------------------------------------------------------------------------------
create table ACCOUNT_ADMIN
(
	userName char (50) primary key,
	pass char (70)
);

-- Ð?a ch? theo 63 t?nh thành ------------------------------------------------------------------------------------------------
create table DIACHI 
(
	tenDC nvarchar2 (80) primary key
);

-- Thông tin ??c gi? ---------------------------------------------------------------------------------------------------------
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

-- Th? (Ð?c và Mu?n) ---------------------------------------------------------------------------------------------------------
create table THE
(
	maThe number not null primary key, -- Ð?c và Mu?n
	ngayCap date,
	loaiThe nvarchar2 (20),
	CMND char(12), 
	constraint fk_cmnd foreign key (CMND) references KHACH (CMND)
);
-- Tác gi? -------------------------------------------------------------------------------------------------------------------
create table TACGIA
(
	maTG char(20) not null primary key,
	teNTG nvarchar2 (50)
);

-- Ch?c v? -------------------------------------------------------------------------------------------------------------------
create table CHUCVU
(
	maCV char(20) not null primary key,
	tenCV nvarchar2 (20)
);

-- Sách ----------------------------------------------------------------------------------------------------------------------
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

-- Nhân viên -----------------------------------------------------------------------------------------------------------------
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

-- Phi?u m??n ----------------------------------------------------------------------------------------------------------------
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

-- DATA ======================================================================================================================
-- Ð?a ch? -------------------------------------------------------------------------------------------------------------------
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

-- Tài kho?n admin -----------------------------------------------------------------------------------------------------------
insert into ACCOUNT_ADMIN values ('admin', 'admin123');
insert into ACCOUNT_ADMIN values ('sys', 'sys');
insert into ACCOUNT_ADMIN values ('administrator', '123');
select * from ACCOUNT_ADMIN;

-- Tài kho?n ??c gi? ---------------------------------------------------------------------------------------------------------
insert into ACCOUNT_USER values ('hr', 'hr');
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

-- Thông tin ??c gi? ---------------------------------------------------------------------------------------------------------
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


-- The ----------------------------------------------------------------------------------------------------------------------
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
insert into THE values (kcthe.nextval, '09/03/2020', N'M??n', '0008');
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

-- Tác gia -----------------------------------------------------------------------------------------------------------------
insert into TACGIA values ('NNA', N'Nguy?n Nh?t Ánh');
insert into TACGIA values ('TH', N'Trang H?');
insert into TACGIA values ('NPV', N'Nguy?n Phong Vi?t');
insert into TACGIA values ('NMN', N'Nguy?n Minh Nh?t');
insert into TACGIA values ('AK', N'Anh Khang');
select * from TACGIA;

-- Chuc vu ----------------------------------------------------------------------------------------------------------------
insert into CHUCVU values ('GD', N'Giám Ð?c');
insert into CHUCVU values ('PGD', N'Phó Giám Ð?c');
insert into CHUCVU values ('TT', N'Th? Thý');
insert into CHUCVU values ('TN', N'Thu Ngân');
insert into CHUCVU values ('LC', N'Lao công');
select * from CHUCVU;

-- Sách -------------------------------------------------------------------------------------------------------------------
-- sequence kcSach, cho ma sach tang du dong
CREATE SEQUENCE kcSach
       INCREMENT BY 1    -- tang 1 don vi
       START WITH 1      -- bat dau tu 1
       NOCYCLE;

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

-- Nhân viên --------------------------------------------------------------------------------------------------------------
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


-- Phi?u m??n --------------------------------------------------------------------------------------------------------------
insert into PHIEUMUON values ('0001', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0002', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0003', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0004', 'S001', 'NV002', '23/11/2020', '23/11/2021', '100000');
insert into PHIEUMUON values ('0005', 'S001', 'NV002', '23/11/2020', '23/11/2021', '100000');
insert into PHIEUMUON values ('0006', 'S001', 'NV003', '25/11/2020', '25/11/2021', '100000');
insert into PHIEUMUON values ('0007', 'S001', 'NV004', '26/11/2020', '26/11/2021', '100000');
select * from PHIEUMUON;

select * from NHanVien;
select count(*) as soluong from sys.NHanVien where MANV = 'NV001';
select count(*) as soluong from sys.SACH where masach = 'S019';
select count(*) as sl from sys.ACCOUNT_USER where CMND = 'hr';















grant hihi to test123


begin
    alter user t1223 identified by t123
    default tablespace vidu
    quota 2M on vidu
    profile QUANLY;
    grant nhomq1 to t1223;
end

grant create session to NHOMQ
START transaction
    set TRANSACTION ISOLATION LEVEL read COMMITTED;
    create user 1NVD identified by 1NVD
    default tablespace VIDU
    quota 2M on VIDU
    profile QUANLY;
    grant khach to 1NVD;
commit


------------------------------ tim kiem user -----------------------------------
select username, created, expiry_date, account_status, last_login, profile 
from dba_users
where (username like '%SYSBACKUP%') or (created like '%SYSBACKUP%') or 
(expiry_date like '%SYSBACKUP%') or (account_status like '%SYSBACKUP%') or 
(last_login like '%SYSBACKUP%') or (profile like '%SYSBACKUP%')

select count(*) as soluong from v$session where type !='BACKGROUND' and sid=246 and serial#=12053


------------------------------PROCEDURE table-----------------------------------
select * from dba_users;
select * from account_user;

CREATE or replace procedure tet 
(cm in account_user.cmnd%type,
ps out account_user%rowtype )

is
begin
select * into ps from account_user where cmnd=cm;
end ;

declare
b1 account_user%rowtype; 
BEGIN   
   tet('hr',b1); 
   dbms_output.put_line('record inserted successfully');    
END;



select count(*) as USOPEN from dba_users where account_status='OPEN';
select count(*) from dba_users where account_status!='OPEN';

select USERNAME,dba_users.password_versions from dba_users
where USERNAME='SYS' and dba_users.password_versions='sys'

select USERNAME, USER_ID,ACCOUNT_STATUS, LOCK_DATE, EXPIRY_DATE, CREATED, LAST_LOGIN from dba_users where account_status='OPEN';
select USERNAME, USER_ID,ACCOUNT_STATUS, LOCK_DATE, EXPIRY_DATE, CREATED, LAST_LOGIN from dba_users where (account_status='') or (USER_ID='')  or (ACCOUNT_STATUS='OPEN') or (LOCK_DATE='') or (EXPIRY_DATE='') or (CREATED='') or (LAST_LOGIN='');
select * from account_user where cmnd=? and pass=? ;
select * from sys.SACH ;
--quyen cap
grant select,update,insert on ACCOUNT_USER to hr;

set serveroutput on;

-------------------------------- do an 8 ---------------------------------------
select file_name,tablespace_name from dba_data_files;
declare 
 b1 dba_data_files.tablespace_name%type;
 b2 dba_data_files.file_name%type;
begin
 select tablespace_name,file_name into b1,b2 from dba_data_files where tablespace_name='VIDU' ;
 dbms_output.put_line('tablespace_name: '||b1);
 dbms_output.put_line('Duong Dan: '||b2);
end;

select * from dba_users;
declare 
b1 dba_users%rowtype;
begin
 select * into b1 from dba_users where username='SYS';
 DBMS_OUTPUT.PUT_line('Ten user:'||b1.username);
 DBMS_OUTPUT.PUT_line('Ten Tablespace:'||b1.default_tablespace);
 DBMS_OUTPUT.PUT_line('Ten Profle:'||b1.profile);
end;

select sid,serial#,username,program from v$session where type !='BACKGROUND';
declare
 cursor test1 is 
 select sid,serial#,username,program from v$session where type !='BACKGROUND';
 v_ss test1%rowtype;
begin
 open test1;
 loop
 fetch test1 into v_ss;
 exit when test1%notfound;
 DBMS_OUTPUT.PUT_LINE('Ten id:'||v_ss.sid);
 DBMS_OUTPUT.PUT_LINE('Ten serial:'||v_ss.serial#);
 DBMS_OUTPUT.PUT_LINE('Ten username:'||v_ss.username);
 DBMS_OUTPUT.PUT_LINE('Ten program:'||v_ss.program);
 end loop;
 close test1;
end;
---------------------------------------do an 1--------------------------

----------------------------------------do an 2-------------------------------
--xem thong tin process
select ADDR,PNAME,USERNAME,TERMINAL,PROGRAM,TRACEFILE from v$process
--xem thong tin cua instance
select instance_name,host_name,startup_time,status from v$instance
--xem thong tin database
select name,created,Log_mode,controlfile_time,open_mode from v$database
--xem thong tin datafile
select creation_change#,creation_time,rfile#,status,enabled,name from v$datafile

select * from sys.sach;

--xem thong tin cua session
select sid,serial#,username,program from sys.v$session where type !='BACKGROUND';
--kill 1 session
alter system kill session '2,2';
--xem session ung voi process
select s.sid,s.serial#,s.username,s.program,p.terminal,p.tracefile from v$session s,v$process p where s.paddr=p.addr and s.type !='BACKGROUND';

select * from v$tablespace
select * from dba_profiles
START transaction
    set TRANSACTION ISOLATION LEVEL read COMMITTED;
    create user 1NVD identified by 1NVD
    default tablespace VIDU
    quota 2M on VIDU
    profile QUANLY;
    grant khach to 1NVD;
commit

create role khach
grant create session to khach
select to_char(sysdate, 'fmDD/mm/YYYY - hh24:mi:ss') as NgayHienTai from dual
select * from DBA_SYS_PRIVS where grantee='create session'
select username, created, expiry_date, account_status, last_login, profile,default_tablespace from dba_users 
select username,password,default_tablespace,profile,account_status  from dba_users
select *  from dba_users where username='NV4'
SELECT * FROM dba_ts_quotas WHERE username = 'NV4';


-- Trigger log on và log off
create table log_trig_table 
(
    user_id char (40) not null primary key,
    log_date date,
    action char (90)
)

create or replace trigger logon_trig
after logon on schema
begin
    insert into log_trig_table values (user, sysdate, 'Logging on');
end;
/

create or replace trigger logoff_trig
before logoff on schema
begin
    insert into log_trig_table values (user, sysdate, 'Logging off');
end;


-- trigger truoc khi them phieu muon
CREATE OR REPLACE TRIGGER PHIEUMUON_before_insert 
BEFORE INSERT
   ON sys.PHIEUMUON
   FOR EACH ROW
   
BEGIN
    -- Cap nhat ngay bat dau muon la ngay hien tai
    :new.ngayBD := sysdate;

    -- Cap nhat tong tien la tong cua gia sach * so luong
    :new.tongTien := sum(SACH.giaSach * SACH.Soluong) 
    where sys.PHIEUMUON.maSach = sys.SACH.maSach;

END;



-- tao chuc nang tao PROFILE ---------------------------------------------------
-- tao profile -----------------------------------------------------------------
select * from chucvu;
select distinct profile from dba_profiles;
create profile vidu limit;

create profile QUANLY limit
    password_life_time 365  -- Thoi gian su dung 365 ngay
    failed_login_attempts 3 -- Nhap sai mat khau toi da 3 lan
    PASSWORD_LOCK_TIME 5    -- Khoa tai khoan trong 5 ngay
    PASSWORD_REUSE_MAX 5;   -- Doi mat khau toi da 5 ngay
    
create profile NHANVIEN limit
    password_life_time 365  -- Thoi gian su dung 365 ngay
    failed_login_attempts 3 -- Nhap sai mat khau toi da 3 lan
    PASSWORD_LOCK_TIME 5    -- Khoa tai khoan trong 5 ngay
    PASSWORD_REUSE_MAX 5;   -- Doi mat khau toi da 5 ngay
    
create profile KHACHHANG limit
    password_life_time 90   -- Thoi gian su dung 90 ngay
    failed_login_attempts 3 -- Nhap sai mat khau toi da 3 lan
    PASSWORD_LOCK_TIME 5    -- Khoa tai khoan trong 5 ngay
    PASSWORD_REUSE_MAX 5;   -- Doi mat khau toi da 5 ngay







-- tao tablespace --------------------------------------------------------------
select * from dba_tablespaces;
select * from dba_data_files;

create tablespace hoho 
datafile 'D:\Tablespace_VD\index01.DBF' 
size 10M
Autoextend On Next 500K 
Maxsize 50m





--------------------------------update 3




 



----------------------------------------------======================update 4=========-----------------
select * from DBA_SYS_PRIVS where grantee ='NV2'

--gan quyen hethong
grant create session to nv2 with admin option;
revoke create session from nv2 ;





------------------------------------------------------update 5------------------------------



CREATE ROLE nhomq2;
grant create session,connect, create table,create procedure, create trigger  to nhomq2;

select * from DBA_SYS_PRIVS where grantee='NV2'


grant nhomq2 to nv2, nv3, nv4;
revoke create session,connect, create table,create procedure, create trigger from nhomq2;

select * from view_inroles 
select * from view_inroles










--------------------------------------------------------------------------------
alter table KHACH
add constraint ck_SDT check (dienThoai > 0);

alter table SACH
add constraint ck_NXB check (namXB > 0);
alter table SACH
add constraint ck_Gia check (giaSach > 0);
alter table SACH
add constraint ck_SL check (soLuong > 0);

alter table NHANVIEN 
add constraint uni_SDT unique (dienThoai);
alter table NHANVIEN 
add constraint ck_luong check (luong > 0);

alter table PHIEUMUON
add constraint ck_TongTien check (tongTien > 0);
alter table PHIEUMUON
add constraint ck_NBD_NKT check (ngayBD < ngayKT);

select * from dba_users;
select * from view_taouser


create or replace procedure dangnhapsys 
(a in out sys.ACCOUNT_ADMIN.userName%type,
b in out sys.ACCOUNT_ADMIN.pass%type,
c out sys.ACCOUNT_ADMIN.userName%type,
d out sys.ACCOUNT_ADMIN.pass%type)
is
begin
 select * into c,d from sys.ACCOUNT_ADMIN where userName=a and pass=b;
 dbms_output.put_line( d||c);
end;

set serveroutput on
declare
ic  sys.ACCOUNT_ADMIN.userName%type;
id  sys.ACCOUNT_ADMIN.pass%type;
begin
exec dangnhapsys('sys','sys',ic,id);
end;