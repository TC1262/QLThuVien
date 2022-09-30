----------------================== PROCEDURE ==================----------------
-- Kiem tra so luong khoa chinh cua bang SACH ----------------------------------
set SERVEROUTPUT ON

create or REPLACE PROCEDURE ninktpkmasach 
(a in sach.masach%type, 
b out number)
is
begin
 select count(*) into b from SACH where maSach = a;
 dbms_output.put_line(b);
end;

declare ib number;
begin
    ninktpkmasach('S001',ib);
end;

------------------------------------ in diachi ---------------------------------
create or REPLACE PROCEDURE inDiaChi 
(x out DIACHI.tenDC%type)

is
begin
 for dc in (select tenDC  from DIACHI)
 loop
   dbms_output.put_line(dc.tenDC);
 end loop;
end inDiaChi;

-- chay 
declare idc sys.DIACHI.tenDC%type;
begin
 inDiaChi(idc);
end;


------------------------------------ in ACCOUNT_ADMIN --------------------------
create or REPLACE PROCEDURE inACCOUNT_ADMIN 
is
begin
 for aca in (select * from ACCOUNT_ADMIN)
 loop
   dbms_output.put_line(aca.userName||''||aca.pass);
 end loop;
end inACCOUNT_ADMIN;

--chay 
exec inACCOUNT_ADMIN;


------------------------------------ in ACCOUNT_USER ---------------------------
create or REPLACE PROCEDURE inACCOUNT_USER
is
begin
 for acu in (select * from ACCOUNT_USER)
 loop
   dbms_output.put_line(acu.cmnd||''||acu.pass);
 end loop;
end ;

exec inACCOUNT_USER;

------------------------------------in KHACH-------------------
create or REPLACE PROCEDURE inKHACH 
is
begin
 for inra in (select * from KHACH)
 loop
   dbms_output.put_line(inra.cmnd||' '||inra.Ten||' '||inra.ngaySinh||' '||inra.gioiTinh||' '||inra.tenDC||' '||
   inra.dienThoai);
 end loop;
end ;

--chay 
exec inKHACH;

------------------------------------ in THE ------------------------------------
create or REPLACE PROCEDURE inTHE
is
begin
 for inra in (select * from THE)
 loop
   dbms_output.put_line(inra.maThe||' '||inra.ngayCap||' '||inra.loaiThe||' '||inra.CMND);
 end loop;
end ;

--chay 
exec inTHE;
 

------------------------------------in TACGIA-------------------
create or REPLACE PROCEDURE inTACGIA
is
begin
 for inra in (select * from TACGIA)
 loop
   dbms_output.put_line(inra.maTG||' '||inra.teNTG);
 end loop;
end ;

--chay 
exec inTACGIA;

------------------------------------in CHUCVU-------------------
create or REPLACE PROCEDURE inCHUCVU
is
begin
 for inra in (select * from CHUCVU)
 loop
   dbms_output.put_line(inra.maCV||' '||inra.tenCV);
 end loop;
end ;

--chay 
exec inCHUCVU;


------------------------------------in SACH-------------------
create or REPLACE PROCEDURE inSACH 
is
begin
 for inra in (select * from SACH)
 loop
   dbms_output.put_line(inra.maSach||' '||inra.tenSach||' '||inra.maTG||' '||inra.namXB||' '||inra.giaSach||' '||inra.soLuong);
 end loop;
end ;

--chay 
exec inSACH;

------------------------------------in NHANVIEN-------------------
create or REPLACE PROCEDURE inNHANVIEN
is
begin
 for inra in (select * from NHANVIEN)
 loop
   dbms_output.put_line(inra.maNV||' '||inra.tenNV||' '||inra.maCV||' '||inra.gioiTinh||' '||inra.namSinh||' '||inra.tenDC||' '||inra.dienThoai||' '||inra.dienThoai);
 end loop;
end ;

--chay 
exec inNHANVIEN;


------------------------------------in PHIEUMUON-------------------
create or REPLACE PROCEDURE inPHIEUMUON 
is
begin
 for inra in (select * from PHIEUMUON)
 loop
   dbms_output.put_line(inra.CMND||' '||inra.maSach||' '||inra.maNV||' '||inra.ngayBD||' '||inra.ngayKT||' '||inra.tongTien);
 end loop;
end ;

--chay
exec inPHIEUMUON;

--------------------------------------------------======Them=================-------------------------------------------

---------------------------them ACCOUNT_ADMIN --------------------------------
create or REPLACE PROCEDURE addACCOUNT_ADMIN 
(u in ACCOUNT_ADMIN.userName%type,
p in ACCOUNT_ADMIN.pass%type)

is
begin
 insert into ACCOUNT_ADMIN values(u,p);
end;

--chay
exec addACCOUNT_ADMIN('Bao','123')
select * from ACCOUNT_ADMIN;

------------------------------ them account_user -----------------------------
create or REPLACE PROCEDURE addACCOUNT_USER 
(cm in account_user.cmnd%type,
ps in account_user.pass%type)

IS
BEGIN
   INSERT INTO account_user VALUES (cm,ps);
END;

--chay
EXECUTE addACCOUNT_USER('thu','123');
select * from account_user;

------------------------------- them khach ---------------------------
create or REPLACE PROCEDURE addKHACH 
(cm in khach.cmnd%type,
t in KHACH.ten%type, 
ns in khach.ngaySinh%type,
gt in KHACH.gioitinh%type, 
dc in khach.tendc%type,
dt in KHACH.dienthoai%type)

IS
BEGIN        
    insert into KHACH values (cm,t,ns,gt,dc,dt);
END;
      
-- chay
EXECUTE addKHACH('thu2','bao','1/1/2001','nam', 'TP. H? Chí Minh','08888');
select * from KHACH;

------------------------------------ them THE -------------------------------------
create or REPLACE PROCEDURE addTHE 
(mt in THE.mathe%type,
nc in THE.ngaycap%type, 
lt in THE.loaithe%type,
cm in THE.cmnd%type)

      IS
      BEGIN
          insert into THE values (mt,nc,lt,cm);
      END ;
      
--chay
EXECUTE addTHE(kcthe.nextval,'1/1/2020','hentoi','thu2');
select * from THE;

---------------------------------- them TACGIA -----------------------------
create or REPLACE PROCEDURE addTACGIA
(mt in TACGIA.matg%type,
ttg in TACGIA.tentg%type)

      IS
      BEGIN
          insert into TACGIA values (mt,ttg);
      END ;
      
--chay
EXECUTE addTACGIA('tg11',N'Pham gia bao');
select * from TACGIA;

-------------------------------- them CHUCVU --------------------------------
create or REPLACE PROCEDURE addCHUCVU
(mcv in CHUCVU.macv%type,
tcv in CHUCVU.tencv%type)
      
      IS
      BEGIN
          insert into CHUCVU values (mcv,tcv);
      END ;
      
--chay
EXECUTE addCHUCVU('cvnn',N'Con ch? t?ch');
EXECUTE addCHUCVU('cvnn2',N'Con cán b?');
select * from CHUCVU;


---------------------------------- them SACH -----------------------------------
create or REPLACE PROCEDURE addSACH
(ms in sach.masach%type,
ts in sach.tensach%type,
mtg in sach.maTG%type,
nxb in sach.namxb%type,
gs in sach.giasach%type,
sl in sach.soluong%type)
is
BEGIN
    insert into SACH values (ms,ts,mtg,nxb,gs,sl);
END ;

--chay
EXECUTE addSACH('stest', N'Sách g? g? g? ðó', 'AK', '2021', '100000', '15');
select * from SACH;

--------------------------------- them NHANVIEN --------------------------------
create or REPLACE PROCEDURE addNHANVIEN
(mnv in NHANVIEN.manv%type,
t in NHANVIEN.tennv%type,
mcv in NHANVIEN.macv%type,
gt in NHANVIEN.gioitinh%type,
ns in NHANVIEN.namsinh%type,
dc in NHANVIEN.tendc%type,
dt in NHANVIEN.dienthoai%type,
l in NHANVIEN.luong%type)

      IS
      BEGIN
          insert into NHANVIEN values (mnv,t,mcv,gt,ns,dc,dt,l);
      END ;
      
--chay
EXECUTE addNHANVIEN('nvthu','bao','TT','nam','1/1/2001','Tây Ninh','0555','568888');
select * from NHANVIEN;

------------------------------------ them PHIEUMUON ----------------------------
create or REPLACE PROCEDURE addPHIEUMUON
(cm in PHIEUMUON.cmnd%type,
ms in PHIEUMUON.masach%type,
mnv in PHIEUMUON.manv%type,
nbd in PHIEUMUON.ngaybd%type,
nkt in PHIEUMUON.ngaykt%type,
tt in PHIEUMUON.tongtien%type)

      is
      BEGIN 
           set TRANSACTION ISOLATION LEVEL read COMMITTED;
           insert into PHIEUMUON values (cm,ms,mnv,nbd,nkt,tt);
           update SACH set soluong = soluong - 1 where masach=ms;
      END;
      
--chay
EXECUTE addPHIEUMUON('0016','S001','NV001','26-11-2020',sysdate,'100000'); -- commit
select * from PHIEUMUON;
select * from SACH;



--ACCOUNT_USER--ACCOUNT_ADMIN--DIACHI--KHACH--THE--TACGIA--CHUCVU--SACH--NHANVIEN--PHIEUMUON--

--------------------------------------------------======sua=================-------------------------------------------
--------------------------- sua ACCOUNT_ADMIN --------------------------------
create or REPLACE PROCEDURE suaACCOUNT_ADMIN 
(u in ACCOUNT_ADMIN.userName%type,
p in ACCOUNT_ADMIN.pass%type)

is
begin
 update ACCOUNT_ADMIN set pass=p where username=u;
end;

--chay
exec suaACCOUNT_ADMIN('Bao','123')
select * from ACCOUNT_ADMIN;

------------------------------- sua account_user -----------------------------
create or REPLACE PROCEDURE suaACCOUNT_USER 
(cm in account_user.cmnd%type,
ps in account_user.pass%type)

IS
BEGIN
   update  account_user set pass=ps where cmnd=cm;
END;

--chay
EXECUTE suaACCOUNT_USER('thu2','123');
select * from account_user;

--------------------------------- sua khach ------------------------------------
create or REPLACE PROCEDURE suaKHACH
(cm in khach.cmnd%type,
t in KHACH.ten%type,
ns in khach.ngaySinh%type,
gt in KHACH.gioitinh%type,
dc in khach.tendc%type,
dt in KHACH.dienthoai%type)

      IS
      BEGIN
          update KHACH set ten=t,ngaySinh=ns,gioitinh=gt,tendc=dc,dienthoai=dt where cmnd=cm;
      END ;
      
--chay
EXECUTE suaKHACH('thu2','bao','1/1/2001','nam', N'Tây Ninh','08888');
select * from KHACH;

--------------------------------- sua THE --------------------------------------
create or REPLACE PROCEDURE suaTHE
(mt in THE.mathe%type,
nc in THE.ngaycap%type,
lt in THE.loaithe%type,
cm in THE.cmnd%type)

      IS
      BEGIN
          update THE set ngaycap=nc,loaithe=lt,cmnd=cm where  mathe=mt;
      END ;
      
--chay
EXECUTE suaTHE(kcthe.nextval,'1/1/2020',N'Ð?c','thu2');
select * from THE;

--------------------------------------- sua TACGIA -----------------------------
create or REPLACE PROCEDURE suaTACGIA
(mt in TACGIA.matg%type,
ttg in TACGIA.tentg%type)

      IS
      BEGIN
          update TACGIA set tentg=ttg where  matg=mt;
      END ;
      
--chay
EXECUTE suaTACGIA('tg11',N'Pham gia bao bede');
select * from TACGIA;

---------------------------------- sua CHUCVU ----------------------------------
create or REPLACE PROCEDURE suaCHUCVU
(mcv in CHUCVU.macv%type,
tcv in CHUCVU.tencv%type)

      IS
      BEGIN
          update CHUCVU set tencv=tcv where  macv=mcv;
      END ;
      
--chay
EXECUTE suaCHUCVU('cvnn',N'Con ch? t?ch');
select * from CHUCVU;


-------------------------------- sua SACH -------------------------------------
create or REPLACE PROCEDURE suaSACH
(ms in sach.masach%type,
ts in sach.tensach%type,
mtg in sach.maTG%type,
nxb in sach.namxb%type,
gs in sach.giasach%type,
sl in sach.soluong%type)

is
BEGIN
    update sach set tensach=ts,maTG=mtg,namxb=nxb,giasach=gs,soluong=sl  where  masach=ms;
END ;

--chay
EXECUTE suaSACH('stest', N'Không bi?t ð?t tên g?', 'AK', '2013', '100000', '15');
select * from SACH;

---------------------------------- sua NHANVIEN --------------------------------
create or REPLACE PROCEDURE suaNHANVIEN
(mnv in NHANVIEN.manv%type,
t in NHANVIEN.tennv%type,
mcv in NHANVIEN.macv%type,
gt in NHANVIEN.gioitinh%type,
ns in NHANVIEN.namsinh%type,
dc in NHANVIEN.tendc%type,
dt in NHANVIEN.dienthoai%type,
l in NHANVIEN.luong%type)

      IS
      BEGIN
           update NHANVIEN set tennv=t,macv=mcv,gioitinh=gt,namsinh=ns,tendc=dc,dienthoai=dt,luong=l  where  manv=mnv;
      END ;
      
--chay
EXECUTE suaNHANVIEN('nvthu', 'bao', 'TT', 'Nam', '1/1/2001', N'TP. H? Chí Minh', '0555', '568888');
select * from NHANVIEN;

------------------------------ sua PHIEUMUON -----------------------------------
create or REPLACE PROCEDURE suaPHIEUMUON
(cm in PHIEUMUON.cmnd%type,
ms in PHIEUMUON.masach%type,
mnv in PHIEUMUON.manv%type,
nbd in PHIEUMUON.ngaybd%type,
nkt in PHIEUMUON.ngaykt%type,
tt in PHIEUMUON.tongtien%type)

      is
      BEGIN 
            update PHIEUMUON set ngaybd=nbd,ngaykt=nkt,tongtien=tt  where  cmnd=cm and masach=ms and manv=mnv;
      END ;
      
--chay
EXECUTE suaPHIEUMUON('0015','S001','NV001',sysdate,'26-11-2022','100000');
select * from PHIEUMUON;
select * from SACH;



--ACCOUNT_USER--ACCOUNT_ADMIN--DIACHI--KHACH--THE--TACGIA--CHUCVU--SACH--NHANVIEN--PHIEUMUON--
--------------------------------------------------======xoa=================-------------------------------------------
--------------------------- xoa ACCOUNT_ADMIN --------------------------------
create or REPLACE PROCEDURE xoaACCOUNT_ADMIN
(u in ACCOUNT_ADMIN.userName%type)

is
begin
delete ACCOUNT_ADMIN where username=u;
end;

--chay
exec xoaACCOUNT_ADMIN('Bao')
select * from ACCOUNT_ADMIN;

---------------------------- xoa account_user --------------------------------
create or REPLACE PROCEDURE xoaACCOUNT_USER 
(cm in account_user.cmnd%type)

IS
BEGIN
   delete account_user where cmnd = cm;
END;

-- chay
EXECUTE xoaACCOUNT_USER('thu');
select * from account_user;

---------------------------------- xoa khach ----------------------------------
create or REPLACE PROCEDURE xoaKHACH
(cm in khach.cmnd%type)

      IS
      BEGIN
          delete KHACH  where cmnd = cm;
      END ;
      
--chay
EXECUTE xoaKHACH('thu2');
select * from KHACH;

---------------------------------- xoa THE -------------------------------------
create or REPLACE PROCEDURE xoaTHE
(mt in THE.mathe%type)

      IS
      BEGIN
          delete THE where  mathe=mt;
      END ;
      
--chay
EXECUTE xoaTHE('71');
select * from THE;

-------------------------------- xoa TACGIA ------------------------------------
create or REPLACE PROCEDURE xoaTACGIA
(mt in TACGIA.matg%type)

      IS
      BEGIN
          delete TACGIA  where  matg=mt;
      END ;
      
--chay
EXECUTE xoaTACGIA('tg11');
select * from TACGIA;

------------------------------ xoa CHUCVU --------------------------------------
create or REPLACE PROCEDURE xoaCHUCVU
(mcv in CHUCVU.macv%type)

      IS
      BEGIN
          delete CHUCVU where  macv=mcv;
      END ;
      
--chay
EXECUTE xoaCHUCVU('cvnn2');
select * from CHUCVU;


------------------------------- xoa SACH ---------------------------------------
create or REPLACE PROCEDURE xoaSACH
(ms in sach.masach%type)

is
BEGIN
    delete  sach  where  masach=ms;
END ;

--chay
EXECUTE xoaSACH('stest');
select * from SACH;

------------------------------ xoa NHANVIEN ------------------------------------
create or REPLACE PROCEDURE xoaNHANVIEN
(mnv in NHANVIEN.manv%type)

      IS
      BEGIN
           delete  NHANVIEN   where  manv=mnv;
      END ;
      
--chay
EXECUTE xoaNHANVIEN('nvthu');
select * from NHANVIEN;

--------------------------------- xoa PHIEUMUON --------------------------------
create or REPLACE PROCEDURE xoaPHIEUMUON
(cm in PHIEUMUON.cmnd%type,
ms in PHIEUMUON.masach%type,
mnv in PHIEUMUON.manv%type)

      is
      BEGIN 
            set TRANSACTION ISOLATION LEVEL read COMMITTED;
            delete  PHIEUMUON where cmnd=cm and masach=ms and manv=mnv;
            update SACH set soluong = soluong + 1 where masach=ms;
            commit;
      END ;
      
--chay
EXECUTE xoaPHIEUMUON('0016','S001','NV001');
select * from PHIEUMUON;
select * from SACH;



--ACCOUNT_USER--ACCOUNT_ADMIN--DIACHI--KHACH--THE--TACGIA--CHUCVU--SACH--NHANVIEN--PHIEUMUON--
-------------------========================================timkiem==============-----------------
-------------------------------timkiem ACCOUNT_USER------
---------------------------timkiem ACCOUNT_USER --------------------------------
create or REPLACE PROCEDURE timkiemACCOUNT_USER
(tk nvarchar2,
c out ACCOUNT_USER.cmnd%type,
p out ACCOUNT_USER.pass%type)

is
begin
 for acu in (select * from ACCOUNT_USER where CMND like tk)
 loop
   dbms_output.put_line(acu.cmnd||''||acu.pass);
 end loop;
end ;

--chay 
declare
ia  sys.ACCOUNT_USER.cmnd%type;
ib  sys.ACCOUNT_USER.pass%type;
begin
 timkiemACCOUNT_USER('%%',ia,ib);
end;


------------------------------------ timkiem SACH -------------------
create or REPLACE PROCEDURE timkiemSACH
(tk nvarchar2,
a out SACH%rowtype)

is
begin
 for inra in (select * from SACH where (Masach like tk) or (tensach like tk) or (matg like tk) 
or (namxb like tk) or (giasach like tk) or (soluong like tk))
 loop
   dbms_output.put_line(inra.maSach||''||inra.tenSach||''||inra.maTG||''||inra.namXB||''||inra.giaSach||''||inra.soLuong);
 end loop;
end ;

--chay 
declare
ia  sys.SACH%rowtype;
begin
 timkiemSACH('%S0%',ia);
end;

------------------------------------ timkiem NHANVIEN --------------------------
create or REPLACE PROCEDURE timkiemNHANVIEN 
(tk nvarchar2,
a out NHANVIEN%rowtype)

is
begin
 for inra in (select * from NHANVIEN where (manv like tk) or (Tennv like tk) or (macv like tk) or 
(gioitinh like tk) or (namsinh like tk) or (tendc like tk) or (dienthoai like tk) or 
(luong like tk))
 loop
   dbms_output.put_line(inra.maNV||''||inra.tenNV||''||inra.maCV||''||inra.gioiTinh||''||inra.namSinh||''||inra.tenDC||''||inra.dienThoai||''||inra.dienThoai);
 end loop;
end ;

--chay 
declare
ia  sys.NHANVIEN%rowtype;
begin
 timkiemNHANVIEN('%NV01%',ia);
end;


------------------------------------ in database -------------------------------
create or REPLACE PROCEDURE indatabase 
is
begin
 for ira in (select name,created,Log_mode,controlfile_time,open_mode from v$database)
 loop
   dbms_output.put_line(ira.name||''||ira.created||''||ira.Log_mode||''||ira.controlfile_time||''||ira.open_mode);
 end loop;
end ;

--chay 
exec indatabase;

------------------------------------ in datafile -------------------------------

create or REPLACE PROCEDURE indatafile 

is
begin
 for ira in (select file_name, file_id, tablespace_name, status, bytes,maxbytes from dba_data_files)
 loop
   dbms_output.put_line(ira.file_name||''||ira.file_id||''||ira.tablespace_name||''||ira.status||''||ira.bytes
   ||''||ira.maxbytes);
 end loop;
end ;

--chay 
exec indatafile;

------------------------------------ in instance -------------------------------
create or REPLACE PROCEDURE ininstance 

is
begin
 for ira in (select instance_name,host_name,startup_time,status from sys.v$instance)
 loop
   dbms_output.put_line(ira.instance_name||''||ira.host_name||''||ira.startup_time||''||ira.status);
 end loop;
end ;

--chay 
exec ininstance;

------------------------------------ in dba_tab_privs --------------------------
set serverout on size unlimited
create or REPLACE PROCEDURE inprivs 

is
begin
 for ira in (SELECT grantee, owner, table_name, grantor, privilege, grantable, type FROM sys.dba_tab_privs)
 loop
   dbms_output.put_line(ira.grantee||' '||ira.owner||' '||ira.table_name||' '||
   ira.grantor||' '||ira.privilege||' '||ira.grantable||' '||ira.type);
 end loop;
end ;
--chay 
exec inprivs;

------------------------------------ in parameter ------------------------------
create or REPLACE PROCEDURE inparameter 

is
begin
 for ira in (select num,name,type,value,display_value,default_value from sys.v$parameter)
 loop
   dbms_output.put_line(ira.num||''||ira.name||''||ira.type||''||
   ira.value||''||ira.display_value||''||ira.default_value);
 end loop;
end ;
--chay 
exec inparameter;

------------------------------------in v$process-------------------
create or REPLACE PROCEDURE inprocess

is
begin
 for ira in (select ADDR,PNAME,USERNAME,TERMINAL,PROGRAM,TRACEFILE from v$process)
 loop
   dbms_output.put_line(ira.ADDR||''||ira.PNAME||''||ira.USERNAME||''||
   ira.TERMINAL||''||ira.PROGRAM||''||ira.TRACEFILE);
 end loop;
end ;
--chay 
exec inprocess;


------------------------------------ in dba_profiles ---------------------------
create or REPLACE PROCEDURE inprofiles
is
begin
 for ira in (select * from sys.dba_profiles)
 loop
   dbms_output.put_line(ira.profile||''||ira.resource_name||''||ira.resource_type||''||
   ira.limit||''||ira.common);
 end loop;
end ;
--chay 
exec inprofiles;

------------------------------------ in dba_roles ------------------------------
create or REPLACE PROCEDURE inroles 

is
begin
 for ira in (select * from sys.dba_roles)
 loop
   dbms_output.put_line(ira.role||''||ira.password_required||''||ira.authentication_type||''||
   ira.common||''||ira.oracle_maintained);
 end loop;
end ;

--chay 
exec inroles;

------------------------------------ in session --------------------------------
create or REPLACE PROCEDURE insession 

is
begin
 for ira in (select s.sid,s.serial#,s.username,s.program,p.terminal,p.tracefile from v$session s,v$process p where s.paddr=p.addr and s.type !='BACKGROUND')
 loop
   dbms_output.put_line(ira.sid||''||ira.serial#||''||ira.program||''||
   ira.terminal||''||ira.tracefile);
 end loop;
end ;
--chay 
exec insession;

------------------------------------ in DBA_SYS_PRIVS --------------------------
create or REPLACE PROCEDURE inDBA_SYS_PRIVS

is
begin
 for ira in (SELECT * FROM DBA_SYS_PRIVS)
 loop
   dbms_output.put_line(ira.grantee||''||ira.privilege||''||ira.admin_option||''||
   ira.common);
 end loop;
end ;

--chay 
exec inDBA_SYS_PRIVS;


------------------=====================timkiemSYS------------------
---------------------------timkiem database --------------------------------
create or REPLACE PROCEDURE timkiemdatabase 
(tk nvarchar2,
a out sys.v$database%rowtype)

is
begin
 for ira in (select name,created,Log_mode,controlfile_time,open_mode
from sys.v$database where (name like tk) or (created like tk) or 
(Log_mode like tk) or (controlfile_time like tk) or (open_mode like tk))
 loop
   dbms_output.put_line(ira.name||''||ira.created||''||ira.Log_mode||''||ira.controlfile_time||''||ira.open_mode);
 end loop;
end ;
--chay 
declare
ia  sys.v$database%rowtype;
begin
 timkiemdatabase('%%',ia);
end;

--------------------------- timkiem dba_data_files -----------------------------
create or REPLACE PROCEDURE timkiemdba_data_files
(tk nvarchar2,
a out sys.dba_data_files%rowtype)

is
begin
 for ira in (select file_name, file_id, tablespace_name, status, bytes, maxbytes 
from sys.dba_data_files where (file_name like tk) or (file_id like tk) or 
(tablespace_name like tk) or (status like tk)
 or (bytes like tk) or (maxbytes like tk))
 loop
   dbms_output.put_line(ira.file_name||''||ira.file_id||''||ira.tablespace_name||''||ira.status||''||ira.bytes
   ||''||ira.maxbytes);
 end loop;
end ;

--chay 
declare
ia  sys.dba_data_files%rowtype;
begin
 timkiemdba_data_files('%%',ia);
end;

------------------------------ timkiem instance --------------------------------
create or REPLACE PROCEDURE timkieminstance
(tk nvarchar2,
a out sys.v$instance%rowtype)

is
begin
 for ira in (select instance_name,host_name,startup_time,status 
from sys.v$instance where (instance_name like tk) or  (host_name like tk) or 
 (startup_time like tk) or  (status like tk))
 loop
   dbms_output.put_line(ira.instance_name||''||ira.host_name||''||ira.startup_time||''||ira.status);
 end loop;
end ;

--chay 
declare
ia  sys.v$instance%rowtype;
begin
 timkieminstance('%%',ia);
end;

--------------------------- timkiem objpermission ------------------------------
create or REPLACE PROCEDURE timkiemobjpermission
(tk nvarchar2,
a out sys.dba_tab_privs%rowtype)

is
begin
 for ira in (SELECT grantee, owner, table_name, grantor, privilege, grantable, type FROM sys.dba_tab_privs
where (grantee like tk) or (owner like tk) or 
(table_name like tk) or (grantor like tk) or 
(privilege like tk) or (grantable like tk) or 
(type like tk))
 loop
   dbms_output.put_line(ira.grantee||''||ira.owner||''||ira.table_name||''||
   ira.grantor||''||ira.privilege||''||ira.grantable||''||ira.type);
 end loop;
end ;

--chay 
declare
ia  sys.dba_tab_privs%rowtype;
begin
 timkiemobjpermission('%SYSTEM_PRIVILEGE_MAP%',ia);
end;

--------------------------- timkiem parameter --------------------------------
create or REPLACE PROCEDURE timkiemparameter
(tk nvarchar2,
a out v$parameter%rowtype)

is
begin
 for ira in (select num,name,type,value,display_value,default_value from sys.v$parameter
where (num like tk) or (name like tk) or 
(type like tk) or (value like tk) or 
(display_value like tk) or (default_value like tk))
 loop
   dbms_output.put_line(ira.num||''||ira.name||''||ira.type||''||
   ira.value||''||ira.display_value||''||ira.default_value);
 end loop;
end ;

--chay 
declare
ia  sys.v$parameter%rowtype;
begin
 timkiemparameter('%%',ia);
end;

--------------------------- timkiem v$process --------------------------------
create or REPLACE PROCEDURE timkiemprocess
(tk nvarchar2,
a out sys.v$process%rowtype)

is
begin
 for ira in (select ADDR,PNAME,USERNAME,TERMINAL,PROGRAM,TRACEFILE from sys.v$process
where (ADDR like tk) or (PNAME like tk) or 
(USERNAME like tk) or (TERMINAL like tk) or 
(PROGRAM like tk) or (TRACEFILE like tk))
 loop
   dbms_output.put_line(ira.ADDR||''||ira.PNAME||''||ira.USERNAME||''||
   ira.TERMINAL||''||ira.PROGRAM||''||ira.TRACEFILE);
 end loop;
end ;

--chay 
declare
ia  sys.v$process%rowtype;
begin
 timkiemprocess('%%',ia);
end;

--------------------------- timkiem dba_profiles -------------------------------
create or REPLACE PROCEDURE timkiemdba_profiles
(tk nvarchar2,
a out sys.dba_profiles%rowtype)

is
begin
 for ira in (select * from sys.dba_profiles where (profile like tk) or 
(resource_name like tk) or (resource_type like tk) or 
(limit like tk) or (common like tk) )
 loop
   dbms_output.put_line(ira.profile||''||ira.resource_name||''||ira.resource_type||''||
   ira.limit||''||ira.common);
 end loop;
end ;

--chay 
declare
ia  sys.dba_profiles%rowtype;
begin
 timkiemdba_profiles('%%',ia);
end;

---------------------------timkiem rightgroup --------------------------------
create or REPLACE PROCEDURE timkiemrightgroup
(tk nvarchar2,
a out sys.dba_roles%rowtype)

is
begin
 for ira in (select * from sys.dba_roles where (role like tk) or 
(password_required like tk) or (authentication_type like tk) or 
(common like tk) or (oracle_maintained like tk))
 loop
   dbms_output.put_line(ira.role||''||ira.password_required||''||ira.authentication_type||''||
   ira.common||''||ira.oracle_maintained);
 end loop;
end ;

--chay 
declare
ia  sys.dba_roles%rowtype;
begin
 timkiemrightgroup('%%',ia);
end;

------------------------------- timkiem session --------------------------------
create or REPLACE PROCEDURE timkiemsession
(tk nvarchar2,
a out sys.v$session%rowtype)

is
begin
 for ira in (select s.sid,s.serial#,s.username,s.program,p.terminal,p.tracefile 
from sys.v$session s,v$process p where (s.paddr=p.addr and s.type !='BACKGROUND') and ((s.sid like tk) or 
(s.serial# like tk) or (s.username like tk) or 
(s.program like tk) or (p.terminal like tk) or 
(p.tracefile  like tk)))
 loop
   dbms_output.put_line(ira.sid||''||ira.serial#||''||ira.program||''||
   ira.terminal||''||ira.tracefile);
 end loop;
end ;

--chay 
declare
ia  sys.v$session%rowtype;
begin
 timkiemsession('%%',ia);
end;

---------------------------timkiem syspremission --------------------------------
create or REPLACE PROCEDURE timkiemsyspremission
(tk nvarchar2,
a out sys.DBA_SYS_PRIVS%rowtype)

is
begin
 for ira in (SELECT * FROM sys.DBA_SYS_PRIVS where (grantee like tk) or 
(privilege like tk) or (grantee like tk) or 
(common like tk))
 loop
   dbms_output.put_line(ira.grantee||''||ira.privilege||''||ira.admin_option||''||
   ira.common);
 end loop;
end ;

--chay 
declare
ia  sys.DBA_SYS_PRIVS%rowtype;
begin
 timkiemsyspremission('%%',ia);
end;

------------------------------- kill session -------------------------------
select sid,serial#,username,program from v$session where type!='BACKGROUND';
create or REPLACE PROCEDURE cnkillsession
(a in sys.v$session.sid%type,
b in sys.v$session.serial#%type)

is
s varchar2(500);
begin
 s:= 'alter system kill session '''|| a ||','|| b ||''' ';
 EXECUTE IMMEDIATE (s);
 commit;
end;

exec cnkillsession('138','64265')
select * from employees;

alter system kill session '326,1127';


----------------------- chuc nang ngay hien tai --------------------------------
create or REPLACE PROCEDURE cnNgayHienTai(a out varchar2)
is
begin
 select to_char(sysdate, 'fmDD/mm/YYYY - hh24:mi:ss') 
 as NgayHienTai into a 
 from dual;
 
 dbms_output.put_line(a);
end ;

--chay 
declare
ia  varchar2(50);
begin
 cnNgayHienTai(ia);
end;

-------------------------------- tao -------------------------------------------
create or REPLACE PROCEDURE taouser
(u in sys.dba_users.username%type,
p in sys.dba_users.password%type,
t in sys.dba_users.default_tablespace%type,
qt in varchar,
pf in sys.dba_users.profile%type, 
r in sys.dba_roles.role%type)

is
s varchar2(1000);
x varchar2(1000);
begin
    s:='create user '|| u || ' identified by ' || p || ' default tablespace ' || t|| ' quota ' || qt || 'M on ' || t || ' profile ' || pf;
    EXECUTE IMMEDIATE (s);
    x:='grant ' || r || ' to ' || u;
    EXECUTE IMMEDIATE (x);
    commit;
end;

exec taouser('test1','test1','vidu','2','QUANLY','hihi')

-------------------------------------- sua user --------------------------------
create or REPLACE PROCEDURE suauser
(u in sys.dba_users.username%type,
p in sys.dba_users.password%type,
t in sys.dba_users.default_tablespace%type,
qt in varchar,
pf in sys.dba_users.profile%type, 
r in sys.dba_roles.role%type)

is
s varchar2(1000);
x varchar2(1000);
begin
    s:='alter user '|| u || ' identified by ' || p || ' default tablespace ' || t|| ' quota ' || qt || 'M on ' || t || ' profile ' || pf;
    EXECUTE IMMEDIATE (s);
    x:='grant ' || r || ' to ' || u;
    EXECUTE IMMEDIATE (x);
    commit;
end;

------------------------------------- xoa --------------------------------------
create or REPLACE PROCEDURE xoauser
(u in sys.dba_users.username%type)

is
s varchar2(1000);

begin
    s:='drop user '|| u;
    EXECUTE IMMEDIATE (s);
    commit;
end;

exec xoauser('test110')
select * from view_taouser

------------------------------------- khoa user --------------------------------
create or REPLACE PROCEDURE khoauser
(u in sys.dba_users.username%type)

is
s varchar2(1000);
begin
    s:='alter user '|| u || ' ACCOUNT LOCK ';
    EXECUTE IMMEDIATE (s);
    commit;
end;

exec khoauser('nv3');
select * from view_taouser

--------------------------------- mo khoa user ---------------------------------
create or REPLACE PROCEDURE mokhoauser
(u in sys.dba_users.username%type)
is
s varchar2(1000);
begin
    s:='alter user '|| u || ' ACCOUNT unLOCK ';
    EXECUTE IMMEDIATE (s);
    commit;
end;

exec mokhoauser('nv3')
select * from view_taouser;

create or replace procedure tao_profile 
(a in varchar, b in number, c in number, d in number, e in number)
is
s varchar(1000);
begin
     s:='create profile '|| a ||' limit password_life_time '|| b ||' failed_login_attempts '|| c || ' PASSWORD_LOCK_TIME ' || d ||' PASSWORD_REUSE_MAX '|| e;
     EXECUTE IMMEDIATE (s);      -- thgian sd toi da (d)                -- sai mk toi da (l)       -- thigan khoa tk (d)           -- doi mk toi da (l)
end;

exec tao_profile('hehe','30','3','3','3')

-- Xoa profile -----------------------------------------------------------------
create or replace procedure xoa_profile (a in varchar)
is
s varchar(1000);
begin
     s:='drop profile ' || a || ' cascade';
     EXECUTE IMMEDIATE (s);
end;

exec xoa_profile ('hehe')

-- Sua profile -----------------------------------------------------------------
-- sua tablespace --------------------------------------------------------------
create or replace procedure sua_profile (a in varchar,b in varchar,c in number, d in number, e in number )
is
s varchar(1000);
begin
     s:='alter profile '|| a ||' limit password_life_time '|| b ||' 
     failed_login_attempts '|| c || ' PASSWORD_LOCK_TIME ' || d ||' PASSWORD_REUSE_MAX '|| e;
     EXECUTE IMMEDIATE (s);
end;

exec sua_profile('hihi','60','3','3','3');

create or replace procedure tao_tablespace (a in varchar,b in varchar,c in number, d in number, e in number )
is
s varchar(1000);
begin                                           -- browns
     s:='create tablespace '|| a ||' datafile ''D:\Tablespace_VD\'|| b 
     ||'.DBF'' size '|| c ||'M Autoextend On Next '|| d ||'K Maxsize '|| e ||'M';
     EXECUTE IMMEDIATE (s);
end;

exec tao_tablespace('teo','koeo','10','500','15')

-- sua tablespace --------------------------------------------------------------
create or replace procedure sua_tablespace (a in varchar,b in varchar,c in number, d in number, e in number )
is
s varchar(1000);
begin
     s:='alter tablespace '|| a ||' add datafile ''D:\Tablespace_VD\'|| b 
     ||'.DBF'' size '|| c ||'M Autoextend  On Next '|| d ||'K Maxsize '|| e ||'M';
     EXECUTE IMMEDIATE (s);
end;

exec sua_tablespace('teo','koeo1','10','500','15');

-- xoa tablespace --------------------------------------------------------------
create or replace procedure xoa_tablespace (a in varchar)
is
s varchar(1000);
begin
     s:='drop tablespace ' || a || ' including contents and datafiles';
     EXECUTE IMMEDIATE (s);
end;

select * from dba_data_files;
exec xoa_tablespace('teo');

--tao policy-------------------------------------------------------------------
create or replace procedure taopolicy(a in varchar,b in varchar,c in varchar,d in varchar)
is
begin
dbms_fga.add_policy(
    object_schema=>a,--tren user hr
    object_name=>b,--tren bang emplyees
    policy_name=>c,--ten cua policy
    statement_types=>d--cac lenh giam xac
);
end;

exec taopolicy('hr','countries','hihi','select')

SELECT * from dba_audit_policies;  --xem thong tin so luong policy da dat
select * from dba_fga_audit_trail; --giam giam hoat dong cua audit

--xoa policy--------------------------------------------------------------------
create or replace procedure xoapolicy(a in varchar,b in varchar,c in varchar)
is
begin
dbms_fga.drop_policy(
    object_schema=>a,--tren user hr
    object_name=>b,--tren bang emplyees
    policy_name=>c--ten cua policy
);
end;

exec xoapolicy('hr','countries','HIHI')
 
  --tat policy------------------------------------------------------------------
create or replace procedure tatpolicy(a in varchar,b in varchar,c in varchar)
is
begin
dbms_fga.disable_policy(
    object_schema=>a,--tren user hr
    object_name=>b,--tren bang emplyees
    policy_name=>c--ten cua policy
);
end;

exec tatpolicy('hr','countries','hihi')

--bat policy--------------------------------------------------------------------
create or replace procedure batpolicy(a in varchar,b in varchar,c in varchar)
is
begin
dbms_fga.enable_policy(
    object_schema=>a,--tren user hr
    object_name=>b,--tren bang emplyees
    policy_name=>c--ten cua policy
);
end;

exec batpolicy('hr','countries','hihi') ;

--gan quyen---------------------------------------------------------------------
create or replace procedure taoganquyenhethong(a in varchar,b in varchar,c in varchar)
as
s varchar(1000);
begin
     s:='grant '|| a ||' to '|| b ||' '|| c;
     EXECUTE IMMEDIATE(s);
end;

exec taoganquyenhethong('create session','nv2','with admin option');
exec taoganquyenhethong('create session','nv2','');

--thu hoi-----------------------------------------------------------------------
create or replace procedure thuhoiganquyenhethong(a in varchar,b in varchar)
as
s varchar(1000);
begin
     s:='revoke '|| a ||' from '|| b ;
     EXECUTE IMMEDIATE(s);
end;

exec thuhoiganquyenhethong('create session','nv2');

--tao nhom quyen----------------------------------------------------------------
create or replace procedure taognhomquyen(a in varchar,b in varchar,c in varchar)
as
v varchar(1000);
s varchar(1000);
begin
--set TRANSACTION ISOLATION LEVEL SERIALIZABLE;
     v:='CREATE ROLE '|| a;
     execute immediate(v);
     commit;
     s:='grant '|| b ||' to '|| a ||' '|| c;
     EXECUTE IMMEDIATE(s);
     commit;
end;

exec taognhomquyen('KHACHHANG','create session','with admin option')

--them quyen vao nhom quyen-----------------------------------------------------
create or replace procedure themquyenvaonhomquyen(a in varchar,b in varchar,c in varchar)
as
s varchar(1000);
begin
     s:='grant '|| b ||' to '|| a ||' '|| c;
     EXECUTE IMMEDIATE(s);
end;

exec themquyenvaonhomquyen('KHACHHANG', 'select on sys.ACCOUNT_USER', 'with admin option')

grant select on sys.KHACH to KHACHHANG;
grant select on sys.ACCOUNT_USER to KHACHHANG;
grant select on sys.SACH to KHACHHANG;
grant connect to KHACHHANG;
grant create session to KHACHHANG;

--xoa nhom quyen----------------------------------------------------------------
create or replace procedure xoanhomquyen(a in varchar)
as
s varchar(1000);
begin
     s:='drop role '|| a;
     EXECUTE IMMEDIATE(s);
end;

exec xoanhomquyen('SOMETHING');


--gan quyen cho user------------------------------------------------------------
create or replace procedure gannhomquyenchouser(a in varchar,b in varchar)
as
s varchar(1000);
begin
     s:='grant '|| a ||' to '|| b;
     EXECUTE IMMEDIATE(s);
end;

exec gannhomquyenchouser('KHACHHANG','kh1_02_bao');

--thu hoi quyen cho user--------------------------------------------------------
create or replace procedure thuhoinhomquyenchouser(a in varchar,b in varchar)
as
s varchar(1000);
begin
     s:='revoke '|| a ||' from '|| b;
     EXECUTE IMMEDIATE(s);
end;

exec thuhoinhomquyenchouser('nhomt12','NV2');

--------------------------------------------------------------------------------
create or REPLACE PROCEDURE lastLogin
(u in sys.dba_users.username%type)
is
s varchar2(1000);
begin
    s:='select last_login from dba_users where username = ' || u;
    EXECUTE IMMEDIATE (s);
    commit;
end;

set serveroutput on
select last_login from dba_users where username = 'ADMINISTRATOR';
exec lastLogin ('ADMINISTRATOR')

select * from dba_users;

----------------------------------- xoa datafile -------------------------------
