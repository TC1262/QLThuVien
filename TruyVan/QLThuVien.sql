use master 
go
if exists (select name from sysdatabases where name = 'QLThuVien_Oracle')
drop database QLThuVien_Oracle
go
create database QLThuVien_Oracle
go
use QLThuVien_Oracle
go

-- Tài khoản đọc giả ---------------------------------------------------------------------------------------------------------
create table ACCOUNT_USER
(
	CMND char (12) primary key,
	pass char (70)
)

-- Tài khoản admin -----------------------------------------------------------------------------------------------------------
create table ACCOUNT_ADMIN
(
	userName char (50) primary key,
	pass char (70)
)

-- Ðịa chỉ theo 63 tỉnh thành ------------------------------------------------------------------------------------------------
create table DIACHI 
(
	tenDC nvarchar2 (80) primary key
)

-- Thông tin đọc giả ---------------------------------------------------------------------------------------------------------
create table KHACH
(
	CMND char(12) not null primary key,
	Ten nvarchar2 (30),
	ngaySinh date,
	gioiTinh nvarchar2 (10),
	tenDC nvarchar2 (80),
	dienThoai char (10),
	avt blob,  -- kiểu dữ liệu binary large object, thường dùng chứa phim nhạc hình ảnh…, tối đa từ 8TB – 128TB tùy vào db block size 
	constraint fk_K_AU foreign key (CMND) references ACCOUNT_USER (CMND),
	constraint fk_K_DC foreign key (tenDC) references DIACHI (tenDC)
)

-- Thẻ (Ðọc và Muợn) ---------------------------------------------------------------------------------------------------------
create table THE
(
	maThe char(12) not null primary key, -- Ðọc và Muợn
	ngayCap date,
	loaiThe nvarchar2 (20),
	CMND char(12), 
	constraint fk_cmnd foreign key (CMND) references KHACH (CMND)
)

-- Tác giả -------------------------------------------------------------------------------------------------------------------
create table TACGIA
(
	maTG char(20) not null primary key,
	teNTG nvarchar2 (50)
)

-- Chức vụ -------------------------------------------------------------------------------------------------------------------
create table CHUCVU
(
	maCV char(20) not null primary key,
	tenCV nvarchar2 (20)
)

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
)

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
	Luong int,
	avt blob, -- kiểu dữ liệu binary large object, thường dùng chứa phim nhạc hình ảnh…, tối đa từ 8TB – 128TB tùy vào db block size           
    constraint fk_NV_CV foreign key (maCV) references CHUCVU (maCV),
    constraint fk_NV_DC foreign key (tenDC) references DIACHI (tenDC)
)

-- Phiếu mượn ----------------------------------------------------------------------------------------------------------------
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
)

-- DATA ======================================================================================================================
-- Ðịa chỉ -------------------------------------------------------------------------------------------------------------------
insert into DIACHI values (N'An Giang');
insert into DIACHI values (N'Bà rịa - Vũng tàu');
insert into DIACHI values (N'Bắc Giang');
insert into DIACHI values (N'Bắc Kạn');
insert into DIACHI values (N'Bạc Liêu');
insert into DIACHI values (N'Bắc Ninh');
insert into DIACHI values (N'Bến Tre');
insert into DIACHI values (N'Bình Định');
insert into DIACHI values (N'Bình Dương');
insert into DIACHI values (N'Bình Phước');
insert into DIACHI values (N'Bình Thuận');
insert into DIACHI values (N'Cà Mau');
insert into DIACHI values (N'Cần Thơ');
insert into DIACHI values (N'Cao Bằng');
insert into DIACHI values (N'Đà Nẵng');
insert into DIACHI values (N'Đắk Lắk');
insert into DIACHI values (N'Đắk Nông');
insert into DIACHI values (N'Điện Biên');
insert into DIACHI values (N'Đồng Nai');
insert into DIACHI values (N'Đồng Tháp');
insert into DIACHI values (N'Gia Lai');
insert into DIACHI values (N'Hà Giang');
insert into DIACHI values (N'Hà Nam');
insert into DIACHI values (N'Hà Nội');
insert into DIACHI values (N'Hà Tĩnh');
insert into DIACHI values (N'Hải Dương');
insert into DIACHI values (N'Hải Phòng');
insert into DIACHI values (N'Hậu Giang');
insert into DIACHI values (N'Hòa Bình');
insert into DIACHI values (N'Hưng Yên');
insert into DIACHI values (N'Khánh Hòa');
insert into DIACHI values (N'Kiên Giang');
insert into DIACHI values (N'Kon Tum');
insert into DIACHI values (N'Lai Châu');
insert into DIACHI values (N'Lâm Đồng');
insert into DIACHI values (N'Lạng Sơn');
insert into DIACHI values (N'Lào Cai');
insert into DIACHI values (N'Long An');
insert into DIACHI values (N'Nam Định');
insert into DIACHI values (N'Nghệ An');
insert into DIACHI values (N'Ninh Bình');
insert into DIACHI values (N'Ninh Thuận');
insert into DIACHI values (N'Phú Thọ');
insert into DIACHI values (N'Phú Yên');
insert into DIACHI values (N'Quảng Bình');
insert into DIACHI values (N'Quảng Nam');
insert into DIACHI values (N'Quảng Ngãi');
insert into DIACHI values (N'Quảng Ninh');
insert into DIACHI values (N'Quảng Trị');
insert into DIACHI values (N'Sóc Trăng');
insert into DIACHI values (N'Sơn La');
insert into DIACHI values (N'Tây Ninh');
insert into DIACHI values (N'Thái Bình');
insert into DIACHI values (N'Thái Nguyên');
insert into DIACHI values (N'Thanh Hóa');
insert into DIACHI values (N'Thừa Thiên Huế');
insert into DIACHI values (N'Tiền Giang');
insert into DIACHI values (N'TP. Hồ Chí Minh');
insert into DIACHI values (N'Trà Vinh');
insert into DIACHI values (N'Tuyên Quang');
insert into DIACHI values (N'Vĩnh Long');
insert into DIACHI values (N'Vĩnh Phúc');
insert into DIACHI values (N'Yên Bái');
select * from DIACHI;

-- Tài khoản admin -----------------------------------------------------------------------------------------------------------
insert into ACCOUNT_ADMIN values ('admin', 'admin123');
select * from ACCOUNT_ADMIN;

-- Tài khoản đọc giả ---------------------------------------------------------------------------------------------------------
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

-- Thông tin đọc giả ---------------------------------------------------------------------------------------------------------
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY';
--set dateformat dmy
insert into KHACH values ('0001', N'Nguyễn Công Phượng', '20/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0123456789');
insert into KHACH values ('0002', N'Nguyễn Văn Toàn', '20/10/1995', 'Nam', N'TP. Hồ Chí Minh', '0122256789');
insert into KHACH values ('0003', N'Nguyễn Quang Hải', '20/12/1993', 'Nam', N'TP. Hồ Chí Minh', '0993456789');
insert into KHACH values ('0004', N'Nguyễn Tiến Linh', '11/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0883456789');
insert into KHACH values ('0005', N'Trần Ðình Trọng', '21/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0123446789');
insert into KHACH values ('0006', N'Nguyễn Trọng Hoàng', '13/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0123006789');
insert into KHACH values ('0007', N'Ðặng Văn Lâm', '12/11/1997', 'Nam', N'TP. Hồ Chí Minh', '0123456700');
insert into KHACH values ('0008', N'Vũ Vãn Thanh', '25/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0123456799');
insert into KHACH values ('0009', N'Trần Xuân Trường', '20/09/1995', 'Nam', N'TP. Hồ Chí Minh', '0123451189');
insert into KHACH values ('0010', N'Nguyễn Phong Hồng Duy', '20/01/1995', 'Nam', N'TP. Hồ Chí Minh', '0100456789');
insert into KHACH values ('0011', N'Hà Ðức Chinh', '20/05/1995', 'Nam', N'TP. Hồ Chí Minh', '0155456789');
insert into KHACH values ('0012', N'Quế Ngọc Hải', '20/02/1995', 'Nam', N'TP. Hồ Chí Minh', '0123226789');
insert into KHACH values ('0013', N'Bùi Tiến Dũng', '22/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0123456339');
insert into KHACH values ('0014', N'Ðỗ Duy Mạnh', '25/09/1995', 'Nam', N'TP. Hồ Chí Minh', '0123456449');
insert into KHACH values ('0015', N'Nguyễn Tuấn Anh', '26/11/1995', 'Nam', N'TP. Hồ Chí Minh', '0123489789');
insert into KHACH values ('0016', N'Lê Công Vinh', '21/12/1995', 'Nam', N'TP. Hồ Chí Minh', '0958395012');
insert into KHACH values ('0017', N'Nguyễn Hoàng Ðức', '21/05/1995', 'Nam', N'TP. Hồ Chí Minh', '098593051');
insert into KHACH values ('0018', N'Bùi Hoàng Việt Anh', '20/07/1995', 'Nam', N'TP. Hồ Chí Minh', '0593950192');
insert into KHACH values ('0019', N'Nguyễn Thành Chung', '20/03/1995', 'Nam', N'TP. Hồ Chí Minh', '0192850395');
insert into KHACH values ('0020', N'Ðỗ Hùng Dũng', '20/08/1998', 'Nam', N'Hà Nội', '0593850182');
select * from KHACH;

-- Thẻ ----------------------------------------------------------------------------------------------------------------------
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY';
--set dateformat dmy
insert into THE values ('T001', '01/03/2020', N'Ðọc', '0001');
insert into THE values ('T002', '01/03/2020', N'Mượn', '0001');
insert into THE values ('T003', '02/03/2020', N'Ðọc', '0002');
insert into THE values ('T004', '03/03/2020', N'Ðọc', '0002');
insert into THE values ('T005', '03/03/2020', N'Mượn', '0002');
insert into THE values ('T006', '04/03/2020', N'Ðọc', '0003');
insert into THE values ('T007', '05/03/2020', N'Ðọc', '0004');
insert into THE values ('T008', '06/03/2020', N'Ðọc', '0005');
insert into THE values ('T009', '06/03/2020', N'Mượn', '0005');
insert into THE values ('T010', '07/03/2020', N'Ðọc', '0006');
insert into THE values ('T011', '07/03/2020', N'Mượn', '0006');
insert into THE values ('T012', '08/03/2020', N'Ðọc', '0007');
insert into THE values ('T013', '09/03/2020', N'Ðọc', '0008');
insert into THE values ('T014', '09/03/2020', N'Mượn', '0008');
insert into THE values ('T015', '10/03/2020', N'Ðọc', '0009');
insert into THE values ('T016', '11/03/2020', N'Ðọc', '0010');
insert into THE values ('T017', '12/03/2020', N'Ðọc', '0011');
insert into THE values ('T018', '13/03/2020', N'Ðọc', '0012');
insert into THE values ('T019', '13/03/2020', N'Mượn', '0012');
insert into THE values ('T020', '14/03/2020', N'Ðọc', '0013');
insert into THE values ('T021', '15/03/2020', N'Ðọc', '0014');
insert into THE values ('T022', '15/03/2020', N'Mượn', '0014');
insert into THE values ('T023', '16/03/2020', N'Ðọc', '0015');
insert into THE values ('T024', '17/03/2020', N'Ðọc', '0016');
insert into THE values ('T025', '18/03/2020', N'Ðọc', '0017');
insert into THE values ('T026', '19/03/2020', N'Ðọc', '0018');
insert into THE values ('T027', '20/03/2020', N'Ðọc', '0019');
insert into THE values ('T028', '20/03/2020', N'Ðọc', '0019');
insert into THE values ('T029', '21/03/2020', N'Ðọc', '0020');
insert into THE values ('T030', '21/03/2020', N'Ðọc', '0020');
select * from THE;

-- Tác giả -----------------------------------------------------------------------------------------------------------------
insert into TACGIA values ('NNA', N'Nguyễn Nhật Ánh');
insert into TACGIA values ('TH', N'Trang Hạ');
insert into TACGIA values ('NPV', N'Nguyễn Phong Việt');
insert into TACGIA values ('NMN', N'Nguyễn Minh Nhật');
insert into TACGIA values ('AK', N'Anh Khang');
select * from TACGIA;

-- Chức vụ ----------------------------------------------------------------------------------------------------------------
insert into CHUCVU values ('GD', N'Giám Đốc')
insert into CHUCVU values ('PGD', N'Phó Giám Đốc')
insert into CHUCVU values ('TT', N'Thủ Thư')
insert into CHUCVU values ('TN', N'Thu Ngân')
insert into CHUCVU values ('LC', N'Lao công');
select * from CHUCVU;

-- Sách -------------------------------------------------------------------------------------------------------------------
insert into SACH values ('S001', N'Mắt biếc', 'NNA', '2013', '110000', '50');
insert into SACH values ('S002', N'Cho tôi xin một vé đi tuổi thơ', 'NNA', '2008', '100000', '25');
insert into SACH values ('S003', N'Tôi là Bêtô', 'NNA', '2011', '100000', '20');
insert into SACH values ('S004', N'Cô gái đến từ hôm qua', 'NNA', '2015', '110000', '20');
insert into SACH values ('S005', N'Có hai con mèo ngồi bên cửa sổ ', 'NNA', '2012', '110000', '20');
insert into SACH values ('S006', N'Sự lựa chọn của bầu trời', 'NMN', '2005', '90000', '15');
insert into SACH values ('S007', N'Lạc lối giữa cô đơn', 'NMN', '2014', '95000', '15');
insert into SACH values ('S008', N'Nơi những cơn gió dừng chân', 'NMN', '2012', '90000', '15');
insert into SACH values ('S009', N'Những người xa lạ', 'NMN', '2016', '90000', '15');
insert into SACH values ('S010', N'Chạy trốn mặt trời', 'NMN', '2016', '90000', '20');
insert into SACH values ('S011', N'Những đống lửa trên vịnh Tây Tử', 'TH', '2017', '86000', '15');
insert into SACH values ('S012', N'Sợi Dây Tình Yêu', 'TH', '2012', '90000', '15');
insert into SACH values ('S013', N'Đàn bà ba mươi', 'TH', '2010', '90000', '15');
insert into SACH values ('S014', N'Đi qua thương nhớ', 'NPV', '2012', '70000', '11');
insert into SACH values ('S015', N'Về đâu những vết thương', 'NPV', '2015', '80000', '12');
insert into SACH values ('S016', N'Sinh ra để cô đơn', 'NPV', '2014', '80000', '15');
insert into SACH values ('S017', N'Ngày trôi về phía cũ', 'AK', '2012', '90000', '19');
insert into SACH values ('S018', N'Buồn làm sao buông', 'AK', '2014', '90000', '20');
insert into SACH values ('S019', N'Thương mấy cũng là người dưng', 'AK', '2016', '90000', '15');
insert into SACH values ('S020', N'Đường hai ngã, người thương thành lạ', 'AK', '2013', '100000', '15');
select * from SACH;

-- Nhân viên --------------------------------------------------------------------------------------------------------------
insert into NHANVIEN values ('NV001', N'Phạm Gia Bảo', 'TT', 'Nam', '12/04/2001', N'Tây Ninh', '0184728783', '9000000');
insert into NHANVIEN values ('NV002', N'Phạm Gia Đạt', 'TT', 'Nam', '12/04/2001', N'TP. Hồ Chí Minh', '0184728993', '9000000');
insert into NHANVIEN values ('NV003', N'Nguyễn Lê Gia Bảo', 'TN', 'Nam', '20/06/2001', N'TP. Hồ Chí Minh', '0184711783', '9500000');
insert into NHANVIEN values ('NV004', N'Lê Bữu Điền', 'TN', 'Nam', '10/09/2001', N'Bến Tre', '0224728783', '9500000');
insert into NHANVIEN values ('NV005', N'Mai Tuấn Thành', 'TN', 'Nam', '26/04/2001', N'Thanh Hóa', '0774728783', '9500000');
insert into NHANVIEN values ('NV006', N'Lê Ngọc Ngân', 'TT', N'Nữ', '01/05/2001', N'TP. Hồ Chí Minh', '0180028783', '9000000');
insert into NHANVIEN values ('NV007', N'Lý Uyển Nhi', 'TT', N'Nữ', '11/11/2001', N'TP. Hồ Chí Minh', '0184720083', '9000000');
insert into NHANVIEN values ('NV008', N'Mai Thị Cẩm Tiên', 'TT', N'Nữ', '17/08/2002', N'TP. Hồ Chí Minh', '0988728783', '9000000');
insert into NHANVIEN values ('NV009', N'Bùi Tấn Trường', 'PGD', 'Nam', '11/12/1999', N'TP. Hồ Chí Minh', '0189828783', '10000000');
insert into NHANVIEN values ('NV010', N'Nguyễn Thanh Tùng', 'GD', 'Nam', '13/09/1993', N'Thái Bình', '0987728783', '12000000');
insert into NHANVIEN values ('NV011', N'Phan Nguyễn Gia Hân', 'LC', N'Nữ', '12/10/2000', N'Bến Tre', '0967583859', '8000000');
insert into NHANVIEN values ('NV012', N'Nguyễn Thị Thảo Ly', 'LC', 'Nam', '11/09/2001', N'TP. Hồ Chí Minh', '0958395910', '8000000');
select * from NHANVIEN;

-- Phiếu mượn --------------------------------------------------------------------------------------------------------------
insert into PHIEUMUON values ('0001', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0002', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0003', 'S001', 'NV001', '20/11/2020', '20/11/2021', '100000');
insert into PHIEUMUON values ('0004', 'S001', 'NV002', '23/11/2020', '23/11/2021', '100000');
insert into PHIEUMUON values ('0005', 'S001', 'NV002', '23/11/2020', '23/11/2021', '100000');
insert into PHIEUMUON values ('0006', 'S001', 'NV003', '25/11/2020', '25/11/2021', '100000');
insert into PHIEUMUON values ('0007', 'S001', 'NV004', '26/11/2020', '26/11/2021', '100000');
select * from PHIEUMUON;

-- Gán quyền cho hr
grant select, insert, delete, update on ACCOUNT_USER to hr;
grant select, insert, delete, update on ACCOUNT_ADMIN to hr;
grant select, insert, delete, update on DIACHI to hr;
grant select, insert, delete, update on KHACH to hr;
grant select, insert, delete, update on THE to hr;
grant select, insert, delete, update on TACGIA to hr;
grant select, insert, delete, update on CHUCVU to hr;
grant select, insert, delete, update on SACH to hr;
grant select, insert, delete, update on NHANVIEN to hr;
grant select, insert, delete, update on PHIEUMUON to hr;