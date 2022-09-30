-------------------------------- View ung dung ---------------------------------
-- in diachi -------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inDiaChi 
AS 
select tenDC  
from sys.DIACHI;

-- Thuc thi
select * from view_inDiaChi;

-- in ACCOUNT_ADMIN ------------------------------------------------------------
CREATE OR REPLACE VIEW view_inACCOUNT_ADMIN 
AS select * 
from sys.ACCOUNT_ADMIN;

select * from view_inACCOUNT_ADMIN;

-- in ACCOUNT_USER -------------------------------------------------------------
CREATE OR REPLACE VIEW view_inACCOUNT_USER 
AS select * 
from sys.ACCOUNT_USER;

select * from view_inACCOUNT_USER;

-- in KHACH --------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inKHACH 
AS select * 
from sys.KHACH;

select * from view_inKHACH;

-- in THE ----------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inTHE 
AS select * 
from sys.THE;

select * from view_inTHE;

-- in TACGIA -------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inTACGIA 
AS select * 
from sys.TACGIA;

select * from view_inTACGIA;

-- in CHUCVU -------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inCHUCVU 
AS select * 
from sys.CHUCVU;

select * from view_inCHUCVU;

-- in SACH ---------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inSACH 
AS select * 
from sys.SACH;

select * from view_inSACH;

-- in NHANVIEN -----------------------------------------------------------------
CREATE OR REPLACE VIEW view_inNHANVIEN 
AS select * 
from sys.NHANVIEN;

select * from view_inNHANVIEN;

-- in PHIEUMUON ----------------------------------------------------------------
CREATE OR REPLACE VIEW view_inPHIEUMUON 
AS select * 
from sys.PHIEUMUON;

select * from view_inPHIEUMUON;

-- in ma TACGIA (Dung cho combobox) --------------------------------------------
CREATE OR REPLACE VIEW view_inmaTACGIA 
AS select matg 
from sys.TACGIA;

select * from view_inmaTACGIA;

-- in ma Thong ke --------------------------------------------------------------
CREATE OR REPLACE VIEW view_inThongKe
AS select session_id, db_user, object_schema, object_name, policy_name, sql_text, statement_type  
from sys.dba_fga_audit_trail;

select * from view_inThongKe;

-- kiem tra khoa chinh sach có ton tai khong -----------------------------------
CREATE OR REPLACE VIEW view_ktPKmasach 
AS select count(*) as soluong 
from sys.SACH where maSach = 'S001';

select soluong from view_ktPKmasach ;

---------------------------------==========================SYS==============----------------
-----------------------------==============view sys=========--------------------------------------
--in v$database-----------------------------------------------------------------
CREATE OR REPLACE VIEW view_indatabase 
AS select name,created,Log_mode,controlfile_time,open_mode 
from sys.v$database;

select * from view_indatabase;

--in dba_data_files-------------------------------------------------------------
CREATE OR REPLACE VIEW view_indatafile 
AS select file_name, file_id, tablespace_name, status, bytes,maxbytes from sys.dba_data_files;

select * from view_indatafile

--in v$instance-----------------------------------------------------------------
CREATE OR REPLACE VIEW view_ininstance 
AS select instance_name,host_name,startup_time,status from sys.v$instance;

select * from view_ininstance;

--in dba_tab_privs--------------------------------------------------------------
CREATE OR REPLACE VIEW view_inprivs 
AS SELECT grantee, owner, table_name, grantor, privilege, grantable, type FROM sys.dba_tab_privs;

select * from view_inprivs

--in v$parameter----------------------------------------------------------------
CREATE OR REPLACE VIEW view_inparameter 
AS select num,name,type,value,display_value,default_value 
from sys.v$parameter;

select * from view_inparameter

--in v$process------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inprocess 
AS select ADDR,PNAME,USERNAME,TERMINAL,PROGRAM,TRACEFILE 
from sys.v$process;

select * from view_inprocess

--in dba_profiles---------------------------------------------------------------
CREATE OR REPLACE VIEW view_inprofiles 
AS select * from sys.dba_profiles;

select * from view_inprofiles

--in dba_roles------------------------------------------------------------------
CREATE OR REPLACE VIEW view_inroles
AS select * from sys.dba_roles;

select * from view_inroles

--in v$session------------------------------------------------------------------
CREATE OR REPLACE VIEW view_insession
AS select s.sid,s.serial#,s.username,s.program,p.terminal,p.tracefile 
from v$session s,v$process p where s.paddr=p.addr and s.type !='BACKGROUND';

select * from view_insession

--DBA_SYS_PRIVS-----------------------------------------------------------------
CREATE OR REPLACE VIEW view_inDBA_SYS_PRIVS
AS SELECT * 
FROM DBA_SYS_PRIVS;

select * from view_inDBA_SYS_PRIVS


---ten combobox bang syspermission----------------------------------------------
CREATE OR REPLACE VIEW view_cbb_syspermission 
as SELECT unique privilege 
FROM DBA_SYS_PRIVS;

select * from view_cbb_syspermission

--ngay hien tai-----------------------------------------------------------------
CREATE OR REPLACE VIEW view_ngayhientai 
as select to_char(sysdate, 'fmDD/mm/YYYY - hh24:mi:ss') as NgayHienTai 
from dual;

select * from view_ngayhientai;

---------------------------==========tao user==========-------------------------
select * from DBA_SYS_PRIVS where grantee='test123';
select * from sys.dba_roles

-- ten profile------------------------------------------------------------------
create or REPLACE view view_tenprofile 
as select distinct profile 
from dba_profiles;

select * from view_tenprofile

-- ten role---------------------------------------------------------------------
create or REPLACE view tennhom 
as select role 
from sys.dba_roles 
where oracle_maintained='N';

select * from tennhom
commit

-- in taouser
create or REPLACE view view_taouser 
as select username,password,default_tablespace,profile,account_status, created, last_login 
from sys.dba_users;

select * from view_taouser
SELECT * FROM dba_tab_privs where grantee like '%IX%'
-- xem ten tablespace-----------------------------------------------------------
create or REPLACE view view_tentablespace 
as Select name 
from sys.v$tablespace;

select * from view_tentablespace;

--hien thi ten cac user hien co-------------------------------------------------
create or replace view xemtenuserhienco 
as select username 
from sys.dba_users order by username asc

select * from xemtenuserhienco

--xem các policy hien co--------------------------------------------------------
select * from dba_audit_policies

create or replace view xempolicy 
as select object_schema,object_name,policy_owner,policy_name,enabled,sel,ins,upd,del 
from dba_audit_policies;

select * from xempolicy;

--xem giám sát------------------------------------------------------------------
create or replace view xemgiamsat 
as select timestamp,db_user,userhost,object_schema,object_name,policy_name,sql_text,statement_type 
from dba_fga_audit_trail;

select * from xemgiamsat

--xem quá tr?nh ghi log trong ngày
create or replace view xemgiamsattrongngay 
as select * 
from sys.fga_log$ 
where ntimestamp#> SYSDATE - 1 order by ntimestamp# DESC;

select * from xemgiamsattrongngay;

--
create or replace view tenhomdatao as select role 
from dba_roles 
where oracle_maintained = 'N';

select * from tenhomdatao;

-- Xem quyen tren nhom quyen ---------------------------------------------------
create or replace view view_xemttinnhomquyen as select * from sys.dba_sys_privs 
where grantee in (select role from sys.dba_roles where common='NO')
order by grantee asc ;

select * from view_xemttinnhomquyen;